package jiho.algo.ps.boj2559;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read(), K = read(), sum = 0;
        int[] temp = new int[N];

        for (int i = 0; i < N; i++)
            temp[i] = read();

        for (int i = 0; i < K; i++)
            sum += temp[i];

        int max = sum;

        for (int i = K; i < N; i++) {
            sum = sum - temp[i - K] + temp[i];
            if (max < sum)
                max = sum;
        }

        System.out.print(max);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative)
            n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return isNegative ? ~n + 1 : n;
    }

}
