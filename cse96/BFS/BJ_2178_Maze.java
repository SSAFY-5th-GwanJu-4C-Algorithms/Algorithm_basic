package study.June.DFS_BFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_Maze {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int maze[][];
	static boolean visit[][];
	static int N,M,cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		maze = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.valueOf(s.charAt(j)) - '0';
			}
		}//ÀÔ·Â ³¡
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0));
		maze[0][0] = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int dir = 0;dir < 4; dir++) {
				int nx = n.x + dx[dir];
				int ny = n.y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || maze[nx][ny] == 0) continue;
				else {
					if(nx == N-1 && ny == M-1) {
						if(cnt > n.time) {
							cnt = n.time+1;
						}
					}
					q.add(new Node(nx,ny,n.time+1));
					maze[nx][ny] = 0;
				}
			}
		}
		System.out.println(cnt+1);
		
	}
	
	static class Node{
		int x,y,time;
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
