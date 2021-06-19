package jiho.algo.ps.boj4485;

import java.util.PriorityQueue;

class Main {

    private static int N;
    private static final int BIT = 7, MASK = ~(-1 << BIT), INF = 1250;
    private static final String format = "Problem ", colon = ": ";

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        int problemCount = 0;

        int[][] cave, coin;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while ((N = read()) > 0) {

            sb.append(format).append(++problemCount).append(colon);

            cave = new int[N][N];
            coin = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cave[i][j] = System.in.read() & 15;
                    coin[i][j] = INF;
                    System.in.read();
                }
                System.in.read();
            }

            dijkstra(cave, coin, priorityQueue, new boolean[N][N]);

            sb.append(coin[N - 1][N - 1]).append('\n');

        }

        System.out.print(sb);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void dijkstra(int[][] cave, int[][] coin, PriorityQueue<Integer> pq, boolean[][] visited) {

        coin[0][0] = cave[0][0];
        visited[0][0] = true;
        pq.offer(0);

        while (!pq.isEmpty()) {

            int p = pq.poll();
            int x = p & MASK;
            int y = (p >> BIT) & MASK;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isOut(nx, ny) || visited[nx][ny])
                    continue;

                int dist = coin[x][y] + cave[nx][ny];

                if (coin[nx][ny] > dist) {
                    coin[nx][ny] = dist;
                    visited[nx][ny] = true;
                    pq.offer(encode(dist, nx, ny));
                }

            }

        }

    }

    private static int encode(int c, int x, int y) {
        return (c << BIT | y) << BIT | x;
    }

    private static boolean isOut(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
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
