package study.June.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int cnt = 0;
		
		int map[][] = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}//입력 끝
		
		boolean visit[][][] = new boolean[2][N][M];
		boolean flag = false;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0,0));
		visit[0][0][0] = true;
		while(!q.isEmpty()) {
			if(flag) break;
			Node n = q.poll();
			for(int dir = 0; dir < 4; dir++) {
				int nx = n.x + dx[dir];
				int ny = n.y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[n.broken][nx][ny]) continue;
				else {
					if(nx == N-1 && ny == M-1) {
						cnt = n.time+1;
						flag = true;
					}
					if(map[nx][ny] == 0) {
						visit[n.broken][nx][ny] = true;
						q.add(new Node(nx,ny,n.time+1,n.broken));
					}
					else {
						if(n.broken == 1) continue;
						else {
							q.add(new Node(nx,ny,n.time+1,1));
							visit[1][nx][ny] = true;
						}
					}
					
				}
			}
		}
		if(!flag && (N!=1&&M!=1)) System.out.println(-1);
		else
			System.out.println(cnt+1);
		
	}
	
	static class Node{
		int x,y,time;
		int broken;
		public Node(int x, int y, int time, int broken) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.broken = broken;
		}
	}
}
