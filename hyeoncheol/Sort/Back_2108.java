package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] arr2 = new int[8001];
		int sum=0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sum +=tmp;
			arr[i]=tmp;
			arr2[tmp+4000]++;
		}
		int avg=0;
		if (sum < 0) {
			avg = -(int) (0.5 + (double) -sum / N);
		} else {
			avg = (int) (0.5 + (double) sum / N);
		}
		sb.append(avg+"\n");
		Arrays.sort(arr);
		sb.append(arr[N/2]+"\n");
		
		int max=0;
		boolean flag = false;
		for (int i = 0; i < 8001; i++) {
			if(arr2[i]>max) {
				max = arr2[i];
				flag=false;
			}else if(arr2[i]==max) {
				flag=true;
			}  
		}
		if(flag==false) {
			for (int i = 0; i < 8001; i++) {
				if(arr2[i]==max) {
					sb.append(i-4000+"\n");
					break;
				}
			}
		}else {
			boolean second=false;
			for (int i = 0; i < 8001; i++) {
				if(arr2[i]==max && second==true) {
					sb.append(i-4000+"\n");
					break;
				}
				if(arr2[i]==max && second==false) {
					second=true;
				}
			}
		}
		
		if(N==1) {
			sb.append("0\n");
		}else {			
			sb.append(arr[N-1]-arr[0]+"\n");
		}
		System.out.println(sb);
	}
}
