package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_15652 {
	
	static int N,M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[M];
		
		perm(0,0);
		System.out.println(sb);
	}
	private static void perm(int dep,int val) {
		if(dep == M) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <=N ; i++) {
			if(val>i) {
				continue;
			}
			arr[dep]=i;
			perm(dep+1,i);
		}
	}
}
