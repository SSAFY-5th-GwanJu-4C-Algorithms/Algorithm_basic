package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sub = br.readLine().split("\\-");
		int ans = 0;		
		for (int i = 0; i < sub.length; i++) {
			String[] add = sub[i].split("\\+");
			
			for (int j = 0; j < add.length; j++) {
				if(i==0) {					
					ans+=Integer.parseInt(add[j]);
				}else {
					ans-=Integer.parseInt(add[j]);
				}
			}
		}
		System.out.println(ans);
	}
}
