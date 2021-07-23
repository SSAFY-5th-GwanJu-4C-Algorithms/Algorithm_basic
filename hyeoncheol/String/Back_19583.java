package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Back_19583 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String start = st.nextToken();
		String End = st.nextToken();
		String Stream = st.nextToken();
		int ans=0;
		//시작할 때 출첵
		HashSet<String> s = new HashSet<>();
		//끝날 때 출첵
		HashSet<String> e = new HashSet<>();
		String temp;
		
		while((temp=br.readLine())!=null) {
			if(start.compareTo(temp.split(" ")[0])>=0) {
				s.add(temp.split(" ")[1]);
			}else if(End.compareTo(temp.split(" ")[0])<=0 && Stream.compareTo(temp.split(" ")[0])>=0 ) {
				e.add(temp.split(" ")[1]);
			}
		}
		for (String tmp : e) {
			if(s.contains(tmp)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
