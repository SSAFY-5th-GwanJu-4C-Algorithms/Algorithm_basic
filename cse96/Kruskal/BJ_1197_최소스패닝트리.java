package study.July.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1197_최소스패닝트리 {

	static int parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int V = Integer.valueOf(str[0]);//정점 수
		int E = Integer.valueOf(str[1]);//간선 수
		
		parents = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parents[i] = i;
		}//자기 자신이 부모노드로 초기화
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		long result = 0;
		for(int i = 0; i < E; i++) {
			str = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			pq.add(new Edge(from,to,dist));
		}
		
		for(int i = 0; i < E; i++) {
			Edge cur = pq.poll();
			
			int start = cur.from;
			int end = cur.to;
			if(find(start) == find(end)) continue;
			union(start,end);
			result += cur.dist;
		}
		System.out.println(result);
		
	}
	private static void union(int a, int b) {
		int aRoot = parents[a];
		int bRoot = parents[b];
		if(aRoot != bRoot) {
			parents[aRoot] = b;
		}
	}
	private static int find(int a) {
		if(a == parents[a]) return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int dist;
		
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist < o.dist ? -1 : 1;
		}
		
	}
}
