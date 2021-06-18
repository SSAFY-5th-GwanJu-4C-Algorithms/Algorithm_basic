package Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_18352_특정거리의도시찾기_기본구현 {

	static int N, M, K, X;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		N = Integer.valueOf(st.nextToken()); //도시 갯수
		M = Integer.valueOf(st.nextToken()); //도로 갯수
		K = Integer.valueOf(st.nextToken()); //거리 정보
		X = Integer.valueOf(st.nextToken()); //출발 도시의 번호
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			
			adjList[from].add(to);
		}
		
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		
		Arrays.fill(distance, INF);
		distance[X] = 0;
		
		for(int i=1; i<=N; i++) {
			int min = INF;
			int current = 0;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(distance[current] == K) {
				pq.offer(current);
			}
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjList[current].contains(j) && distance[j] > min + 1) {
					distance[j] = min + 1;
				}
			}
		}
		
		if(pq.isEmpty()) {
			System.out.print(-1);
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
		
	}

}
