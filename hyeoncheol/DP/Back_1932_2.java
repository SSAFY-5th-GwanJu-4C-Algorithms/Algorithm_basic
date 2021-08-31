package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1932_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr [][] =  new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int dp [][] = new int[N][N];
		
		dp[0][0] = arr[0][0];
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j <i+1 ; j++) {
				dp[i+1][j]=Math.max(dp[i][j]+arr[i+1][j], dp[i+1][j]);
				dp[i+1][j+1]=Math.max(dp[i][j]+arr[i+1][j+1], dp[i+1][j+1]);
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(dp[N-1][i], ans);
		}
		System.out.println(ans);
	}
}
