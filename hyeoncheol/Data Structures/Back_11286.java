package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Back_11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
			if(Math.abs(a)==Math.abs(b)) {
				return a>b?1:-1;
			}
			return Math.abs(a)-Math.abs(b);
		}) ;
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				pq.add(tmp);
			}
		}
		
		System.out.println(sb);
	}
}
