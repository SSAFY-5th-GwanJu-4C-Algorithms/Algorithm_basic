package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_1026 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		int ans=0;
		Integer[] arr2 = new Integer[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i]=Integer.parseInt(st1.nextToken());
			arr2[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2,Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			ans += arr1[i]*arr2[i];
		}
		System.out.println(ans);
	}
}
