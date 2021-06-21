package jiho.algo.ps.boj11404;

class Floyd {

    public static void main(String[] args) throws Exception {

        final int INF = Integer.MAX_VALUE >> 1, N = read() + 1, M = read();
        int[][] map = new int[N][N];

        for (int i = 1; i < N; i++)
            for (int j = 1; j < N; j++)
                map[i][j] = INF;

        for (int bus = 0; bus < M; bus++) {

            int i = read();
            int j = read();
            int k = read();

            if (map[i][j] > k)
                map[i][j] = k;

        }

        for (int v = 1; v < N; v++) {
            for (int s = 1; s < N; s++) {

                if (s == v)
                    continue;

                for (int e = 1; e < N; e++) {

                    if (s == e || e == v)
                        continue;

                    int cost = map[s][v] + map[v][e];

                    if (map[s][e] > cost)
                        map[s][e] = cost;

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int cost = map[i][j];
                sb.append(cost == INF ? 0 : cost).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);

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
