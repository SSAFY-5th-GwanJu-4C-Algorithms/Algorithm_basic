package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_5555 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String search = br.readLine();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb;
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 10; j++) {
				if(tmp.contains(search)) { 
					cnt++;
					break;
				}
				sb = new StringBuilder();
				sb.append(tmp.substring(1, tmp.length())+tmp.charAt(0));
				tmp = sb.toString();
			}
		}
		System.out.println(cnt);
	}
}
