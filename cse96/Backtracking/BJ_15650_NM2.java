package study.July.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15650_NM2 {

	static int N,M;
	static int arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		M = Integer.valueOf(str[1]);
		arr = new int[M];
		visit = new boolean[N];
		
		dfs(0);
		System.out.println(sb.toString());
	}
	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}//기저조건
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				if(cnt > 0) {
					if(arr[cnt-1] > i+1) {
						continue;
					}
				}
				visit[i] = true;
				arr[cnt] = i + 1;
				dfs(cnt + 1);
				visit[i] = false;
			}
		}
		
		
	}

}
