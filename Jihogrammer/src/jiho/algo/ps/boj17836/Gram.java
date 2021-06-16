package jiho.algo.ps.boj17836;

import java.util.LinkedList;
import java.util.Queue;

class Gram {

    private static int N, M, T;
    private static final int BIT = 7, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        T = read();

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = (char) System.in.read();
                System.in.read();
            }
            System.in.read(); // LF - 제출 시 제거
        }

        int time = bfs(map);
        System.out.println(time > 0 ? time : "Fail");

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static int bfs(char[][] map) {

        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][3];

        visited[0][0][0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {

            time += 1;
            if (time > T)
                break;

            int qsize = queue.size();

            while (qsize-- > 0) {

                int state = queue.poll();

                int x = state & MASK;
                int y = (state >>= BIT) & MASK;
                int z = (state >>= BIT) & MASK;

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nz = z;

                    if (isOut(nx, ny) || visited[nx][ny][nz])
                        continue;

                    if (map[nx][ny] == '1') {
                        if (nz == 0)
                            continue;
                        nz = 2;
                    }

                    if (nx + 1 == N && ny + 1 == M)
                        return time;

                    if (map[nx][ny] == '2') {
                        visited[nx][ny][nz] = true;
                        nz = 1;
                    }

                    visited[nx][ny][nz] = true;
                    queue.offer(encode(nx, ny, nz));

                }

            }

        }

        return -1;

    }

    private static int encode(int x, int y, int z) {
        return z << BIT << BIT | y << BIT | x;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x == N || y == M;
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
