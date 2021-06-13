package jiho.algo.ps.boj2606;

import java.util.ArrayList;
import java.util.List;

class DFSRecursive {

    private static int count;
    private static List<Integer> adjList;

    public static void main(String[] args) throws Exception {

        int V = read();
        int E = read();

        List<List<Integer>> graph = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int a = read();
            int b = read();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1, graph, new boolean[V + 1]);
        System.out.print(count - 1);

    }

    private static void dfs(int v, List<List<Integer>> graph, boolean[] visited) {

        if (visited[v])
            return;

        count += 1;
        visited[v] = true;

        adjList = graph.get(v);

        for (Integer w : adjList)
            dfs(w, graph, visited);

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
