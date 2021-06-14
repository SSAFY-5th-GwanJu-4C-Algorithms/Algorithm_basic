package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Acmicpc_2178_미로탐색 {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = (int)(line.charAt(j)-'0');
			}
		}
		
		Queue<int []> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(new int[] {0,0,1});
		visited[0][0] = true;
		int n = N-1;
		int m = M-1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int step = cur[2];
			
			if(x == n && y == m) {
				System.out.println(step);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
					queue.offer(new int[] {nx,ny,step+1});
					visited[nx][ny] = true;
				}
			}
		}
		
	}

}
