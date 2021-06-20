package jiho.algo.ps.boj11403;

class Main2 {

    private static int N;
    private static final int B = 5, M = 31;
    private static final char O = 49, S = 32, L = 10;

    public static void main(String[] args) throws Exception {

        N = read();

        int[][] map = new int[N][(N >> B) + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (System.in.read() == O)
                    map[i][j >> B] |= 1 << (j & M);
                System.in.read();
            }
            System.in.read();
        }

        floydWarshall(map);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isPossible(i, j, map))
                    sb.append(1);
                else
                    sb.append(0);
                sb.append(S);
            }
            sb.append(L);
        }

        System.out.print(sb);

    }

    private static void floydWarshall(int[][] map) {

        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    boolean a = isPossible(s, k, map);
                    boolean b = isPossible(k, e, map);
                    if (a && b)
                        map[s][e >> B] |= 1 << (e & M);
                }
            }
        }

    }

    private static boolean isPossible(int a, int b, int[][] map) {
        return (map[a][b >> B] & (1 << (b & M))) != 0;
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
