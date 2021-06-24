package jiho.algo.basic.floydwarshall;

public class FloydWarshall {

    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        int[][] distance = new int[N + 1][N + 1];

        for (int v = 1; v <= N; v++)
            for (int w = 1; w <= N; w++)
                distance[v][w] = INF;

        for (int edge = 0; edge < M; edge++) {

            int v = read();
            int w = read();

            distance[v][w] = distance[w][v] = 1;

        }

        for (int u = 1; u <= N; u++) {
            for (int v = 1; v <= N; v++) {
                for (int w = 1; w <= N; w++) {
                    int dist = distance[v][u] + distance[u][w];
                    if (distance[v][w] > dist)
                        distance[v][w] = dist;
                }
            }
        }

        int max = 0;

        for (int v = 1; v <= N; v++) {
            for (int w = 1; w <= N; w++) {
                if (max < distance[v][w] && distance[v][w] < INF)
                    max = distance[v][w];
            }
        }

        System.out.print(max);

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
