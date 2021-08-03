package study.August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_13417_카드문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		LinkedList<String> l = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			sb.setLength(0);
			int N = Integer.valueOf(br.readLine());
			String str[] = br.readLine().split(" ");
			l.clear();
			for(int i = 0; i < N; i++) {
				if(i == 0) l.add(str[i]);
				else {
					if(l.peekFirst().compareTo(str[i]) < 0) {
						l.addLast(str[i]);
					}
					else {
						l.addFirst(str[i]);
					}
				}
			}
			for(int i = 0; i < N; i++) {
				sb.append(l.get(i));
			}
			System.out.println(sb.toString());
		}
		
	
	}

}
