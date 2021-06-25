package jiho.algo.ps.boj3078;

class NbyN {

    private static int N, K;
    private static final int BIT = 3, MASK = ~(-1 << BIT);
    private static final int B = 2, M = ~(-1 << B);

    public static void main(String[] args) throws Exception {

        N = read();
        K = read();

        int[] friends = new int[(N >> B) + 1];

        for (int i = 0; i < N; i++) {

            int c, len = 0;

            while ((c = System.in.read()) > 32)
                len += 1;

            if (c == 13)
                System.in.read();

            friends[i >> B] |= len << ((i & M) << BIT);

        }

        int pair = 0;

        int setNum = N - K + 1;

        for (int i = 0; i < N - 1; i++) {

            int setSize = i < setNum ? K + 1 : K + setNum - i;
            int now = (friends[i >> B] >> ((i & M) << BIT)) & MASK;

            for (int j = 1; j < setSize; j++) {

                int k = i + j;
                int cmp = (friends[k >> B] >> ((k & M) << BIT)) & MASK;

                if (now == cmp)
                    pair += 1;

            }

        }

        System.out.print(pair);

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
