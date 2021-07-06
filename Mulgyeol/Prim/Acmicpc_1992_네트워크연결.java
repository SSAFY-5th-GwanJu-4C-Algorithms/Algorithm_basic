import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Acmicpc_1992_네트워크연결 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(br.readLine());
		int M = Integer.valueOf(br.readLine());
		
		ArrayList<int[]>[] adjList = new ArrayList[N+1];
		int[] minLength = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			minLength[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int value = Integer.valueOf(st.nextToken());
			
			adjList[a].add(new int[] {b,value});
			adjList[b].add(new int[] {a,value});
		}
		
		minLength[1] = 0;
		int answer = 0;
		
		for(int i=1; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			int vertex = 0;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && minLength[j] < min) {
					min = minLength[j];
					vertex = j;
				}
			}
			
			visited[vertex] = true;
			answer += minLength[vertex];
			
			for(int[] linkedVertex : adjList[vertex]) {
				if(!visited[linkedVertex[0]] && minLength[linkedVertex[0]] > linkedVertex[1]) {
					minLength[linkedVertex[0]] = linkedVertex[1];
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
