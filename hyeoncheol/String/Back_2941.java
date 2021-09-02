package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for (int i = 0; i < arr.length; i++) {
			if(tmp.contains(arr[i])) {
				tmp=tmp.replaceAll(arr[i], " ");
			}
		}
		System.out.println(tmp.length());
	}
}
