package jiho.algo.ps.boj2617;

class Main {

    private static final int INF = -1 >>> 3;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[][] graph = new int[N + 1][N + 1];

        for (int v = 1; v <= N; v++) {
            for (int w = 1; w <= N; w++) {
                graph[v][w] = INF;
            }
            graph[v][v] = 0;
        }

        for (int edge = 0; edge < M; edge++) {

            int v = read();
            int w = read();

            graph[v][w] = 1;

        }

        for (int v = 1; v <= N; v++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {

                    int num = graph[s][v] + graph[v][e];
                    if (graph[s][e] > num)
                        graph[s][e] = num;

                }
            }
        }

        int cnt = 0;
        int cmp = (N >> 1) + 1;

        for (int v = 1; v <= N; v++) {

            int a = 0;
            int b = 0;

            for (int w = 1; w <= N; w++) {

                if (graph[v][w] < INF)
                    a += graph[v][w];

                if (graph[w][v] < INF)
                    b += graph[w][v];

            }

            if (a > cmp || b > cmp)
                cnt++;

        }

        System.out.println(cnt);

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
