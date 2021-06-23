package Floyd_Warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_2617_구슬찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		boolean[][] arr = new boolean[N+1][N+1];
		boolean[][] reArr = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			arr[A][B] = true; //A가 B보다 무겁다.
			reArr[B][A] = true;
		}
		
		for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					if(arr[j][i] && arr[i][k]) {
						arr[j][k] = true;
					}
					
					if(reArr[j][i] && reArr[i][k]) {
						reArr[j][k] = true;
					}
				}
			}
		}
		
		int answerCnt = 0;
		
		for(int i=1; i<=N; i++) {
			int heavierBeads = 0;
			int lighterBeads = 0;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(arr[i][j]) { //i가 j보다 무거우면
					heavierBeads++;
				}
				if(reArr[i][j]) { //i가 j보다 가벼우면
					lighterBeads++;
				}
			}
			
			if(heavierBeads > N/2 || lighterBeads > N/2) {
				answerCnt++;
			}
		}
		
		System.out.println(answerCnt);
	}

}
