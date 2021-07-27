package study.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1316_Checker {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int N = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < N; i++) {
			if(check(br.readLine())) {
				count++;
			}
			
		}
		System.out.print(count);
	}

	private static boolean check(String str) {
		boolean[] check = new boolean[26];
		int prev = 0;
		int len = str.length();
		
		for(int i = 0; i < len; i++) {
			int now = str.charAt(i);
			
			if(prev != now) {
				if(!check[now - 'a']) {
					check[now - 'a'] = true;
					prev = now;
				}
				else {
					return false;
				}
			}
			
		}
		return true;	
		
	}

}
