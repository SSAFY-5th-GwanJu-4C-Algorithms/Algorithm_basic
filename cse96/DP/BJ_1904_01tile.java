package com.ssafy.February;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1904_01tile {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int dp[] = new int[1000001];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2;i < 1000001; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		System.out.println(dp[N]);
		
		
	}

}
