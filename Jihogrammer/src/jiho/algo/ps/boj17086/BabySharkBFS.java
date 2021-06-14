package jiho.algo.ps.boj17086;

class BabySharkBFS {

    private static int N, M;
    private static final int BIT = 6, MASK = ~(-1 << BIT);

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        long[] sea = new long[N];

        int[] babySharkList = new int[N * M];
        int offer = -1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (read() == 1) {
                    sea[x] |= 1L << y;
                    babySharkList[++offer] = encode(x, y);
                }
            }
        }

        int safeDist = bfs(sea, babySharkList, offer);
        System.out.print(safeDist);

    }

    private static final int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    private static final int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    private static int bfs(long[] sea, int[] queue, int offer) {

        int move = -1;

        int queueEnd = N * M;
        int poll = -1;

        while (offer != poll) {

            move += 1;

            int qsize = getSize(offer, poll, queueEnd);

            while (qsize-- > 0) {

                if (++poll == queueEnd)
                    poll = 0;
                int pos = queue[poll];

                int x = pos >> BIT;
                int y = pos & MASK;

                for (int d = 0; d < 8; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (isOut(nx, ny) || isVisited(sea, nx, ny))
                        continue;

                    sea[nx] |= 1L << ny;

                    if (++offer == queueEnd)
                        offer = 0;
                    queue[offer] = encode(nx, ny);

                }

            }

        }

        return move;

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

    private static boolean isVisited(long[] a, int x, int y) {
        return (a[x] & (1L << y)) != 0;
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