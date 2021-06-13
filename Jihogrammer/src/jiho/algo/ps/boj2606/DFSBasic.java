package jiho.algo.ps.boj2606;

import java.util.ArrayList;
import java.util.List;

class DFSBasic {

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

        int cnt = dfs(graph, V, E);
        System.out.print(cnt);

    }

    private static int dfs(List<List<Integer>> graph, int V, int E) {

        int cnt = 0;
        boolean[] visited = new boolean[V + 1];

        List<Integer> adjList;

        int top = -1;
        int[] stack = new int[E];

        visited[1] = true;
        stack[++top] = 1;

        while (top >= 0) {

            int v = stack[top--];

            adjList = graph.get(v);

            for (Integer w : adjList) {

                if (visited[w])
                    continue;

                cnt += 1;
                visited[w] = true;
                stack[++top] = w;

            }

        }

        return cnt;

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
