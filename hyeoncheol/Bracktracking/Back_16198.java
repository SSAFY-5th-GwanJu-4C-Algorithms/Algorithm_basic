package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_16198 {

	static int N,max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		dfs(arr,0);
		System.out.println(max);
	}
	private static void dfs(ArrayList<Integer> arr, int k) {
		if(arr.size()<=2) {
			max = Math.max(max, k);
			return;
		}
		for (int i = 1; i < arr.size()-1; i++) {
			int tmp = arr.get(i);
			int sum = k+(arr.get(i-1)*arr.get(i+1));
			arr.remove(i);
			dfs(arr,sum);
			arr.add(i,tmp);
		}
	}
	
}
