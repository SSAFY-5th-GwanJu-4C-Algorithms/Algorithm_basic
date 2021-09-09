package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tmp;
		int n = 1;
		while(true) {
			tmp = br.readLine();
			if(tmp.charAt(0)=='-') break;
			
			int ans =0;
			Stack<Character> st = new Stack<>();
			
			for (int i = 0; i < tmp.length(); i++) {
				char c = tmp.charAt(i);
				if(c=='{') {
					st.add(c);
				}else {
					if(st.isEmpty()) {
						ans++;
						st.add('{');
					}else {
						st.pop();
					}
				}
			}
			sb.append((n++) +". " + (ans+st.size()/2)+"\n" );
		}
		System.out.println(sb);
	}
}
