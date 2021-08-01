package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_3190_2 {
	static int N, L, K;
	//오 아 왼 위
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int map[][];
	static int ans=0;
	static ArrayList<snake> s = new ArrayList<>();
	static ArrayList<d> dirs = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		s.add(new snake(0, 0));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x - 1][y - 1]++;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			dirs.add(new d(time, d == 'L' ? -1 : 1));
		}
		
		sol(0,0,0);
		System.out.println(ans);
	}



	private static void sol(int x, int y,int dir) {
		boolean flag = false;
		while(true) {
			ans++;
			int xx = x+dx[dir];
			int yy = y+dy[dir];
			
			if(xx<0||yy<0||xx>=N||yy>=N) break;
			for (int i = 0; i < s.size(); i++) {
				if(s.get(i).x==xx && s.get(i).y==yy) {
					flag=true;
					break;
				}
			}
			if(flag==true) {
				break;
			}
			
			if(map[xx][yy]==1) {
				s.add(new snake(xx, yy));
			}else {
				s.add(new snake(xx,yy));
				s.remove(0);
			}
			
			x = xx;
			y = yy;
			
			if(!dirs.isEmpty() && dirs.get(0).t==ans) {
				dir = dir + dirs.get(0).d;
				if(dir==-1)dir=3;
				dir = dir%4;
				s.remove(0);
			}
		}
	}



	static class snake {
		int x;
		int y;

		public snake(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	static class d{
		int t;
		int d;
		public d(int t, int d) {
			super();
			this.t = t;
			this.d = d;
		}	
	}
}
