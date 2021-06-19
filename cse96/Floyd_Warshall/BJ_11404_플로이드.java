package study.June.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11404_플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//N개의도시(정점
		int M = Integer.valueOf(br.readLine());//M개의 버스(간선
		
		int graph[][] = new int[N][N];
		final int INF = 10000000;
		for(int i = 0; i < N; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}//초기화
		for(int i = 0; i < M; i++) {
			String str[] = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			graph[from-1][to-1] = Math.min(graph[from-1][to-1], dist);
		}//입력 끝
		
		//floyd!
		//경유 k
		for(int k = 0; k < N; k++) {
			//출발 i
			for(int i = 0; i < N; i++) {
				if(i == k) continue;
				//도착 j
				for(int j = 0; j < N; j++) {
					if(i == j || j == k) continue;
					if(graph[i][j] > graph[i][k] + graph[k][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] >= INF) graph[i][j] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.setLength(0);
			for(int j = 0; j < N; j++) {
				sb.append(graph[i][j]).append(" ");
			}
			System.out.println(sb.toString());
		}
		
		
		
		
		
	}

}
