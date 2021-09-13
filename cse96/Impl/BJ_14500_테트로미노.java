package study.September;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14500_테트로미노 {
	
	static int N,M,max = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		M = Integer.valueOf(str[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.valueOf(str[j]);
			}
		}//입력 끝
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(i,j,0,0);
				special(i,j);
			}
		}
		
		
		System.out.println(max);
		br.close();
	}
	private static void special(int r, int c) {
		int extra = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[r][c];
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			
			if(extra < 3) return;
			//맵 모서리에서 걸친경우
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
				extra--;
				continue;
			}
			min = Math.min(min, map[nr][nc]);
			sum += map[nr][nc];
		}
		if(extra == 4) sum -= min;
		
		max = Math.max(max, sum);
		
	}
	private static int dfs(int r, int c, int size, int sum) {
		if(size == 4) {
			max = Math.max(max, sum);
			return 0;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dx[dir];
			int nc = c + dy[dir];
			if(nc >= 0 && nr >= 0 && nr < N && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr,nc,size+1,sum+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
		
		return sum;
		
	}

}
