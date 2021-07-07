import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_1368_물대기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(br.readLine());
		int[] W = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			W[i] = Integer.valueOf(br.readLine());
		}
		
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int vertex = 0;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && min > W[j]) {
					vertex = j;
					min = W[j];
				}
			}
			
			visited[vertex] = true;
			answer += min;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && W[j] > arr[vertex][j]) {
					W[j] = arr[vertex][j];
				}
			}
		}
		
		System.out.println(answer);
	}

}
