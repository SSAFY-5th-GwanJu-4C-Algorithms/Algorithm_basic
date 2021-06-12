import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_16147_점프왕쩰리 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(br.readLine()); // 게임 구역의 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		int[] start = {0,0,map[0][0]};
		dfs(start);
		
		if(flag) {
			System.out.println("HaruHaru");
		}else{
			System.out.println("Hing");
		}
	}

	private static void dfs(int[] current) {
		if(flag) return;
		
		int x = current[0];
		int y = current[1];
		int distance = current[2];
		
		visited[x][y] = true;
		
		//도착점
		if(x == N-1 && y == N-1) {
			flag = true;
			return;
		}
		
		int newX = x + distance;
		int newY = y + distance;
		
		//아래로
		if(newX < N && !visited[newX][y]) {
			int[] down = {newX, y, map[newX][y]};
			dfs(down);
		}
		
		//오른쪽으로
		if(newY < N && !visited[x][newY]) {
			int[] right = {x, newY, map[x][newY]};
			dfs(right);
		}
	}
}
