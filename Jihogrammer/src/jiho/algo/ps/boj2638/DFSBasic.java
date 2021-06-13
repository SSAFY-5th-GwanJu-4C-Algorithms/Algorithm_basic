package jiho.algo.ps.boj2638;

import java.util.LinkedList;
import java.util.Queue;

public class DFSBasic {

    private static int N, M;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        boolean[][] cheese = new boolean[N][M];
        // boolean[][][] visited = new boolean[N][M][3];
        Queue<Integer> queue = new LinkedList<>();

        int hours = 0;
        int cheeseNum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (read() == 1) {
                    cheese[i][j] = true;
                    cheeseNum += 1;
                }
            }
        }

        while (cheeseNum > 0) {
            dfs(0, 0, cheese, new boolean[N][M][3], queue);
            cheeseNum -= queue.size();
            melt(cheese, queue);
            hours += 1;
        }

        System.out.print(hours);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };
    private static final int V = 0, S1 = 1, S2 = 2; // SIDE
    private static final int BIT = 8, MASK = ~(-1 << BIT); // Bitwise Binding

    private static void dfs(int x, int y, boolean[][] cheese, boolean[][][] visited, Queue<Integer> queue) {

        visited[x][y][V] = true;

        for (int d = 0; d < 4; d++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx == N || ny == M)
                continue;

            // 치즈 만났을 경우
            if (cheese[nx][ny]) {
                if (visited[nx][ny][S1]) {
                    if (!visited[nx][ny][S2]) {
                        queue.offer(encode(nx, ny));
                        visited[nx][ny][S2] = true;
                    }
                } else {
                    visited[nx][ny][S1] = true;
                }
                continue;
            }

            if (visited[nx][ny][V])
                continue;

            dfs(nx, ny, cheese, visited, queue);

        }

    }

    private static void melt(boolean[][] cheese, Queue<Integer> queue) {

        while (!queue.isEmpty()) {

            int state = queue.poll();
            int x = state >> BIT;
            int y = state & MASK;

            cheese[x][y] = false;

        }

    }

    private static int encode(int a, int b) {
        return a << BIT | b;
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
