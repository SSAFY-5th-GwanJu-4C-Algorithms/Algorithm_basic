package jiho.algo.ps.boj1197.prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MyClass {

    public static void main(String[] args) throws Exception {

        int N = read();
        int E = read();

        List<List<Edge>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        while (E-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph.get(v).add(new Edge(w, c));
            graph.get(w).add(new Edge(v, c));

        }

        int mst = prim(N, graph);

        System.out.print(mst);

    }

    private static int prim(int N, List<List<Edge>> graph) {

        int mst = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.c - b.c);
        boolean[] visited = new boolean[N + 1];

        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {

            Edge state = pq.poll();
            int v = state.v;

            if (visited[v])
                continue;

            visited[v] = true;

            mst += state.c;

            for (Edge s : graph.get(v))
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

class Edge {

    int v, c;

    Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }

}