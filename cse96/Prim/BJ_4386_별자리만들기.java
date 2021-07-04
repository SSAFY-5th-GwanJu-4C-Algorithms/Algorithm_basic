package study.July.Prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class BJ_4386_별자리만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		ArrayList<ArrayList<Node>> nl = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i <= N; i++) {
			nl.add(new ArrayList<Node>());
		}
		ArrayList<Cord> l = new ArrayList<Cord>();
 		for(int i = 1; i <= N; i++) {
			String str[] = br.readLine().split(" ");
			double x = Double.valueOf(str[0]);
			double y = Double.valueOf(str[1]);
			Cord c = new Cord(x,y,i);
			l.add(c);
		}//입력 끝
 		
 		//dist계산해서 PQ에 넣기
 		for(int i = 0; i < N - 1; i++) {
 			for(int j = i + 1; j < N; j++) {
 				Cord c1 = l.get(i);
 				Cord c2 = l.get(j);
 				int from = c1.seq;
 				int to = c2.seq;
 				
 				double absx = Math.abs(c1.x - c2.x);
 				double absy = Math.abs(c1.y - c2.y);
 				double dist = Math.sqrt(Math.pow(absx, 2) + Math.pow(absy, 2));
 				nl.get(from).add(new Node(to,dist));
 				nl.get(to).add(new Node(from,dist));
 			}
 		}
 		PriorityQueue<Node> pq = new PriorityQueue<Node>();
 		pq.add(new Node(1,0));
 		boolean[] visit = new boolean[N+1];
 		double result = 0;
 		while(!pq.isEmpty()) {
 			Node cur = pq.poll();
 			if(visit[cur.to]) continue;
 			visit[cur.to] = true;
 			result += cur.dist;
 			for(Node next : nl.get(cur.to)) {
 				if(!visit[next.to]) {
 					pq.add(next);
 				}
 			}
 		}
 		System.out.println(result);
	}
	static class Cord {
		double x;
		double y;
		int seq;
		public Cord(double x, double y, int seq) {
			this.x = x;
			this.y = y;
			this.seq = seq;
		}
		
	}
	static class Node implements Comparable<Node>{
		int to;
		double dist;
		
		public Node(int to, double dist) {
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
