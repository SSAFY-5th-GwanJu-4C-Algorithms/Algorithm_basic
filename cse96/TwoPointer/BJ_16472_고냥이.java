package study.June.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16472_고냥이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String str = br.readLine();
		int alpha[] = new int[26];
		int s = 0;
		int e = 0;
		int len = str.length();
		int cnt = 0;
		if(N >= len) {
			System.out.println(len);
			return;
		}
		int max = 0;
		while(e < len) {//문자열 끝까지 돌 때까지
			int idx = str.charAt(e++) - 'a'; //끝 인덱스 값을 증가하며 알파벳의 인덱스를 구함
			if(alpha[idx] == 0) cnt++; //알파벳의 인덱스의 값이 0이면 기존에 없던 값이므로 종류(cnt)를 증가
			alpha[idx]++; //종류(cnt)와 관계없이 해당 알파벳의 값(빈도 수)를 증가
			if(cnt > N) { //종류가 N을 초과하면
				while(cnt > N) { //종류가 N을 초과하지 않을 때 까지
					int tmp = str.charAt(s++) - 'a'; //시작 인덱스 값을 증가시켜가면서 
					alpha[tmp]--; //해당하는 알파벳의 인덱스의 값을 줄임
					if(alpha[tmp] == 0) cnt--; //인덱스의 값이 0이 되면 더이상 존재하지 않는알파벳이므로 종류에서 제거
				}
			}
			else {
				max = Math.max(max, e - s);//종류가 N을 초과하지 않으면 max값 갱신
			}
		}
		System.out.println(max);
	}


}
