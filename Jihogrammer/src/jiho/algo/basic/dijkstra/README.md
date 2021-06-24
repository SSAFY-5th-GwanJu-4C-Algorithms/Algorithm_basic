# 다익스트라

###### Dijkstra

### Adjacency Matrix

```java
int v, N, INF = Integer.MAX_VALUE >> 1;

int[][] graph = new int[N + 1][N + 1];

int[] cost = new int[N + 1];
for (int i = 1; i <= N; i++) cost[i] = INF;
cost[v] = 0;

void dijkstra(int v, int[][] graph, int[] cost) {

    boolean[] visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {

        int min = INF;
        int idx = -1;

        for (int j = 1; j <= N; j++) {
            if (!visited[j] && cost[j] < min) {
                min = cost[j];
                idx = j;
            }
        }

        if (idx < 0) break;
        visited[idx] = true;

        for (int j = 1; j <= N; j++) {
            int c = cost[idx] + graph[idx][j];
            if (!visited[j] && graph[idx][j] < INF && cost[j] > c) {
                cost[j] = c;
            }
        }

    }

}
```

### Adjacency List

```java
int v, N, INF = Integer.MAX_VALUE >> 1;

List<List<Node>> graph = new ArrayList<>(N + 1);
for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

int[] cost = new int[N + 1];
for (int i = 1; i <= N; i++) cost[i] = INF;
cost[v] = 0;

void dijkstra(int v, List<List<Node>> graph, int[] cost) {

    boolean[] visited = new boolean[N + 1];

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(v, 0));

    while (!pq.isEmpty()) {

        v = pq.poll().to;

        if (visited[v]) continue;
        visited[v] = true;

        List<Integer> adjList = new ArrayList<>();

        for (Node n : adjList) {

            int w = n.to;
            int c = n.cost + cost[v];

            if (cost[w] > c) {
                cost[w] = c;
                pq.offer(new Node(w, c));
            }

        }

    }

}

class Node implements Comparable<Node> {

    int to, cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }

}
```
