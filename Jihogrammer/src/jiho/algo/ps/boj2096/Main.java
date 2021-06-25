package jiho.algo.ps.boj2096;

class Main {

    private static final long BIT = 32, MASK = ~0L >>> BIT;

    public static void main(String[] args) throws Exception {

        int c, N = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            N = (N << 3) + (N << 1) + (c & 15);
        if (c == 13)
            System.in.read();

        long[][] map = new long[N][3];

        for (int stair = 0; stair < N; stair++) {

            for (int num = 0; num < 3; num++) {
                c = System.in.read() & 15;
                map[stair][num] = c | (long) c << BIT;
                System.in.read();
            }

            System.in.read(); // 제출 시 제거

        }

        int min, max;
        long num;

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < 3; j++) {

                min = 987654321;
                max = 0;

                for (int k = j - 1; k <= j + 1; k++) {

                    if (k < 0 || k == 3)
                        continue;

                    num = map[i - 1][k] >> BIT;
                    if (min > num)
                        min = (int) num;

                    num = map[i - 1][k] & MASK;
                    if (max < num)
                        max = (int) num;

                }

                long a = (map[i][j] >> BIT) + min;
                long b = (map[i][j] & MASK) + max;

                map[i][j] = a << BIT | b;

            }

        }

        min = 987654321;
        max = 0;

        for (int i = 0; i < 3; i++) {
            num = map[N - 1][i] >> BIT;
            if (min > num)
                min = (int) num;

            num = map[N - 1][i] & MASK;
            if (max < num)
                max = (int) num;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append(' ').append(min);
        System.out.print(sb);

    }

}
