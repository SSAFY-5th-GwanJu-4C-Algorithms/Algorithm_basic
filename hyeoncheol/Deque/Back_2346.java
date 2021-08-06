package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Back_2346 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<point> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			dq.add(new point(i, tmp));
		}
		

		while(!dq.isEmpty()) {
			sb.append(dq.getFirst().seq+" ");
			int val = dq.poll().val;
			if(dq.isEmpty())break;

			if(val>0) {
				val--;
				for (int i = 0; i < val; i++) {
					dq.addLast(dq.pollFirst());
				}
			}else {
				for (int i = 0; i < Math.abs(val); i++) {
					dq.addFirst(dq.pollLast());
				}
			}
			
		}
		System.out.println(sb);
	}
	
	static class point{
		int seq;
		int val;
		public point(int seq, int val) {
			super();
			this.seq = seq;
			this.val = val;
		}
		
	}
}
