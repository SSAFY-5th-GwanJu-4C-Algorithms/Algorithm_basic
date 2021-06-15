package study.June.DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {
	static ArrayList<Point> l;
	static int[][] farm;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int count, N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		StringTokenizer st;
		for(int tc = 0; tc < T; tc++) {
			count = 0;
			l = new ArrayList<Point>();
			st = new StringTokenizer(br.readLine());
			M = Integer.valueOf(st.nextToken());//가로길이 y
			N = Integer.valueOf(st.nextToken());//세로길이 x
			int K = Integer.valueOf(st.nextToken());//배추위치 개수
			farm = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.valueOf(st.nextToken());
				int x = Integer.valueOf(st.nextToken());
				l.add(new Point(x,y));
				farm[x][y] = 1;
			}//입력 끝

			for(Point p : l) {
				if(check(p)) {
					count++;
				}
			}
			System.out.println(count);

		}
	}
	private static boolean check(Point p) {
		if(farm[p.x][p.y] == 0) return false;
		else {
//			dfs(p.x,p.y);
			bfs(p.x,p.y);
			return true;
		}
	}
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			farm[p.x][p.y] = 0;
			x = p.x;
			y = p.y;
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || farm[nx][ny] == 0) continue;
				else if(farm[nx][ny] == 1){
					q.add(new Point(nx,ny));
					farm[nx][ny] = 0;
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		farm[x][y] = 0;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || farm[nx][ny] == 0) continue;
			else {
				dfs(nx,ny);
			}
		}
	}

}
