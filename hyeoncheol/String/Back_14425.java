package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans =0;
		String[] sArr = new String[N];
		
		for (int i = 0; i < N; i++) {
			sArr[i]=br.readLine();
		}
		
		for (int i = 0; i < M; i++) {
			String temp =br.readLine();
			for (int j = 0; j < N; j++) {
				if(sArr[j].equals(temp)) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
