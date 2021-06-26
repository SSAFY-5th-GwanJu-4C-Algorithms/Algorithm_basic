package jiho.algo.ps.boj10025;

class Main {

    private static int MAX = 1000001;

    public static void main(String[] args) throws Exception {

        int N = read(), K = read(), sum, max = 0, d = (K << 1) + 1;
        int[] ice = new int[MAX];

        for (int i = 0; i < N; i++) {
            int g = read();
            int x = read();
            ice[x] = g;
            if (max < x)
                max = x;
        }

        MAX = max;
        sum = max = 0;

        for (int i = 0; i < MAX; i++) {

            if (i >= d)
                sum -= ice[i - d];

            sum += ice[i];

            if (max < sum)
                max = sum;

        }

        System.out.print(max);

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
