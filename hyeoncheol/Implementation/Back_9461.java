package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		long [] arr = new long[101];
		arr[0] = 0L;
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
		
		for (int i = 4; i < 101; i++) {
			arr[i] = arr[i-3]+arr[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < testCase; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(arr[tmp]+"\n");
		}
		System.out.println(sb);
	}
}
