# 깊이 우선 탐색(DFS, Depth-First Search)

#### refernece

- [[알고리즘] 깊이 우선 탐색(DFS)이란](https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html)

## 깊이 우선 탐색이란??

루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법이다.

그래프 자료구조나 2차원 배열에서 경로를 따라가며 원하는 지점을 찾고자 할 때, 자주 사용되는 알고리즘이다.

- 미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.
- 즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것이다.
- 사용하는 경우: 모든 노드를 방문 하고자 하는 경우에 이 방법을 선택한다.
- 깊이 우선 탐색(DFS)이 너비 우선 탐색(BFS)보다 좀 더 간단하다.
- 단순 검색 속도 자체는 너비 우선 탐색(BFS)에 비해서 느리다.

## 깊이 우선 탐색(DFS)의 특징

- 자기 자신을 호출하는 순환 알고리즘의 형태 를 가지고 있다.
- 전위 순회(Pre-Order Traversals)를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다.
- 이 알고리즘을 구현할 때 가장 큰 차이점은, 그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사 해야 한다는 것이다.
  - 이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.

### DFS 구현 - 1. 인접리스트

```Java
    private static void dfs(int current) {
		visited[current] = true;
		//해당 위치를 방문했을 때 처리할 행동

		for(Node temp = adjList[current]; temp!=null; temp=temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
		}

	}
```

### DFS 구현 - 2. 인접행렬

```Java
    private static void dfs(int current) {// 번호 v로부터 시작하는 dfs
		visited[current] = true;
		//해당 위치를 방문했을 때 처리할 행동

		for (int i = 0; i < N; ++i) {
			//v번째 행에서 탐색
			if (map[v][i] == true && !visited[i]) {
                //방문 가능하고, 방문한 적이 없으면
				dfs(i);
			}
		}
	}
```
