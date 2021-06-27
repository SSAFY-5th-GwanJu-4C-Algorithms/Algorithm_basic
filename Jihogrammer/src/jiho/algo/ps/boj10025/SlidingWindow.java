package jiho.algo.ps.boj10025;

class SlidingWindow {

    private static int MAX = 1000001;

    public static void main(String[] args) throws Exception {

        int N = read(), K = read(), sum = 0, max = 0, d = (K << 1) + 1;
        int[] ice = new int[MAX];

        while (N-- > 0) {
            int g = read();
            int x = read();
            ice[x] = g;
            if (max < x)
                max = x;
        }

        if (d >= MAX)
            d = MAX;

        for (int i = 0; i < d; i++)
            sum += ice[i];

        MAX = max + 1;
        max = sum;

        if (d < MAX)
            for (int i = d; i < MAX; i++)
                if (max < (sum = sum - ice[i - d] + ice[i]))
                    max = sum;

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
