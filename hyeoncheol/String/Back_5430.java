package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Back_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < testCase; tc++) {
			String tmp = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String arrtemp = br.readLine();
			arrtemp = arrtemp.substring(1, arrtemp.length()-1);
			String[] Sarr = arrtemp.split(",");
			
			Deque<Integer> arr = new LinkedList<Integer>();
			for (int i = 0; i < N ; i++) {
				arr.add(Integer.parseInt(Sarr[i]));
			}
			
			boolean dir = true;
			boolean flag = false;
			for (int i = 0; i < tmp.length(); i++) {
				if(tmp.charAt(i)=='R') {
					dir=!dir;
					continue;
				}else {
					if(arr.isEmpty()) {
						flag=true;
						break;
					}
					if(dir) {
						arr.pollFirst();
					}else {
						arr.pollLast();
					}
				}
			}
			if(flag==true) {
				sb.append("error\n");
				continue;
			}
			sb.append("[");
			if(dir) {
				while(arr.size()>1) {
					sb.append(arr.pollFirst()+",");
				}
			}else {
				while(arr.size()>1) {
					sb.append(arr.pollLast()+",");
				}
			}
			if(arr.size()!=0) {
				sb.append(arr.poll());
			}
			sb.append("]"+"\n");
		}
		System.out.println(sb);
	}
}
