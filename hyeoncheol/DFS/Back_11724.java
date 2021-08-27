package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11724 {
	static int N, M,ans;
	static boolean[] visited;
	static int[][] arr;

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
		
	}

	private static void dfs(int i) {
		visited[i] = true;
		for (int j = 0; j <= N; j++) {
			if(arr[i][j]==1 && !visited[j]) {
				dfs(j);
			}
		}
	}
	
	
}
