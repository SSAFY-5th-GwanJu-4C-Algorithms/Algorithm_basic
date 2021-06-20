package jiho.algo.ps.boj11403;

class Main {

    private static int N;
    private static final int B = 5, M = 31;

    public static void main(String[] args) throws Exception {

        N = read();

        int[][] map = new int[N][(N >> B) + 1];
        char[][] result = new char[N][];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append('0').append(' ');

        final String format = sb.toString();
        for (int i = 0; i < N; i++)
            result[i] = format.toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (System.in.read() == '1') {
                    map[i][j >> B] |= 1 << (j & M);
                    result[i][j << 1] = '1';
                }
                System.in.read();
            }
            System.in.read();
        }

        floydWarshall(map, result);

        sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(result[i]).append('\n');

        System.out.print(sb);

    }

    private static void floydWarshall(int[][] map, char[][] result) {

        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    boolean a = isPossible(s, k, map);
                    boolean b = isPossible(k, e, map);
                    if (a && b) {
                        map[s][e >> B] |= 1 << (e & M);
                        result[s][e << 1] = '1';
                    }
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
