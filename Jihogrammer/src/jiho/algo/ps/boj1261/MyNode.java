package jiho.algo.ps.boj1261;

import java.util.PriorityQueue;

class MyNode {

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
            System.in.read(); // CR - 제출 시 제거
            System.in.read(); // LF
        }

        dijkstra(maze, dist);
        System.out.print(dist[N - 1][M - 1]);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static void dijkstra(boolean[][] maze, int[][] dist) {

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0][0] = 0;
        visited[0][0] = true;
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();
            int w = now.getW();
            int x = now.getX();
            int y = now.getY();

            if (x + 1 == M && y + 1 == N)
                return;

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[ny][nx])
                    continue;

                int nw = maze[ny][nx] ? 1 : 0;
                int nd = dist[y][x] + nw;

                if (dist[ny][nx] > nd) {
                    dist[ny][nx] = nd;
                    visited[ny][nx] = true;
                    pq.offer(new Node(nx, ny, w + nw));
                }

            }

        }

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
