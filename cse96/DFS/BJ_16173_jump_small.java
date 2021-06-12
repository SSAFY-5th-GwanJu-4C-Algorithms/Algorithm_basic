package study.June;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16173_jump_small {
	static int square[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean flag = false;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		square = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				square[i][j] = Integer.valueOf(st.nextToken());
			}
		}//입력 끝
		
		dfs(0,0);
		if(!flag) {
			System.out.println("Hing");
		}
	}
	
	private static void dfs(int x, int y) {
		if(flag) return;
		int jump = square[x][y];//몇칸 이동할지!
		square[x][y] = -2;
		if(jump == 0 || jump == -2) return;
		else if(jump == -1) {
			flag = true;
			System.out.println("HaruHaru");
		}
		else {//0칸 이동하는게 아니라면
			for(int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir] * jump;
				int ny = y + dy[dir] * jump;
				if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
				else	dfs(nx,ny);
				
			}
		}
	}

}
