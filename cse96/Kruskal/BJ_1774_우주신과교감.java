package study.May;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1774_우주신과교감 {
	static int parents[];
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());//노드 수
		int M = Integer.valueOf(st.nextToken());//연결된 간선 수
		
		Point[] map = new Point[N+1];
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;//부모노드가 자신으로 초기화
		}
		//좌표 입력
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			map[i] = new Point(x,y);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.valueOf(st.nextToken());
			int p2 = Integer.valueOf(st.nextToken());
			union(p1,p2);//이 두 좌표는 연결됨
		}
		//모든 간선 후보 생성 후 pq저장
		for(int i = 1; i < N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(i == j) continue;
				if(parents[i] != parents[j]) {//연결안됬으면
					double x = Math.pow(map[i].x - map[j].x,2);
					double y = Math.pow(map[i].y - map[j].y,2);
					double dist = Math.sqrt(x + y);
					pq.add(new Edge(i,j,dist));
				}
			}
		}
		double ans = 0;
		//간선 저장 후 union-find실행
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int start = edge.s;
			int end = edge.e;
			int aRoot = find(start);
			int bRoot = find(end);
			if(aRoot == bRoot) continue;
			
			union(start,end);
			ans += edge.v;
		}
		System.out.printf("%.2f",(double)Math.round(ans*100)/100);
		
	}
	
	private static void union(int a, int b) {//union에서는 부모노드가 다른경우만 들어옴
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot < bRoot) {
			parents[bRoot] = aRoot;
		}
		else if(bRoot < aRoot) {
			parents[aRoot] = bRoot;
		}
		else {
			return;
		}
	}

	private static int find(int a) {
		if(a == parents[a]) return a; //초기화된 상태면 자신을 리턴
		parents[a] = find(parents[a]);//find할 때마다 부모는 최상위 부모로 설정
		
		return parents[a];
	}

	
	static class Edge implements Comparable<Edge>{
		int s;//시작 정점
		int e;//끝 정점
		double v;//비용
		
		public Edge(int s, int e, double v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.v > o.v) {
				return 1;
			}
			else if(this.v < o.v) {
				return -1;
			}
			return 0;
		}
		
	}
}
