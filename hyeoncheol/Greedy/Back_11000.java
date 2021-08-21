package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<lecture> arr = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		
		pq.add(arr.get(0).e);
		for (int i = 1; i < N; i++) {
			if(arr.get(i).s>=pq.peek()) {
				pq.poll();
			}
			pq.add(arr.get(i).e);
		}
		System.out.println(pq.size());
	}
	static class lecture implements Comparable<lecture>{
		int s;
		int e;
		public lecture(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(lecture o) {
			if(o.s==this.s) {
				return this.e-o.e;
			}
			return this.s-o.s;
		}
		
	}
}
