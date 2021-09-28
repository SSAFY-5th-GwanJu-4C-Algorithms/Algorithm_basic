package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_5635 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<person> arr = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			arr.add(new person(year,month,day,name));
		}
		Collections.sort(arr);
		System.out.println(arr.get(arr.size()-1).name);
		System.out.println(arr.get(0).name);
	}
	static class person implements Comparable<person>{
		int year;
		int month;
		int day;
		String name;
		
		public person(int year, int month, int day, String name) {
			this.year = year;
			this.month = month;
			this.day = day;
			this.name = name;
		}

		@Override
		public int compareTo(person o) {
			if(o.year==this.year) {
				if(this.month==o.month) {
					return this.day-o.day;
				}
				return this.month-o.month;
			}
			return this.year-o.year;
		}
		
	}
}
