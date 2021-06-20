package jiho.algo.ps.boj11403;

class MyArrayListMyQueue {

    private static int N;

    public static void main(String[] args) throws Exception {

        N = read();
        char[][] map = new char[N][N << 1];
        int[][] graph = new int[N + 1][7];
        graph[N] = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // if ((map[i][j << 1] = (char) System.in.read()) == '1') {
                if (System.in.read() == 49) {

                    int k = graph[N][i]++;
                    int len = graph[i].length;

                    if (k == len)
                        expand(graph, i, len);

                    graph[i][k] = j;

                } else
                    map[i][j << 1] = '0';

                map[i][(j << 1) + 1] = System.in.read() == '\r' ? '\n' : ' ';
                // map[i][(j << 1) + 1] = (char) System.in.read();

            }
            System.in.read(); // LF - 제출 시 제거
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(graph, map, sb);

        System.out.print(sb);

    }

    private static void dijkstra(int[][] graph, char[][] map, StringBuilder sb) {

        // int vlen = (N >> 5) + 1;
        // int[] visited = new int[vlen];

        // int B = 5, M = 31;
        int Q = 127, offer = -1, poll = -1;
        int[] queue = new int[Q + 1];

        for (int i = 0; i < N; i++) {

            // for (int j = 0; j < vlen; j++)
            // visited[j] = 0;

            queue[++offer & Q] = i;

            while (offer != poll) {

                int v = queue[++poll & Q];

                for (int j = 0; j < graph[N][v]; j++) {

                    int w = graph[v][j];

                    if (map[i][w << 1] == '1')
                        continue;

                    // if ((visited[w >> B] & (1 << (w & M))) != 0)
                    // continue;

                    map[i][w << 1] = '1';
                    // visited[w >> B] |= 1 << (w & M);
                    queue[++offer & Q] = w;

                }

            }

            sb.append(map[i]);

        }

    }

    private static void expand(int[][] graph, int row, int len) {

        int[] temp = graph[row];

        graph[row] = new int[len << 1];

        for (int i = 0; i < len; i++)
            graph[row][i] = temp[i];

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
