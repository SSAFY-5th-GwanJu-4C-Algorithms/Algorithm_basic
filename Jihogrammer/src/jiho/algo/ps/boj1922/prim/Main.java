package jiho.algo.ps.boj1922.prim;

import java.util.ArrayList;
import java.util.List;

class Main {

    private static final int BIT = 10, MASK = ~(-1 << BIT), B = 5, M = 31;

    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        while (M-- > 0) {

            int v = read();
            int w = read();
            int c = read();

            graph.get(v).add(encode(w, c));
            graph.get(w).add(encode(v, c));

        }

        int mst = prim(N, graph);

        System.out.print(mst);

    }

    private static int prim(int N, List<List<Integer>> graph) {

        int mst = 0;

        int[] visited = new int[(N >> B) + 1];
        List<Integer> adjList;

        Heap pq = new Heap();
        pq.offer(1);

        while (!pq.isEmpty()) {

            int state = pq.poll();
            int v = state & MASK;

            if (((visited[v >> B] >> (v & M)) & 1) == 1)
                continue;
            visited[v >> B] |= 1 << (v & M);

            adjList = graph.get(v);
            mst += state >> BIT;

            for (int s : adjList)
                pq.offer(s);

        }

        return mst;

    }

    private static int encode(int v, int c) {
        return c << BIT | v;
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
