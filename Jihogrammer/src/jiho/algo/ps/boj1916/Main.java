package jiho.algo.ps.boj1916;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    private static int N, M;

    private static final int BIT = 10, MASK = ~(-1 << BIT), INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++)
            graph.get(read()).add(bind(read(), read()));

        int[] cost = new int[N + 1];
        int start = read();
        int end = read();

        dijkstra(start, graph, cost);

        System.out.println(cost[end]);

    }

    private static void dijkstra(int s, List<List<Integer>> graph, int[] cost) {

        for (int i = 1; i <= N; i++)
            cost[i] = INF;
        cost[s] = 0;

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(bind(s, 0));

        while (!queue.isEmpty()) {

            int v = queue.poll() & MASK;

            if (visited[v])
                continue;

            visited[v] = true;

            List<Integer> adjList = graph.get(v);

            for (Integer state : adjList) {

                int w = state & MASK;
                int c = (state >> BIT) + cost[v];

                if (cost[w] > c) {
                    cost[w] = c;
                    queue.offer(bind(w, c));
                }

            }

        }

    }

    private static int bind(int w, int k) {
        return k << BIT | w;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read(); // LF
        return n;
    }

}
