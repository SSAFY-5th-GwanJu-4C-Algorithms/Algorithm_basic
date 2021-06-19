package study.June.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.valueOf(st.nextToken());//정점의 개수
		int E = Integer.valueOf(st.nextToken());//간선의 개수
		int start = Integer.valueOf(br.readLine());//시작 정점
		int INF = 10000000;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		ArrayList<ArrayList<Node>> l = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i <= V; i++) {
			l.add(new ArrayList<Node>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			int dist = Integer.valueOf(st.nextToken());
			l.get(from).add(new Node(to,dist));
		}//입력 끝
		
		int result[] = new int[V+1];
		Arrays.fill(result, INF);
		result[start] = 0;
		boolean visit[] = new boolean[V+1];
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visit[cur.to]) continue;
			else {
				visit[cur.to] = true;
				for(Node next : l.get(cur.to)) {
					if(result[next.to] > result[cur.to] + next.dist) {
						result[next.to] = result[cur.to] + next.dist;
						pq.add(new Node(next.to , result[next.to]));
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(result[i] == INF) sb.append("INF\n");
			else sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	static class Node implements Comparable<Node>{
		int to;
		int dist;
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return this.dist < o.dist?-1:1;
		}
		
	}
}
