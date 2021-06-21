package jiho.algo.ps.boj11404;

class DijkstraMatrix {

    private static int N;
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {

        N = read();

        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                map[i][j] = INF;

        int M = read();

        for (int bus = 0; bus < M; bus++) {

            int i = read();
            int j = read();
            int c = read();

            if (map[i][j] > c)
                map[i][j] = c;

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            dijkstra(map, i);
            for (int j = 1; j <= N; j++) {
                int cost = map[i][j];
                sb.append(cost < INF ? cost : 0).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static void dijkstra(int[][] map, int s) {

        map[s][s] = 0;
        int[] visited = new int[(N >> 5) + 1];

        for (int i = 1; i < N; i++) {

            int min = INF;
            int v = -1;

            for (int w = 1; w <= N; w++) {
                if ((visited[w >> 5] & (1 << (w & 31))) != 0)
                    continue;
                if (min > map[s][w]) {
                    min = map[s][w];
                    v = w;
                }
            }

            if (v < 0)
                break;
            visited[v >> 5] |= 1 << (v & 31);

            for (int e = 1; e <= N; e++) {
                if ((visited[e >> 5] & (1 << (e & 31))) != 0)
                    continue;
                int c = map[s][v] + map[v][e];
                if (map[s][e] > c) {
                    map[s][e] = c;
                }
            }

        }

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