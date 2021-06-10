# DFS

그래프의 `모든 정점을 방문`하는 알고리즘이다.

<br>

## 1. DFS의 개념

DFS는 Depth-First-Search 약자로, `깊이 우선 탐색`이라고도 한다.

이는 `하나의 길을 끝까지 깊이있게 가고, 더 이상 갈 수 없게 되었을 때 backtracking을 하여 가장 가까운 다른 길을 간다.`는 의미이다.

아래는 이 의미를 이해하는데 도움이 되는 그림이다.

<img src="https://user-images.githubusercontent.com/62600984/121457269-5e7d6480-c9e2-11eb-8b2e-16cf6186fdb5.png" width=500px>

<br>

## 2-1. DFS의 구현 - 인접리스트 & 재귀

```java
public static void dfs(int node, LinkedList<Integer>[] adj, boolean[][] visited) { // node: 탐색을 시작할 노드

  // 1. 해당 노드 방문 체크
  visited[node] = true;
  
  // 2. 해당 노드의 이웃 노드 탐색
  Iterator<Integer> lter = adj[node].listIterator();
  while( iter.hasNext() ) {
  
    // 3. 아직 방문하지 않았으면 dfs 탐색 
    int i = iter.next();
    if( !visited[i] ) {
      dfs(i, adj, visit);
    }
  }
}
```

<br>

## 2-2. DFS의 구현 - 인접행렬 & 재귀

```java
public static void dfs(int node, int[][] adj, boolean[][] visited) { // node: 탐색을 시작할 노드

  // 1. 해당 노드 방문 체크
  visited[node] = true;
  
  // 2. 해당 노드의 이웃 노드 탐색
  for( int i = 0 ; i < adj[node].length ; i++ ) {
    
    // 3. 해당 노드와 연결되어 있고, 아직 방문하지 않았으면 dfs 탐색 
    if( adj[node][i] == 1 && !visited[i] ) {
      dfs(i, adj, visit);
    }
  }
}
```

<br>

## 2-2. DFS의 구현 - 인접행렬 & 스택

```java
public static void dfs(int start, int[][] adj, boolean[][] visited) { // start: 탐색을 시작할 첫번째 노드

  Stack<Integer> stack = new Stack<Integer>();

  // 1. 첫번째 노드 방문 체크 및 스택 push
  visited[start] = true;
  stack.push(start);

  // 2. 첫번째 노드로부터 탐색 시작
  while( !stack.isEmpty() ){
  
    int node = stack.peek(); // 탐색을 시작할 노드
    boolean flag = false; // 해당 노드에서 탐색 가능한 이웃 노드 여부
    
    // 3. 해당 노드의 이웃 노드 탐색
    for( int i = 0 ; i < adj[node].length ; i++ ) {

      // 4. 해당 노드와 연결되어 있고, 아직 방문하지 않았으면 stack에 저장 
      if( adj[node][i] == 1 && !visited[i] ) {
        visited[node] = true;
        stack.push(node);
        flag = true;
        
        break; // 깊게 탐색하기 때문에 찾으면 바로 break
      }
    }
    
    //5. 탐색 가능한 이웃 노드가 없으면 stack에서 삭제
    if( !flag ) {
      stack.pop();
    }
  }
}
```

<br>

## DFS의 시간 복잡도

n: 정점 수, e: 간선 수

- 인접 리스트로 구현: O(n+e)
- 인접 행렬로 구현:  O(n^2)

<br>

## DFS의 장단점

- 장점

    - 현 경로상의 노드를 기억하기 때문에 `적은 메모리`를 사용한다.
    - 찾으려는 노드가 `깊은 단계에 있는 경우 BFS 보다 빠르게` 찾을 수 있다.

- 단점

    - `해가 없는 경로`를 탐색 할 경우 단계가 끝날 때까지 탐색한다.
    - DFS를 통해서 얻어진 해가 `최단 경로라는 보장이 없다.`

<br>

## 참고 블로그

- [DFS BFS란? 백준 문제추천](https://covenant.tistory.com/132)
- [[Java] DFS 깊이 우선 탐색 - 인접리스트 / 인접행렬로 구현](https://minhamina.tistory.com/22)

