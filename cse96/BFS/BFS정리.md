# BFS
참고:https://cse96.github.io/algorithm-bfs/

그래프 탐색에서 사용되는 방법

그래프 탐색: 하나의 정점으로부터 시작하여 차례대로 모든 정점을 하나씩 탐색.

- BFS: 탐색 시작점의 인접한 정점들을 먼저 모두 차례로 방문한 후에, 방문했던 정점을 시작점으로 하여 다시 인접한 정점들을 차례로 방문하는 방식

- 인접한 정점들에 대해 탐색을 한 후, 차례로 다시 너비우선탐색을 진행 하므로, 선입선출 형태의 자료구조인 큐를 활용함.

- 재귀적으로 동작하지 않는다.

---

```
BFS(G,v) //그래프 G, 탐색 시작 정점v

Queue q;
q.add(v);
visited[v] = true;

while(!q.isEmpty()){
  t = q.poll();
  for(Node n : adj[t]){
    //인접정점 n
    if(!visited[n]){
      q.add(n);
      visited[n] = true;//q에넣음과 동시에 방문처리
    }
  }
}
```

특징

- BFS의 경우 방문처리를 해야 무한루프에 빠지지 않는데 DFS와 달리 선입선출 방식이기 때문에 방문처리를 q에 넣음과 동시에 해야한다.
- 시간복잡도는 DFS와 동일하게 희소그래프인 경우 인접리스트로 구현하는것이 좋다.
