package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_2458_키순서 {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		boolean[][] adjArr = new boolean[N+1][N+1];
		boolean[][] reAdjArr = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(adjArr[i], false);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			
			adjArr[from][to] = true;
			reAdjArr[to][from] = true;
		}
		
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(adjArr[j][i] && adjArr[i][k]) {
						adjArr[j][k] = true;
					}
					if(reAdjArr[j][i] && reAdjArr[i][k]) {
						reAdjArr[j][k] = true;
					}
				}
			}
		}
		
		int cnt = N;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(!adjArr[i][j] && !reAdjArr[i][j]) {
					cnt--;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
