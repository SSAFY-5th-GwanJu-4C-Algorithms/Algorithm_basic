package jiho.algo.ps.boj2606;

class DFSStackByArray {

    public static void main(String[] args) throws Exception {

        int V = read();
        int E = read();

        boolean[][] graph = new boolean[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            int a = read();
            int b = read();
            graph[a][b] = true;
            graph[b][a] = true;
        }

        int computers = dfs(graph, V, E);
        System.out.print(computers);

    }

    private static int dfs(boolean[][] graph, int V, int E) {

        int worm = 0;
        boolean[] visited = new boolean[V + 1];

        int top = -1;
        int[] stack = new int[E];

        visited[1] = true;
        stack[++top] = 1;

        while (top >= 0) {

            int v = stack[top--];

            for (int i = 1; i <= V; i++) {
                if (visited[i])
                    continue;
                if (graph[v][i]) {
                    worm += 1;
                    visited[i] = true;
                    stack[++top] = i;
                }
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
