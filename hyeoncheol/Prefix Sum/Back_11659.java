package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(arr[b]-arr[a-1]+"\n");
		}
		System.out.println(sb);
	}
}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class Back_11659 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//		st = new StringTokenizer(br.readLine());
//		for (int i = 1; i <= N; i++) {
//			hm.put(i, Integer.parseInt(st.nextToken()));
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int k = 0; k < M; k++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int sum = 0;
//			for (int i = a; i <= b; i++) {
//				sum+=hm.get(i);
//			}
//			sb.append(sum+"\n");
//		}
//		System.out.println(sb);
//	}
//}
