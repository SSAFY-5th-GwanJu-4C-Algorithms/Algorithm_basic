package study.June.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11265_파티 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);//파티장의 크기
		int M = Integer.valueOf(str[1]);//서비스 요청한 손님의 수
		int party[][] = new int[N][N];
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				party[i][j] = Integer.valueOf(str[j]);
			}
		}
		//floyd
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				if(i == k) continue;
				for(int j = 0; j < N; j++) {
					if(j == k || i == k) continue;
					if(party[i][j] > party[i][k] + party[k][j]) {
						party[i][j] = party[i][k] + party[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			if(party[from-1][to-1] > dist) {
				sb.append("Stay here\n");
			}
			else {
				sb.append("Enjoy other party\n");
			}
		}
		System.out.println(sb.toString());
		
		
	}

}
