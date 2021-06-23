package study.June.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2617_구슬찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		int biz[][] = new int[N][N];
		final int INF = 1000000000;
		for(int i = 0; i < N; i++) {
			Arrays.fill(biz[i], INF);
			biz[i][i] = 0;
		}
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int heavy = Integer.valueOf(str[0]);
			int light = Integer.valueOf(str[1]);
			biz[heavy-1][light-1] = 1;
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(biz[i]));
//		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i == k) continue;
				for(int j = 0; j < N; j++) {
					if(i == j || k == j) continue;
					if(biz[i][j] > biz[i][k] + biz[k][j]) {
						biz[i][j] = biz[i][k] + biz[k][j];
					}
				}
			}
		}
//		System.out.println("----------------------");
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(biz[i]));
//		}
		boolean result_big[] = new boolean [N];
		boolean result_small[] = new boolean [N];
		for(int i = 0; i < N; i++) {
			int cnt_big = 0;
			int cnt_small = 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(biz[i][j] != INF) {
					cnt_small++;
				}
				if(biz[j][i] != INF) {
					cnt_big++;
				}
			}
			if(cnt_big > N/2) result_big[i] = true;
			if(cnt_small > N/2) result_small[i] = true;
		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			if(result_big[i] || result_small[i]) ans++;
		}
		System.out.println(ans);
	}
}
