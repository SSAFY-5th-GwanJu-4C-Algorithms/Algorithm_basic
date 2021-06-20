package jiho.algo.ps.boj11403;

class CharArray {

    private static int N;

    public static void main(String[] args) throws Exception {

        char[][] map = new char[N = read()][N << 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j << 1] = (char) System.in.read();
                map[i][(j << 1) + 1] = System.in.read() == 13 ? '\n' : 32;
            }
            System.in.read();
        }

        floydWarshall(map);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(map[i]);

        System.out.print(sb);

    }

    private static void floydWarshall(char[][] map) {

        for (int k = 0; k < N; k++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (map[s][k << 1] == '1' && map[k][e << 1] == '1')
                        map[s][e << 1] = '1';
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