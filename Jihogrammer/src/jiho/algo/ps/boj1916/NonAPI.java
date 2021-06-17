package jiho.algo.ps.boj1916;

class NonAPI {

    private static int N, M;

    private static final int BIT = 10, MASK = ~(-1 << BIT), INF = Integer.MAX_VALUE >> 1;
    private static final int SIZE = 0;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        // 0번 인덱스, 즉 0행은 배열의 size를 저장한다.
        int[][] graph = new int[N + 1][4];

        graph[SIZE] = new int[N + 1];

        for (int i = 0; i < M; i++) {

            int v = read();
            int w = read();
            int c = read();

            int s = graph[SIZE][v]++;
            if (s >= graph[v].length)
                graph[v] = expand(graph[v]);

            graph[v][s] = encode(w, c);

        }

        int[] cost = new int[N + 1];
        int v = read();
        int w = read();

        dijkstra(v, graph, cost);

        System.out.print(cost[w]);

    }

    private static void dijkstra(int v, int[][] graph, int[] cost) {

        for (int i = 1; i <= N; i++)
            cost[i] = INF;
        cost[v] = 0;

        boolean[] visited = new boolean[N + 1];

        int[] pq = new int[3];
        pq = offer(pq, v);

        while (pq[SIZE] > 0) {

            v = poll(pq) & MASK;

            if (visited[v])
                continue;
            visited[v] = true;

            for (int i = 0; i < graph[SIZE][v]; i++) {

                int w = graph[v][i] & MASK;
                int c = (graph[v][i] >> BIT) + cost[v];

                if (cost[w] > c)
                    pq = offer(pq, encode(w, cost[w] = c));

            }

        }

    }

    private static int poll(int[] pq) {

        int i = 1;
        int v = pq[i];
        pq[i] = pq[pq[SIZE]--];

        while ((i <<= 1) <= pq[SIZE]) {

            if (i < pq[SIZE] + 1 && pq[i] > pq[i + 1])
                i++;

            if (!swap(pq, i))
                break;

        }

        return v;

    }

    private static int[] offer(int[] pq, int v) {

        int size = ++pq[SIZE];
        if (size >= pq.length)
            pq = expand(pq);

        pq[size] = v;

        while (size > 1) {

            if (!swap(pq, size))
                break;

            size >>= 1;

        }

        return pq;

    }

    private static boolean swap(int[] a, int i) {

        int j = i >> 1;
        int p = a[j];
        int c = a[i];

        if (p < c)
            return false;

        a[i] = p;
        a[j] = c;

        return true;

    }

    private static int encode(int w, int c) {
        return c << BIT | w;
    }

    private static int[] expand(int[] a) {

        int[] t = a;
        int s = t.length;

        a = new int[s + (s >> 1)];

        for (int i = 0; i < s; i++)
            a[i] = t[i];

        return a;

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read(); // LF
        return n;
    }

}
