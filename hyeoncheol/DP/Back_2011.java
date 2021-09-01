package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int[] dp = new int[tmp.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		if (tmp.charAt(0) == '0') {
			System.out.println(0);
			return;
		}

		for (int i = 1; i < tmp.length(); i++) {
			char rear = tmp.charAt(i - 1);
			if (tmp.charAt(i) >= '1' && tmp.charAt(i) <= '9') {
				dp[i + 1] += dp[i];
				dp[i + 1] %= 1000000;
			}
			if (!(rear == '0' || rear > '2' || (rear == '2' && tmp.charAt(i) > '6'))) {
				dp[i + 1] += dp[i - 1];
				dp[i + 1] %= 1000000;
			}
		}
		System.out.println(dp[tmp.length()] % 1000000000);
	}
}
