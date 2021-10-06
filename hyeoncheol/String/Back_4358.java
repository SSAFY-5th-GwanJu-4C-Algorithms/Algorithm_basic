package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Back_4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		String tmp;
		int sum=0;
		while(true) {
			tmp = br.readLine();
			if(tmp == null || tmp.length()==0) {
				break;
			}
			sum++;
			hm.put(tmp, hm.getOrDefault(tmp, 0)+1);
		}
		
		Object[] obs = hm.keySet().toArray();
		Arrays.sort(obs);
		
		StringBuilder sb = new StringBuilder();
		for(Object o : obs) {
			String Str = (String) o;
			int count = hm.get(Str);
			double per = (double)(count * 100.0) / sum;
			
			sb.append(Str + " " + String.format("%.4f", per) + "\n");	// 소수점 4번 째 자리까지 출력 
		}
		
		System.out.println(sb.toString());
	}
}
