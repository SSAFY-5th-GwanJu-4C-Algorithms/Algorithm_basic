package study.June.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ_9370_미확인도착지 {
	static int n,g,h;
	static ArrayList<ArrayList<Road>> l = new ArrayList<ArrayList<Road>>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc = 0; tc <= T; tc++) {
			String str[] = br.readLine().split(" ");
			n = Integer.valueOf(str[0]);//교차로
			int m = Integer.valueOf(str[1]);//도로
			int t = Integer.valueOf(str[2]);//목적지 후보 수
			String str2[] = br.readLine().split(" ");
			int s = Integer.valueOf(str2[0]);//출발지
			g = Integer.valueOf(str2[1]);//g와h를 지나는 교차로를 지남
			h = Integer.valueOf(str2[2]);//
			for(int i = 0; i <= n; i++) l.add(new ArrayList<Road>());
			
			for(int i = 0; i < m; i++) {
				String str3[] = br.readLine().split(" ");
				int from = Integer.valueOf(str3[0]);
				int to = Integer.valueOf(str3[1]);
				int dist = Integer.valueOf(str3[2]);
				l.get(from).add(new Road(to,dist,false));
			}//입력 끝
			ArrayList<Integer> candidate = new ArrayList<Integer>();
			for(int i = 0; i < t; i++) {
				candidate.add(Integer.valueOf(br.readLine()));
			}
			ArrayList<Integer> ans1 = new ArrayList<Integer>();
			ArrayList<Integer> ans2 = new ArrayList<Integer>();
			int temp1 = Integer.MAX_VALUE;
			int temp2 = Integer.MAX_VALUE;
			for(int i = 0; i < candidate.size(); i++) {
				int tmp = dijkstra(h,candidate.get(i));
				int tmp2 = dijkstra(g,candidate.get(i));
				if(temp1 > tmp) {
					ans1.clear();
					temp1 = tmp;
					ans1.add(candidate.get(i));
				}
				else if(temp1 == tmp) ans1.add(candidate.get(i));
				if(temp2 > tmp2) {
					ans2.clear();
					temp2 = tmp2;
					ans2.add(candidate.get(i));
				}
				else if(temp2 == tmp2) ans2.add(candidate.get(i));
			}
			int result1 = dijkstra(s,g) + temp1;
			int result2 = dijkstra(s,h) + temp2;
			StringBuilder sb = new StringBuilder();
			if(result1 > result2) {
				for(int i = 0; i < ans1.size(); i++) {
					sb.append(ans1.get(i)).append(" ");
				}
			}
			else if(result1 == result2){
				for(int i = 0; i < ans1.size(); i++) {
					sb.append(ans1.get(i)).append(" ");
				}
				for(int i = 0; i < ans2.size(); i++) {
					sb.append(ans2.get(i)).append(" ");
				}
			}
			else {
				for(int i = 0; i < ans2.size(); i++) {
					sb.append(ans2.get(i)).append(" ");
				}
			}
			System.out.println(tc + sb.toString());
		}
	}
	
	private static int dijkstra(int start, int end) {
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		pq.add(new Road(start,0,false));
		boolean visit[] = new boolean[n+1];
		int result[] = new int[n+1];
		Arrays.fill(result, Integer.MAX_VALUE);
		result[start] = 0;
		while(!pq.isEmpty()) {
			Road cur = pq.poll();
			if(cur.to == end) return cur.dist;
			if(visit[cur.to]) continue;
			else {
				visit[cur.to] = true;
				for(Road next : l.get(start)) {
					if(result[next.to] > result[cur.to] + next.dist) {
						result[next.to] = result[cur.to] + next.dist;
//						if(cur.to == g && next.to == h || cur.to == h && next.to == g) {
//							
//						}else {
							pq.add(new Road(next.to,result[next.to],cur.evit));
//						}
					}
				}
			}
		}
		return 0;
	}

	static class Road implements Comparable<Road>{
		int to,dist;
		boolean evit;
		public Road(int to, int dist, boolean evit) {
			this.to = to;
			this.dist = dist;
			this.evit = evit;
		}
		@Override
		public int compareTo(Road o) {
			return this.dist < o.dist ? -1:1;
		}
	}
}
