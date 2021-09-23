package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Back_10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String val = br.readLine();
		int sum=0;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < val.length(); i++) {
			int tmp=val.charAt(i)-'0';
			sum+=tmp;
			arr.add(tmp);
		}
		Collections.sort(arr);
		
		if(arr.get(0)!=0 || sum%3!=0) {
			System.out.println(-1);
			System.exit(0);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(arr.size()-i-1));
		}
		System.out.println(sb);
	}
}
