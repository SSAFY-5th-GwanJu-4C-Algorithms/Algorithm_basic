package jiho.algo.ps.boj1261;

import java.util.PriorityQueue;

class Main {

    private static int M, N;
    private static final int INF = 200;

    public static void main(String[] args) throws Exception {

        M = read();
        N = read();

        boolean[][] maze = new boolean[N][M];
        int[][] dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (System.in.read() == '1')
                    maze[i][j] = true;
                dist[i][j] = INF;
            }
            System.in.read();
            System.in.read();
        }

        dijkstra(maze, dist);
        System.out.println(dist[N - 1][M - 1]);

    }

    private static final int BIT = 7, MASK = ~(-1 << BIT);
    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void dijkstra(boolean[][] maze, int[][] dist) {

        boolean[][] visited = new boolean[N][M];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(0);
        dist[0][0] = 0;
        visited[0][0] = true;

        while (!pq.isEmpty()) {

            int w = pq.poll();
            int x = (w >>= BIT) & MASK;
            int y = (w >>= BIT) & MASK;
            w >>= BIT;

            if (x + 1 == M && y + 1 == N)
                return;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx])
                    continue;

                int nw = maze[ny][nx] ? 1 : 0;

                if (dist[ny][nx] > dist[y][x] + nw) {
                    dist[ny][nx] = dist[y][x] + nw;
                    visited[ny][nx] = true;
                    pq.offer(encode(w + nw, nx, ny));
                }

            }

        }

    }

    private static int encode(int w, int x, int y) {
        return (x | (y | w << BIT) << BIT) << BIT;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read(); // LF
        return n;
    }

}
