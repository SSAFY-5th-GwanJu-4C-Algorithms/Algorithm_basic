package jiho.algo.ps.boj1916;

class Matrix {

    private static int N, M;

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {

            int v = read();
            int w = read();
            int c = read();

            if (graph[v][w] > c)
                graph[v][w] = c;

        }

        int v = read();
        int w = read();

        dijkstra(v, graph);
        System.out.print(graph[0][w]);

    }

    private static void dijkstra(int v, int[][] graph) {

        int[] cost = graph[0];
        cost[v] = 0;

        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {

            int min = INF;
            int idx = -1;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && cost[j] < min) {
                    min = cost[j];
                    idx = j;
                }
            }

            if (idx < 0)
                break;
            visited[idx] = true;

            for (int j = 1; j <= N; j++) {
                int c = cost[idx] + graph[idx][j];
                if (!visited[j] && graph[idx][j] < INF && cost[j] > c) {
                    cost[j] = c;
                }
            }

        }

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
