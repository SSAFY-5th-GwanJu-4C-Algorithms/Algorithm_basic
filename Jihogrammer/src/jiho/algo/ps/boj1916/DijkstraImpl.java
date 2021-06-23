package jiho.algo.ps.boj1916;

import java.util.ArrayList;
import java.util.List;

import jiho.algo.basic.dijkstra.Dijkstra;

class DijkstraImpl {

    private static int N, M;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++)
            graph.get(read()).add(read() | read() << 10);

        Dijkstra dijkstra = new Dijkstra(graph, 10);

        int result = dijkstra.run(read(), read());
        System.out.println(result);

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
