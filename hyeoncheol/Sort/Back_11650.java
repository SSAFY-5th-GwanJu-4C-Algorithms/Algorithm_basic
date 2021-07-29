package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<point> arr = new ArrayList<>();
		StringTokenizer st;
		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x= Integer.parseInt(st.nextToken());
			y= Integer.parseInt(st.nextToken());
			arr.add(new point(x,y));
		}
		Collections.sort(arr);
		
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i).x+" "+arr.get(i).y+"\n");
		}
		System.out.println(sb);
	}
	static class point implements Comparable<point>{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(point o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}
		
	}
}
