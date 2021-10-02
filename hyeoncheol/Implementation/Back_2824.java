package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Back_2824 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a = a.multiply(new BigInteger(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			b = b.multiply(new BigInteger(st.nextToken()));
		}
		String tmp=a.gcd(b).toString();
		StringBuilder sb = new StringBuilder();
		if(tmp.length()>9) {
			for (int i = 0; i < 9; i++) {
				sb.append(tmp.charAt(tmp.length()-9+i));
			}
			System.out.println(sb);
		}else {
			System.out.println(tmp);
		}
	}
}
