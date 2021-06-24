package study.June.Slide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14465_소가길건넌이유5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int K = Integer.valueOf(str[1]);
		int B = Integer.valueOf(str[2]);
		boolean broken[] = new boolean[N + 1];
		int cnt = 0;
		for(int i = 0; i < B; i++) {
			int broken_light = Integer.valueOf(br.readLine());
			if(broken_light < K+1) cnt++;
			broken[broken_light] = true;
		}
		int min = K;
		for(int ptr1 = 1, ptr2 = K; ptr2 < N; ptr1++,ptr2++) {
			if(!broken[ptr1] && broken[ptr2+1]) {
				cnt++;
			}
			else if(broken[ptr1] && !broken[ptr2+1]) {
				cnt--;
			}
			min = cnt < min ? cnt : min;
		}
		System.out.println(min);
		
	}

}
