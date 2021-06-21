package study.June.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_5972_택배배송 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		ArrayList<ArrayList<Node>> l = new ArrayList<ArrayList<Node>>();
		int result[] = new int[N+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		for(int i = 0; i <= N; i++) {
			l.add(new ArrayList<Node>());
		}
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			l.get(from).add(new Node(to,dist));
			l.get(to).add(new Node(from,dist));
		}
		//dijkstra
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visit[] = new boolean[N+1];
		pq.add(new Node(1,0));
		result[1] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.to == N) {
				System.out.println(cur.dist);
				break;
			}
			if(visit[cur.to]) continue;
			else {
				visit[cur.to] = true;
				for(Node next : l.get(cur.to)) {
					if(result[next.to] > result[cur.to] + next.dist) {
						result[next.to] = result[cur.to] + next.dist;
						pq.add(new Node(next.to,result[next.to]));
					}
				}
			}
		}
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
