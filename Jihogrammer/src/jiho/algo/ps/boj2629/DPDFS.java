package jiho.algo.ps.boj2629;

class DPDFS {

    private static int N;

    public static void main(String[] args) throws Exception {

        N = read();
        int[] weights = new int[N];

        int sum = 1;
        for (int i = 0; i < N; i++)
            sum += weights[i] = read();

        int[] memo = new int[sum];

        dfs(0, 0, 0, weights, memo);

        StringBuilder sb = new StringBuilder();
        int M = read();
        for (int i = 0; i < M; i++) {
            int bead = read();
            if (bead < sum) {
                boolean isPossible = (memo[bead] & (1 << N)) != 0;
                if (isPossible)
                    sb.append('Y');
                else
                    sb.append('N');
            } else {
                sb.append('N');
            }
            sb.append(' ');
        }

        System.out.print(sb);

    }

    private static void dfs(int level, int left, int right, int[] weights, int[] memo) {

        int weight = right - left;
        if (weight < 0)
            weight = ~weight + 1;

        if ((memo[weight] & (1 << level)) != 0)
            return;

        memo[weight] |= 1 << level;

        if (level == N)
            return;

        dfs(level + 1, left + weights[level], right, weights, memo);
        dfs(level + 1, left, right + weights[level], weights, memo);
        dfs(level + 1, left, right, weights, memo);

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
