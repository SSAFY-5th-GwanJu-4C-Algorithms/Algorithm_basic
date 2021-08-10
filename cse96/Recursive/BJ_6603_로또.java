package study.August.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_6603_·Î¶Ç {

	static int N;
	static int arr[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str[] = br.readLine().split(" ");
			N = Integer.valueOf(str[0]);
			if(N == 0) break;
			arr = new int[N + 1];
			visit = new boolean[N + 1];
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.valueOf(str[i]);
			}
			
			dfs(1,0);
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	private static void dfs(int start, int depth) {
		if(depth == 6) {
			for(int i = 1; i <= N; i++) {
				if(visit[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
			return ;
		}
		for(int i = start; i <= N; i++) {
			visit[i] = true;
			dfs(i + 1,depth + 1);
			visit[i] = false;
		}
	}

}
