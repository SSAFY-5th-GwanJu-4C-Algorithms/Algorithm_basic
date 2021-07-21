package study.July.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_18429_근손실 {
	static int N,K,ans;
	static int[] kit;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		K = Integer.valueOf(str[1]);
		kit = new int[N];
		visit = new boolean[N];
		str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			kit[i] = Integer.valueOf(str[i]);
		}//입력 끝
		dfs(0,500);
		System.out.println(ans);
		
	}
	private static void dfs(int cnt,int str) {
		if(cnt == N) {
			ans++;
			return;
		}//기저 조건
		
		for(int i = 0; i < N; i++) {
			if(visit[i]) continue;
			else {
				//검사
				int temp = str - K + kit[i];
				if(temp < 500) continue;
				visit[i] = true;
				dfs(cnt+1 , temp);
				visit[i] = false;
			}
		}
	}

}
