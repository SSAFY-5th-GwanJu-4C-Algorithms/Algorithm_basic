package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		int cnt[] = new int[10];
		int ans=0;
		
		for (int i = 0; i < tmp.length(); i++) {
			cnt[tmp.charAt(i)-'0']++;
		}
		
		int six=0;
		for (int i = 0; i < 10; i++) {
			if(i==6||i==9) {
				six+=cnt[i];
				continue;
			}
			ans=Math.max(ans, cnt[i]);
		}
		if(six%2==0) {
			ans=Math.max(ans, six/2);
		}else {
			ans=Math.max(ans, six/2+1);
		}
		
		System.out.println(ans);
	}
}
