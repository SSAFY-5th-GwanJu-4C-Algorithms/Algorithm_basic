package com.Back;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Back_11497 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			int[] makeArr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int l = N-1;
			int r = 1;
			makeArr[0]=arr[0];
			for (int i = 1; i < N; i++) {
				if(i%2==1) {
					makeArr[l--]=arr[i];
				}else {
					makeArr[r++]=arr[i];
				}
			}
			
			int ans = Math.abs(makeArr[0]-makeArr[N-1]);
			
			for (int i = 1; i < N; i++) {
				ans = Math.max(ans, Math.abs(makeArr[i]-makeArr[i-1]));
			}
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
