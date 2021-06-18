package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_18352_특정거리의도시찾기 {

	static int N, M, K, X;
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] distance;
	static PriorityQueue<Node> pq;
	static PriorityQueue<Integer> pqAnswer;
	static ArrayList<Integer>[] adjList;
	
	static class Node implements Comparable<Node>{
		int num;
		int distance;
		
		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	} 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		pq = new PriorityQueue<>();
		pqAnswer = new PriorityQueue<>();
		
		N = Integer.valueOf(st.nextToken()); //도시 갯수
		M = Integer.valueOf(st.nextToken()); //도로 갯수
		K = Integer.valueOf(st.nextToken()); //거리 정보
		X = Integer.valueOf(st.nextToken()); //출발 도시의 번호
		
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			
			adjList[from].add(to);
		}
		
		dijkstra();
		
		if(pqAnswer.isEmpty()) {
			System.out.println(-1);
		}
		
		while(!pqAnswer.isEmpty()) {
			System.out.println(pqAnswer.poll());
		}
		
		
	}

	private static void dijkstra() {
		visited = new boolean[N+1];
		distance = new int[N+1];
		
		Arrays.fill(distance, INF);
		distance[X] = 0;
		pq.offer(new Node(X,distance[X]));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curNum = curNode.num;
			int curDis = curNode.distance;
			
			if(curDis==K) {
				pqAnswer.offer(curNum);
			}
			
			if(curDis>K) {
				return;
			}
			
			visited[curNum] = true;
			
			for(int next : adjList[curNum]) {
				if(!visited[next] && distance[next]>curDis+1) {
					distance[next] = curDis+1;
					pq.offer(new Node(next, distance[next]));
				}
			}
		}
	}

}
