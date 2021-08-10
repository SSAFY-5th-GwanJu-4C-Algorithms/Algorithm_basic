package study.August.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4902_삼각형 {
	static int N;
	static int[][] arr,sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String str[] = br.readLine().split(" ");
			N = Integer.valueOf(str[0]);
			if(N == 0) break;
			arr = new int[N+1][N*2];
			sum = new int[N+1][N*2];
			
			for(int i = 1; i < N; i++) {
				for(int j = 1; j < N; j++) {
					arr[i][j] = Integer.valueOf(str[j]);
					sum[i][j] = arr[i][j] + sum[i][j-1];
				}
			}
			int max = Integer.MIN_VALUE;
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					for(int k = 0, Sum = 0; k < N - i + 1; k++) {
						Sum += sum[i+k][j+2*k] - sum[i+k][j-1];
						max = Math.max(max, Sum);
					}
				}
			}
			
			System.out.println(max);
		}
	}

}
