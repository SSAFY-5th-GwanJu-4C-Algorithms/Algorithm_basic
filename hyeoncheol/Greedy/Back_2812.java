package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Back_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String tmp = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			
			while(K>0 && !dq.isEmpty() && dq.getLast() < tmp.charAt(i)) {
				dq.removeLast();
				K--;
			}
			dq.addLast(tmp.charAt(i));
		}
		
		while(dq.size() > K) {
			sb.append(dq.removeFirst());
		}
		System.out.println(sb);
	}
}
