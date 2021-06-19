package study.June.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_1504_특정한최단경로 {
	
	static int N;
	static final int INF = 100000000;
	static ArrayList<ArrayList<Node>> l = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);//정점의 개수
		int V = Integer.valueOf(str[1]);//간선의 개수
		for(int i = 0; i <= N;i++) {
			l.add(new ArrayList<Node>());
		}
		for(int i = 0; i < V; i++) {
			str = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			l.get(from).add(new Node(to,dist));
			l.get(to).add(new Node(from,dist));
		}
		str = br.readLine().split(" ");
		int evit1 = Integer.valueOf(str[0]);
		int evit2 = Integer.valueOf(str[1]);
		
		int evit = dijkstra(evit1,evit2);
		int temp1 = dijkstra(1,evit1) + dijkstra(evit2,N);
		int temp2 = dijkstra(1,evit2) + dijkstra(evit1,N);
		long result = Math.min(temp1,temp2) + evit;
		if(result>0)
		System.out.println(result);
		else {
			System.out.println(-1);
		}
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visit[] = new boolean[N+1];
		int result[] = new int[N+1];
		Arrays.fill(result, INF);
		result[start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.to == end) {
				return cur.dist;
			}
			if(visit[cur.to]) continue;
			else {
				visit[cur.to] = true;
				for(Node next : l.get(cur.to)) {
					if(result[next.to] > result[cur.to] + next.dist) {
						result[next.to] = result[cur.to] + next.dist;
						pq.add(new Node(next.to, result[next.to]));
					}
				}
			}
		}
		return -100000;
	}

	static class Node implements Comparable<Node>{
		int to,dist;
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
