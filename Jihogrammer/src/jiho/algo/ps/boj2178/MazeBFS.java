package jiho.algo.ps.boj2178;

class MazeBFS {

    private static int N, M;

    private static final int BIT = 7, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        boolean[][] maze = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (System.in.read() == '0') {
                    maze[i][j] = true;
                }
            }
            System.in.read(); // CR - 제출 시 제거
            System.in.read(); // LF
        }

        int move = bfs(maze);
        System.out.print(move);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static int bfs(boolean[][] maze) {

        int move = 1;

        int queueEnd = N * M;
        int[] queue = new int[queueEnd];
        int offer = 0;
        int poll = -1;

        queue[offer] = 0;

        while (offer != poll) {

            move += 1;

            int qsize = getSize(offer, poll, queueEnd);

            while (qsize-- > 0) {

                if (++poll == queueEnd)
                    poll = 0;
                int pos = queue[poll];
                int x = pos >> BIT;
                int y = pos & MASK;

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (isOut(nx, ny) || maze[nx][ny])
                        continue;

                    if (nx + 1 == N && ny + 1 == M)
                        return move;

                    maze[nx][ny] = true;

                    if (++offer == queueEnd)
                        offer = 0;
                    queue[offer] = encode(nx, ny);

                }

            }

        }

        return -1;

    }

    private static int getSize(int o, int p, int q) {
        return (o -= p) > 0 ? o : o + q;
    }

    private static int encode(int a, int b) {
        return a << BIT | b;
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
