# BFS

그래프의 `모든 정점을 방문`하는 알고리즘이다.

<br>

## 1. BFS의 개념

BFS는 Breadth-First-Search 약자로, `넓이 우선 탐색`이라고도 한다.

이는 `시작 정점으로부터 가까운 곳을 먼저 탐색하고, 멀리 떨어져 있는 곳을 나중에 방문한다.`는 의미이다.

아래는 이 의미를 이해하는데 도움이 되는 그림이다.

<img src="https://user-images.githubusercontent.com/62600984/121535403-1b041400-ca3d-11eb-8cdf-9b1a043dce03.png" width=700px>

## 2-1. BFS의 구현 - 인접리스트 & 큐

```java
public static void bfs(int start, LinkedList<Integer>[] adj, boolean[][] visited) {
  
  Queue<Integer> queue = new LinkedList<>();
  
  // 1. 시작 노드 방문 체크 및 큐에 넣기
  visited[start] = true;
  queue.add(start);
  
  // 2. 시작 노드부터 이웃 노드 탐색 (큐가 비어질 때까지)
  while( !queue.isEmpty ){
  
    int node = queue.poll(); // 탐색을 시작할 노드
    
    // 3. 해당 노드의 이웃 노드 탐색
    Iterator<Integer> iter = adj[node].listIterator();
    while( iter.hasNext() ) {
    
      // 4. 아직 방문하지 않았으면 큐에 넣기
      int i = iter.next();
      if( !visited[i] ) {
        visited[i] = true;
        queue.add(i);
      }
    }
  }
}
```

## 2-2. BFS의 구현 - 인접행렬 & 큐

```java
public static void bfs(int start, int[][] adj, boolean[][] visited) {

  // 1. 시작 노드 방문 체크
  visited[start] = true;
  queue.add(start);
  
  // 2. 시작 노드부터 이웃 노드 탐색 (큐가 비어질 때까지)
  while( !queue.isEmpty ){
  
    int node = queue.poll(); // 탐색을 시작할 노드
    
    // 3. 해당 노드의 이웃 노드 탐색
    for( int i = 0 ; i < adj[node].length ; i++ )
    
      // 4. 해당 노드와 연결되어 있고, 아직 방문하지 않았으면 큐에 넣기
      if( adj[node][i] == 1 && !visited[i] ) {
        visited[i] = true;
        queue.add(i);
      }
    }
  }
}
```

<br>

## BFS의 시간 복잡도

n: 정점 수, e: 간선 수

- 인접 리스트로 구현: O(n+e)
- 인접 행렬로 구현:  O(n^2)

<br>

## BFS의 장단점

- 장점

  - 답이 되는 경로가 여러 개인 경우에도 `최단경로임을 보장`한다.
  - 최단 경로가 존재하면 깊이가 `무한정 깊어진다고 해도 답을 찾을 수 있다.`

- 단점

  - 경로가 매우 길 경우에는 탐색 가지가 급격히 증가함에 따라 보다 `많은 기억 공간`을 필요로 하게 된다.

<br>

## 참고 블로그

- [DFS BFS란? 백준 문제추천](https://covenant.tistory.com/132)
- [[Java] BFS 너비 우선 탐색 - 인접리스트 / 인접행렬로 구현](https://minhamina.tistory.com/36?category=837168)
