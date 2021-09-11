package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14500_2 {

	static int N,M,ans;
	static int [][] map;
	static boolean[][] visited;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i,j,0,0);
				dfsOther(i,j);
			}
		}
		System.out.println(ans);
	}

	//한붓 그리기 가능한 경우
	private static void dfs(int i, int j,int dep, int sum) {
		if(dep==4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int xx = dx[k]+i;
			int yy = dy[k]+j;
			if(xx<0||yy<0||xx>=N||yy>=M||visited[xx][yy])continue;
			
			visited[xx][yy]=true;
			dfs(xx,yy,dep+1,sum+map[xx][yy]);
			visited[xx][yy]=false;
		}
	}
	
	//한붓 그리기 불가능한 경우
	private static void dfsOther(int i, int j) {
		int total = 4;
		int sum = map[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < 4; k++) {
			if(total<3)return;
			
			int xx = dx[k]+i;
			int yy = dy[k]+j;
			
			if(xx<0||yy<0||xx>=N||yy>=M) {
				total--;
				continue;
			}
			
			min = Math.min(min, map[xx][yy]);
			sum+=map[xx][yy];
		}
		
		if(total==4) {
			sum -=min;
		}
		ans=Math.max(sum, ans);
	}
	
}
