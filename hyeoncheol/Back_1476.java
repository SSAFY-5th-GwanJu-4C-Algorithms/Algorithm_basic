package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 8512; i++) {
			if((i-E)%15==0 && (i-S)%28==0 && (i-M)%19==0) {
				System.out.println(i);
				break;
			}
		}
	}
}
