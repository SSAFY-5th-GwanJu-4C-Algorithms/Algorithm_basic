package jiho.algo.ps.boj1916;

import java.util.PriorityQueue;

class MyArrayList {

    private static int N, M;

    private static final int BIT = 10, MASK = ~(-1 << BIT), INF = Integer.MAX_VALUE;
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
                expand(graph, v);

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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(v);

        while (!pq.isEmpty()) {

            v = pq.poll() & MASK;

            if (visited[v])
                continue;

            visited[v] = true;

            int size = graph[SIZE][v];

            for (int i = 0; i < size; i++) {

                int w = graph[v][i] & MASK;
                int c = (graph[v][i] >> BIT) + cost[v];

                if (cost[w] > c)
                    pq.offer(encode(w, cost[w] = c));

            }

        }

    }

    private static int encode(int w, int c) {
        return c << BIT | w;
    }

    private static void expand(int[][] graph, int v) {

        int[] temp = graph[v];
        int size = temp.length;

        graph[v] = new int[size + (size >> 1)];

        for (int i = 1; i < size; i++)
            graph[v][i] = temp[i];

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
