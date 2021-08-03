## 문제

![image](https://user-images.githubusercontent.com/62600984/128006218-18a41b95-f0d6-4e6d-95e1-50f353a8203a.png)

[문제보기](https://www.acmicpc.net/problem/1260)

<br>

## 문제 풀이

BFS와 DFS 잊지말자!

DFS는 하나의 정점에서 경로 끝의 정점 끝까지 한번에 가는 것! `재귀함수`를 쓴다.

BFS는 하나의 정점에서 연결된 정점 모두를 먼저 가는 것! `Queue`를 쓴다.

<br>

- DFS

```java
private static void DFS(int idx, boolean[] visited) {
		
  visited[idx] = true;
  sb.append(idx).append(" ");

  for (int i = 1; i <= N; i++) {
    if(adj[idx][i] == 0 || visited[i]) continue; 
    DFS(i, visited);
  }
}
```

- BFS

```java
private static void BFS() {
		
  Queue<Integer> queue = new LinkedList<Integer>();
  boolean[] visited = new boolean[N+1];

  queue.add(V);
  visited[V] = true;

  while(!queue.isEmpty()) {

    int idx = queue.poll();
    sb.append(idx).append(" ");

    for (int i = 1; i <= N; i++) {
      if(adj[idx][i] == 0 || visited[i]) continue;
      queue.add(i);
      visited[i] = true;
    }
  }
}
```

<br>

## 전체 코드

```java
public class Main {

	static int N, M, V, adj[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = adj[b][a] = 1;
		}
		
		boolean[] visited = new boolean[N+1];
		DFS(V, visited);
		
		sb.append("\n");
		BFS();
		
		System.out.println(sb.toString());
	}

	private static void BFS() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			
			int idx = queue.poll();
			sb.append(idx).append(" ");
			
			for (int i = 1; i <= N; i++) {
				if(adj[idx][i] == 0 || visited[i]) continue;
				queue.add(i);
				visited[i] = true;
			}
		}
	}

	private static void DFS(int idx, boolean[] visited) {
		
		visited[idx] = true;
		sb.append(idx).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(adj[idx][i] == 0 || visited[i]) continue; 
			DFS(i, visited);
		}
	}
}
```
