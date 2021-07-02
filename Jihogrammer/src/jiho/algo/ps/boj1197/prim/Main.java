package jiho.algo.ps.boj1197.prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int E = read();

        List<List<int[]>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        while (E-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph.get(v).add(new int[] { w, c });
            graph.get(w).add(new int[] { v, c });

        }

        long mst = prim(N, graph);

        System.out.print(mst);

    }

    private static long prim(int N, List<List<int[]>> graph) {

        long mst = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[N + 1];

        pq.offer(new int[] { 1, 0 });

        while (!pq.isEmpty()) {

            int[] state = pq.poll();
            int v = state[0];

            if (visited[v])
                continue;

            visited[v] = true;

            mst += state[1];

            for (int[] s : graph.get(v))
                pq.offer(s);

        }

        return mst;

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
