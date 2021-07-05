import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Acmicpc_1197_최소스패닝트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		ArrayList<int[]>[] adjList = new ArrayList[V+1];
		int[] minEdge = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			minEdge[i] = Integer.MAX_VALUE;
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			int C = Integer.valueOf(st.nextToken());
			
			adjList[A].add(new int[] {B,C});
			adjList[B].add(new int[] {A,C});
		}
		
		minEdge[1] = 0;
		int result = 0;
		
		for(int i=1; i<=V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 1;
			
			for(int j=1; j<=V; j++) {				
				if(!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			result += min;
			visited[minVertex] = true;
			
			for(int[] next : adjList[minVertex]) {
	            if(!visited[next[0]] && minEdge[next[0]] > next[1]) {
	               minEdge[next[0]] = next[1];
	            }
	         }
		}
		
		System.out.println(result);
		
	}

}
