package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_1755 {
	static int M,N;
	static String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ArrayList<words> arr = new ArrayList<>();
		
		for (int i = M; i <= N; i++) {
			String tmp = Integer.toString(i);
			char[] nums = tmp.toCharArray();
			tmp="";
			for (int j = 0; j < nums.length; j++) {
				tmp+=word[nums[j]-'0'];
			}
			arr.add(new words(i, tmp));
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i).num+" ");
			if((i+1)%10==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static class words implements Comparable<words>{
		int num;
		String word;
		public words(int num, String word) {
			super();
			this.num = num;
			this.word = word;
		}
		@Override
		public int compareTo(words o) {
			return this.word.compareTo(o.word);
		}
		
	}
}
