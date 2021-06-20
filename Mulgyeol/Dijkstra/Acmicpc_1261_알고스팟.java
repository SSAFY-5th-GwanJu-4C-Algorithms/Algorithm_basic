package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_1261_알고스팟 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M, answer;
	static int[][] map, brokenWallCnt;
	static boolean[][] visited;
	static final int INF = Integer.MAX_VALUE;
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		brokenWallCnt = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j)-'0');
				brokenWallCnt[i][j] = INF;
			}
		}
		
		dijkstra();
		System.out.println(answer);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		brokenWallCnt[0][0] = 0;
		pq.offer(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			if(current.x == N-1 && current.y==M-1) {
				answer = current.cnt;
				return;
			}
			
			visited[current.x][current.y] = true;
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if(nx >=0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
					
					int wall = map[nx][ny] == 1 ? 1 : 0;
					
					if(brokenWallCnt[nx][ny] > brokenWallCnt[current.x][current.y] + wall) {
						brokenWallCnt[nx][ny] = brokenWallCnt[current.x][current.y] + wall;
						pq.offer(new Node(nx,ny,brokenWallCnt[nx][ny]));
					}
					
				}
			}
		}
	}

}
