package jiho.algo.ps.boj2606;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DFSStack {

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

        int result = dfs(graph);
        System.out.print(result);

    }

    private static int dfs(List<List<Integer>> graph) {

        int worm = 0;
        boolean[] visited = new boolean[graph.size()];

        Stack<Integer> stack = new Stack<>();

        visited[1] = true;
        stack.push(1);

        while (!stack.isEmpty()) {

            int v = stack.pop();
            List<Integer> adjList = graph.get(v);

            for (Integer w : adjList) {

                if (visited[w])
                    continue;

                worm += 1;
                visited[w] = true;
                stack.push(w);

            }

        }

        return worm;
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
