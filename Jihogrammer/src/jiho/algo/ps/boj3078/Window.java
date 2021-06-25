package jiho.algo.ps.boj3078;

class Window {

    public static void main(String[] args) throws Exception {

        int N = read(), K = read(), x = 0;
        long pair = 0;

        int[] window = new int[19];
        int[] len = new int[N];

        for (int i = 0; i < N; i++)
            len[i] = readLine();

        for (int i = 0; i < K; i++) {
            if (x < N) {
                window[len[x++]]++;
            }
        }

        for (int i = 0; i < N; i++) {

            if (x < N) {
                window[len[x++]]++;
            }

            pair += --window[len[i]];
        }

        System.out.print(pair);

    }

    private static int readLine() throws Exception {
        int c, l = -2;
        while ((c = System.in.read()) > 32)
            l++;
        if (c == 13)
            System.in.read();
        return l;
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
