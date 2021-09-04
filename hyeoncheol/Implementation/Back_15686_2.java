package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_15686_2 {
	static int N,M,ans=Integer.MAX_VALUE;
	static int[][] map;
	//치킨집
	static ArrayList<point> chi = new ArrayList<>();
	//선택한 치킨집
	static ArrayList<point> sel = new ArrayList<>();
	static ArrayList<point> per = new ArrayList<>();
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					per.add(new point(i, j));
				}else if(map[i][j]==2) {
					chi.add(new point(i,j));
				}
			}
		}
		
		visited = new boolean[chi.size()];
		perm(0,0);
		
		System.out.println(ans);
	}
	private static void perm(int start,int cnt) {
		if(cnt == M) {
			disSum();
			return;
		}
		
		for (int i = start; i < chi.size(); i++) {
			if(!visited[i]) {
				visited[i]=true;
				sel.add(chi.get(i));
				perm(i+1,cnt+1);
				sel.remove(sel.size()-1);
				visited[i]=false;
			}
		}
	}
	private static void disSum() {
		int sum = 0;
		for (int i = 0; i < per.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < sel.size(); j++) {
				min = Math.min(Math.abs(per.get(i).x-sel.get(j).x) + Math.abs(per.get(i).y-sel.get(j).y),min);
			}
			sum+=min;
		}
		ans = Math.min(sum,ans);
	}
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
