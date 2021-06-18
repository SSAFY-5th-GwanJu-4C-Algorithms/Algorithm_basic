package jiho.algo.ps.boj17244;

class Umbrella {

    private static int N, M, E;
    private static final int BIT = 6, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        char[][] room = new char[M][N];
        long[] queue = new long[M * N << 1];
        long[][] visited = new long[32][M];
        int thingNum = 0;

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {

                char block = (char) System.in.read();

                if (block == 'S') {
                    visited[0][y] |= 1L << x;
                    queue[0] = encode(x, y, 0);
                    block = '.';
                } else if (block == 'X') {
                    E |= 1 << thingNum;
                    block = (char) ('a' + thingNum++);
                }

                room[y][x] = block;

            }
            System.in.read(); // CR - 제출 시 제거
            System.in.read(); // LF
        }

        int move = bfs(room, visited, queue);
        System.out.println(move);

    }

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static int bfs(char[][] room, long[][] visited, long[] queue) {

        int move = 0;

        int offer = 0;
        int poll = -1;
        int queueEnd = queue.length;

        while (offer != poll) {

            move += 1;

            int qsize = getQueueSize(offer, poll, queueEnd);

            while (qsize-- > 0) {

                if (++poll == queueEnd)
                    poll = 0;
                long state = queue[poll];

                int x = (int) (state & MASK);
                int y = (int) (state >> BIT) & MASK;
                int z = (int) (state >>= 32);

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nz = z;

                    if (isOut(nx, ny) || room[ny][nx] == '#' || (visited[nz][ny] & (1L << nx)) != 0)
                        continue;

                    if (room[ny][nx] == 'E') {
                        if (nz == E)
                            return move;
                        else
                            continue;
                    }

                    if (room[ny][nx] >= 'a') {
                        visited[nz][ny] |= 1L << nx;
                        int newThing = room[ny][nx] - 'a';
                        nz |= 1 << newThing;
                    }

                    visited[nz][ny] |= 1L << nx;

                    if (++offer == queueEnd)
                        offer = 0;
                    queue[offer] = encode(nx, ny, nz);

                }

            }

        }

        return -1;

    }

    private static int getQueueSize(int o, int p, int q) {
        return (o -= p) > 0 ? o : o + q;
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x == N || y == M;
    }

    private static long encode(int x, int y, long z) {
        return z << 32 | y << BIT | x;
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
