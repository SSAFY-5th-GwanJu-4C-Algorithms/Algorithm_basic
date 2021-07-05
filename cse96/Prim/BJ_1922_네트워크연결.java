package study.July.Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_1922_네트워크연결 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//컴퓨터 수
		int M = Integer.valueOf(br.readLine());//선의 수
		
		boolean visit[] = new boolean[N+1];
		
		ArrayList<ArrayList<Node>> l = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i <= N; i++) {
			l.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			String str[] = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			l.get(from).add(new Node(to,dist));
			l.get(to).add(new Node(from,dist));
		}
		int ans = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(1,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visit[cur.to]) continue;
			visit[cur.to] = true;
			ans += cur.dist;
			for(Node next : l.get(cur.to)) {
				if(visit[next.to]) continue;
				pq.add(next);
			}
		}
		System.out.println(ans);
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
			// TODO Auto-generated method stub
			return this.dist < o.dist ? -1 : 1;
		}
	}
}
