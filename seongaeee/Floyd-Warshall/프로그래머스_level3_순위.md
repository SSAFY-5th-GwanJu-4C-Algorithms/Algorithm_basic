```java
public class Main {	

	static int n = 5;
	static int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
	
	public static void main(String[] args) {
				
		int[][] adj = new int[n+1][n+1];
		int INF = 200;
		
		for (int i = 0; i < results.length; i++) {
			int from = results[i][1]; 
			int to = results[i][0]; 
			adj[from][to] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(adj[i][j] == 0) {
					adj[i][j] = INF;
				}
			}
		}
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(i == k) continue;
				for (int j = 1; j <= n; j++) {
					if(k == j || i == j) continue;
					
					if(adj[i][j]>adj[i][k]+adj[k][j]) {
						adj[i][j]=adj[i][k]+adj[k][j];
					}
				}
			}
		}
		
		int answer = 0;
		
		for (int node = 1; node <= n; node++) {
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if(adj[node][i] != INF) cnt++;
				if(adj[i][node] != INF) cnt++;
			}
			if(cnt == n-1) answer++;
		}
		
		System.out.println(answer);
	}
}
```
