package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[5];
		int tmp=0;
		for (int i = 0; i < 5; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
					for (int k = 0; k < arr.length; k++) {
						sb.append(arr[k]+" ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
