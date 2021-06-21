package study.June.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2458_Å°¼ø¼­ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		int tall[][] = new int[N][N];
		final int INF = 10000000;
		for(int i = 0; i < N; i++) {
			Arrays.fill(tall[i], INF);
			tall[i][i] = 0;
		}
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int small = Integer.valueOf(str[0]);
			int big = Integer.valueOf(str[1]);
			tall[small-1][big-1] = 1;
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(tall[i]));
//		}
//		System.out.println();
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i == k) continue;
				for(int j = 0; j < N; j++) {
					if(i == j || j == k) continue;
					if(tall[i][j] > tall[i][k] + tall[k][j]) {
						tall[i][j] = tall[i][k] + tall[k][j];
					}
				}
			}
		}
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(tall[i]));
//		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(tall[i][j] == INF) {
					if(tall[j][i] == INF) cnt=1;
				}
			}
			if(cnt == 0) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}
