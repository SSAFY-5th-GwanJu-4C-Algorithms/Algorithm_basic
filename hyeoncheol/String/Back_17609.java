package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_17609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			if(palindrome(tmp)) {
				sb.append("0\n");
			}else if(palindrome2(tmp)) {
				sb.append("1\n");
			}else {
				sb.append("2\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean palindrome(String tmp) {
		int left = 0;
		int right= tmp.length()-1;
		while(left<=right) {
			if(tmp.charAt(left++)!=tmp.charAt(right--)) {
				return false;
			}
		}
		return true;
	}

	private static boolean palindrome2(String tmp) {
		int left=0;
		int right= tmp.length()-1;
		while(left<=right) {
			if(tmp.charAt(left)!=tmp.charAt(right)) {
				return palindrome(tmp.substring(left+1, right+1)) | palindrome(tmp.substring(left,right));
			}
			left++;
			right--;
		}
		return true;
	}
}
