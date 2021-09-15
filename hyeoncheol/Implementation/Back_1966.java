package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Back_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<N> q ;
		
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.add(new N(i, Integer.parseInt(st.nextToken())));
			}
			int count=0;
			
			while(!q.isEmpty()) {
				N tmp = q.poll();
				boolean flag = false;
				
				for (int i = 0; i < q.size(); i++) {
					if(tmp.imp<q.get(i).imp) {
						q.offer(tmp);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						flag = true;
						break;
					}
				}
				
				if(flag == true) {
					continue;
				}
				
				count++;
				if(tmp.index==M) {
					break;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	static class N{
		int index;
		int imp;
		public N(int index, int imp) {
			super();
			this.index = index;
			this.imp = imp;
		}
		
	}
}
