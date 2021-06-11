# 너비 우선 탐색(BFS, Breadth-First Search)

#### refernece

- [[알고리즘] 너비 우선 탐색(BFS)이란](https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html)

## 너비 우선 탐색이란

루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법

- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다.
- 즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.
- 사용하는 경우: 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.
  - Ex) 모든 인접 관계가 그래프로 표현된 경우 특정 지점 A와 B 사이에 존재하는 경로를 찾는 경우
  - 깊이 우선 탐색의 경우 - 모든 친구 관계를 다 살펴봐야 할지도 모른다.
  - 너비 우선 탐색의 경우 - A와 가까운 관계부터 탐색
- 너비 우선 탐색(BFS)이 깊이 우선 탐색(DFS)보다 좀 더 복잡하다.

## 너비 우선 탐색(BFS)의 특징

- 직관적이지 않은 면이 있다.
- BFS는 시작 노드에서 시작해서 거리에 따라 단계별로 탐색한다고 볼 수 있다.
- BFS는 재귀적으로 동작하지 않는다.

## 주의할 점

- 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
  - 이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.
- BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다.
  - 즉, 선입선출(FIFO) 원칙으로 탐색
- 일반적으로 큐를 이용해서 반복적 형태로 구현하는 것이 가장 잘 동작한다.

### BFS 구현 - 1. 인접리스트

```Java
    private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		int start = 0;
		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));

			for(Node temp = adjList[current]; temp != null; temp = temp.next) { //인접정점만 반복처리
				if(!visited[temp.vertex]) { // 인접체크조건이 없다.
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
```

### BFS 구현 - 2. 인접행렬

```Java
    private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		int start = 0; // 시작점

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			// 현재 정점에 관련된 처리
			System.out.println((char)(current+65));

			// 인접정점 탐색
			for(int i=0; i<N; i++) {
				if(adjMatrix[current][i]  //인접 정점
						&& !visited[i]) { //미방문 정점
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
```
