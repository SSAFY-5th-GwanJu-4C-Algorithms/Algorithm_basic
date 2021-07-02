package jiho.algo.ps.boj1197.prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LongValue {

    private static final int BIT = 32, MASK = -1;

    public static void main(String[] args) throws Exception {

        int N = read();
        int E = read();

        List<List<Long>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        while (E-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph.get(v).add(encode(w, c));
            graph.get(w).add(encode(v, c));

        }

        long mst = prim(graph, N);

        System.out.print(mst);

    }

    private static long prim(List<List<Long>> graph, int N) {

        long mst = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.offer(1L);

        while (!pq.isEmpty()) {

            long state = pq.poll();
            int v = (int) (state & MASK);

            if (visited[v])
                continue;
            visited[v] = true;

            mst += state >> BIT;

            for (Long w : graph.get(v))
                pq.offer(w);

        }

        return mst;

    }

    private static long encode(int v, int c) {
        return (long) c << BIT | v;
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
