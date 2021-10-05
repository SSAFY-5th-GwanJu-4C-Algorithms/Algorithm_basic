package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1713 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<student> arr = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean flag;
		for (int i = 0; i < M; i++) {
			int num=Integer.parseInt(st.nextToken());
			flag = false;
			for(student s : arr) {
				if(s.num==num) {
					flag=true;
					s.rec++;
					break;
				}
			}
			if(!flag) {
				if(arr.size()==N) {
					arr.remove(0);
					arr.add(new student(num, 1, i));
				}else {
					arr.add(new student(num,1,i));
				}
			}
			Collections.sort(arr, new Comparator<student>() {
				@Override
				public int compare(student o1, student o2) {
					if(o1.rec==o2.rec) {
						return o1.time-o2.time;
					}
					return o1.rec-o2.rec;
				}
			});
		}
		Collections.sort(arr, new Comparator<student>() {
			@Override
			public int compare(student o1, student o2) {
				return o1.num-o2.num;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i).num+" ");
		}
		System.out.println(sb);
	}
	static class student{
		int num;
		int rec;
		int time;
		public student(int num, int rec, int time) {
			super();
			this.num = num;
			this.rec = rec;
			this.time = time;
		}
	}
}
