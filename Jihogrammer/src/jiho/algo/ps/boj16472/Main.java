package jiho.algo.ps.boj16472;

class Main {

    private static int max, kind, l, r, length, sequence;

    public static void main(String[] args) throws Exception {

        int c, N = read();
        int[] meow = new int[100000];
        int[] select = new int[27];

        while ((c = System.in.read()) > 32) {

            meow[length++] = c &= 31;

            if (++select[c] == 1)
                kind++;

            while (kind > N)
                if (--select[meow[l++]] == 0)
                    kind--;

            sequence = ++r - l;

            if (max < sequence)
                max = sequence;

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
