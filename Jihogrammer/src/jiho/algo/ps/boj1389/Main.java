package jiho.algo.ps.boj1389;

class Main {

    private static int N, M;
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            map[a][b] = map[b][a] = 1;
        }

        for (int v = 1; v <= N; v++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {

                    int cost = map[s][v] + map[v][e];
                    if (map[s][e] > cost)
                        map[s][e] = cost;

                }
            }
        }

        int min = INF;
        int idx = 0;
        for (int i = N; i > 0; i--) {
            int num = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j)
                    num += map[i][j];
            }
            if (min >= num) {
                min = num;
                idx = i;
            }
        }

        System.out.println(idx);

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
