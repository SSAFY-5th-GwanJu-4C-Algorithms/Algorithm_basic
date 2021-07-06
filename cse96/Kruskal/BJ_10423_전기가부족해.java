package study.July.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ_10423_전기가부족해 {
	static int[] parents;
	static boolean[] supplied;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);//도시의 수
		int M = Integer.valueOf(str[1]);//케이블의 수
		int K = Integer.valueOf(str[2]);//발전소 개수
		
		supplied = new boolean[N+1];
		str = br.readLine().split(" ");
		for(int i = 0; i < K; i++) {
			int idx = Integer.valueOf(str[i]);
			supplied[idx] = true;
		}
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		ArrayList<ArrayList<Edge>> l = new ArrayList<ArrayList<Edge>>();
		for(int i = 0; i <= N; i++) {
			l.add(new ArrayList<Edge>());
		}
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int from = Integer.valueOf(str[0]);
			int to = Integer.valueOf(str[1]);
			int dist = Integer.valueOf(str[2]);
			l.get(from).add(new Edge(from,to,dist));
			l.get(to).add(new Edge(to,from,dist));
			if(supplied[from])
				pq.add(new Edge(from, to ,dist));
			if(supplied[to]) {
				pq.add(new Edge(to,from,dist));
			}
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int start = cur.from;
			int end = cur.to;
			if(check()) break;
			int a = find(start);
			int b = find(end);
			if(a == b) continue;
			if(supplied[a] && supplied[b]) continue;
			union(start,end);
			if(supplied[a]) {
				for(Edge next : l.get(a)) {
					pq.add(next);
				}
			}
			if(supplied[b]) {
				for(Edge next : l.get(b)) {
					pq.add(next);
				}
			}
			ans += cur.dist;
		}
		System.out.println(ans);
		
	}
	private static void union(int start, int end) {
		int sRoot = parents[start];
		int eRoot = parents[end];
		if(sRoot == eRoot) return;
		if(supplied[sRoot]) {
			parents[end] = start;
			supplied[end] = true;
		}
		else if(supplied[eRoot]) {
			parents[start] = end;
			supplied[start] = true;
		}
	}
	private static int find(int cur) {
		if(parents[cur] == cur) return cur;
		parents[cur] = find(parents[cur]);
		return parents[cur];
	}
	private static boolean check() {
		for(int i = 1; i <= N; i++) {
			if(supplied[i] == false) {
				return false;
			}
		}
		return true;
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
			// TODO Auto-generated method stub
			return this.dist < o.dist ? -1 : 1;
		}
		
	}
}
