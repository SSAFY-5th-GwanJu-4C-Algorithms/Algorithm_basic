package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_2012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long ans=0;
		for (int i = 1; i <= N; i++) {
			ans+=Math.abs(arr[i-1]-i);
		}
		System.out.println(ans);
	}
}
