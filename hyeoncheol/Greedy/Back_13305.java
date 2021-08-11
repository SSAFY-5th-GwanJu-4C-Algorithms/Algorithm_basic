package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] dist = new long[N - 1];
		long[] oil = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}

		long ans = oil[0]*dist[0];
		long min = oil[0];
		for (int i = 1; i < N - 1; i++) {
			min = oil[i]>min?min:oil[i];
			ans += (min * dist[i]);
		}
		System.out.println(ans);
	}
}

//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_13305 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//
//		long[] dist = new long[N - 1];
//		long[] oil = new long[N];
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N - 1; i++) {
//			dist[i] = Long.parseLong(st.nextToken());
//		}
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			oil[i] = Long.parseLong(st.nextToken());
//		}
//
//		long ans = 0;
//		long min = oil[0];
//		for (int i = 0; i < N - 1; i++) {
//			if (oil[i] < min) {
//				min = oil[i];
//			}
//			ans += (min * dist[i]);
//		}
//		System.out.println(ans);
//	}
//}
