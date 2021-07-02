package jiho.algo.ps.boj1922.prim;

class Array {

    private static final int BIT = 10, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[][] graph = new int[N + 1][16];
        graph[0] = new int[N + 1];

        while (M-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            add(graph, v, w, c);
            add(graph, w, v, c);

        }

        System.out.print(prim(N, graph));

    }

    private static int prim(int N, int[][] graph) {

        int mst = 0;

        Visited vs = new Visited(N);
        Heap pq = new Heap();
        int[] adjList;

        pq.offer(1);

        while (!pq.isEmpty()) {

            int state = pq.poll();
            int v = state & MASK;

            if (vs.isVisited(v))
                continue;
            vs.check(v);

            mst += state >> BIT;
            adjList = graph[v];
            int size = graph[0][v];

            for (int i = 1; i <= size; i++)
                pq.offer(adjList[i]);

        }

        return mst;

    }

    private static void add(int[][] graph, int v, int w, int c) {

        int size = ++graph[0][v];
        int len = graph[v].length;

        if (size == len)
            expand(graph, v, len);

        graph[v][size] = encode(w, c);

    }

    private static void expand(int[][] graph, int v, int len) {

        int[] tmp = graph[v];
        int[] arr = graph[v] = new int[len << 1];

        for (int i = 0; i < len; i++)
            arr[i] = tmp[i];

    }

    private static int encode(int v, int c) {
        return c << BIT | v;
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        if (c == 13)
            System.in.read();

        return n;

    }

}
