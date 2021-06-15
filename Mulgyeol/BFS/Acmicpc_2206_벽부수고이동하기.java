package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Acmicpc_2206_벽부수고이동하기 {
	
	static int N, M;
	static int[][] map;
	static int answer;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		answer = 0;
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j)-'0');
			}
		}
		
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		Queue<boolean[][][]> visitedQueue = new LinkedList<>();
		
		boolean[][][] initialVisited = new boolean[N][M][2];
		initialVisited[0][0][0] = true;
		
		queue.offer(new int[] {0,0,1,0});
		visitedQueue.offer(initialVisited);
		
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			boolean[][][] visited = visitedQueue.poll();
			int x = current[0];
			int y = current[1];
			int step = current[2];
			int brokenWallCheck = current[3];
			
			if(x==N-1 && y==M-1) {
				answer = step;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nBrokenWallCheck;
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny][brokenWallCheck]) {
					if(brokenWallCheck == 0) { //벽을 부술 수 있으면,
						if(map[nx][ny]==1) {// 벽이라면
							nBrokenWallCheck = 1;
						}else {
							nBrokenWallCheck = 0;
						}
						
						visited[nx][ny][1] = true;
						visited[nx][ny][0] = true;
						queue.offer(new int[] {nx,ny,step+1,nBrokenWallCheck});
						visitedQueue.offer(visited);

					}
					
					if(brokenWallCheck == 1) {
						if(map[nx][ny]==0) {
							visited[nx][ny][1] = true;
							queue.offer(new int[] {nx,ny,step+1,1});
							visitedQueue.offer(visited);
						}
					}
				}
			}
		}
		answer = -1;
	}

}
