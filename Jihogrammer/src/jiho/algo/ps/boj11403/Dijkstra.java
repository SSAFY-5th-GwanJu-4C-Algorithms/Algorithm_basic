package jiho.algo.ps.boj11403;

import java.util.LinkedList;
import java.util.Queue;

class Dijkstra {

    public static void main(String[] args) throws Exception {

        int N = read();

        char[][] map = new char[N][N << 1];

        int[][] graph = new int[N + 1][7];
        graph[N] = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if ((map[i][j << 1] = (char) System.in.read()) == '1') {

                    int k = graph[N][i];
                    int len = graph[i].length;

                    if (k == len)
                        expand(graph, i, len);

                    graph[i][k] = j;
                    graph[N][i]++;

                }

                map[i][(j << 1) + 1] = System.in.read() == 13 ? '\n' : 32;

            }
            System.in.read();
        }

        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int[] adjList;
        for (int i = 0; i < N; i++) {

            boolean[] visited = new boolean[N];
            queue.offer(i);

            while (!queue.isEmpty()) {

                int v = queue.poll();

                adjList = graph[v];

                for (int j = 0; j < graph[N][v]; j++) {

                    int w = adjList[j];

                    if (visited[w])
                        continue;

                    visited[w] = true;
                    map[i][w << 1] = '1';
                    queue.offer(w);

                }

            }

            sb.append(map[i]);

        }

        System.out.print(sb);

    }

    private static void expand(int[][] graph, int row, int len) {

        int[] temp = graph[row];

        graph[row] = new int[len << 1];

        for (int i = 0; i < len; i++)
            graph[row][i] = temp[i];

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
