package jiho.algo.basic.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    private List<List<Integer>> graphList;
    private int[][] graphMatrix;
    private boolean isMatrix;
    private boolean[] visited;
    private int[] cost;
    private int N;
    private final int BIT, MASK;
    private final int INF = Integer.MAX_VALUE >> 1;

    public Dijkstra(int[][] graph, int bit) {
        BIT = bit;
        MASK = ~(-1 << BIT);
        isMatrix = true;
        N = graph.length;
        graphMatrix = graph;
        init();
    }

    public Dijkstra(List<List<Integer>> graph, int bit) {
        BIT = bit;
        MASK = ~(-1 << BIT);
        isMatrix = false;
        N = graph.size();
        graphList = graph;
        init();
    }

    private void init() {

        visited = new boolean[N];

        cost = new int[N];
        for (int i = 0; i < N; i++)
            cost[i] = INF;

        if (isMatrix)
            initMatrix();
        else
            initList();
    }

    private void initMatrix() {

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                graphMatrix[i][j] = INF;
            }
            cost[i] = INF;
            graphMatrix[i][i] = 0;
        }

    }

    private void initList() {
        for (int i = 0; i < N; i++) {
            graphList.add(new ArrayList<>());
            cost[i] = INF;
        }
    }

    public int run(int start, int end) {
        return this.isMatrix ? runMatrix(start, end) : runList(start, end);
    }

    private int runMatrix(int start, int end) {

        cost[start] = 0;

        for (int i = 1; i < N; i++) {

            int min = INF;
            int idx = -1;

            for (int j = 1; j < N; j++) {
                if (!visited[j] && cost[j] < min) {
                    min = cost[j];
                    idx = j;
                }
            }

            if (idx < 0)
                break;
            visited[idx] = true;

            for (int j = 1; j < N; j++) {
                int c = cost[idx] + graphMatrix[idx][j];
                if (!visited[j] && graphMatrix[idx][j] < INF && cost[j] > c) {
                    cost[j] = c;
                }
            }

        }

        return cost[end];

    }

    private int runList(int start, int end) {

        cost[start] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(encode(start, 0));

        while (!queue.isEmpty()) {

            int v = queue.poll() & MASK;

            if (visited[v])
                continue;

            visited[v] = true;

            List<Integer> adjList = graphList.get(v);

            for (Integer state : adjList) {

                int w = state & MASK;
                int c = (state >> BIT) + cost[v];

                if (cost[w] > c)
                    queue.offer(encode(w, cost[w] = c));

            }

        }

        return cost[end];

    }

    private int encode(int v, int c) {
        return c << BIT | v;
    }

}
