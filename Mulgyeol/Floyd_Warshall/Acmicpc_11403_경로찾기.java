package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_11403_경로찾기 {
	static final int INF = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == 0) {
					arr[i][j] = INF;
				}
			}
		}
		
		for(int i=0; i<N; i++) { //경유지
			for(int j=0; j<N; j++) { //출발지
				for(int k=0; k<N; k++) { //도착지
					if(arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = 1;
					}
				}
			}
		}
		
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == INF) {
					result = 0;
				}else {
					result = 1;
				}
				sb.append(result).append(" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		
		System.out.print(sb);

	}
}
