package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11047_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]); // 동전 개수
		int K = Integer.valueOf(str[1]); // 가치의 합
		
		int[] coin = new int[N];
		
		for(int i = N-1; i >= 0; i--) {
			coin[i] = Integer.valueOf(br.readLine());
		}//입력 끝
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			while(coin[i] <= K) {
				K -= coin[i];
				cnt++;
			}
			if(K == 0) break;
		
		}
		System.out.println(cnt);
		
	}

}
