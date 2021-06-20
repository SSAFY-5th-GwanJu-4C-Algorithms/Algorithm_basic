package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_10282_해킹 {
	
	static int n, d, c;
	static int a, b, s;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Computer>[] adjList;
	static int[] time;
	static boolean[] visited;
	
	static class Computer implements Comparable<Computer>{
		int num;
		int time;
		
		public Computer(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Computer o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.valueOf(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.valueOf(st.nextToken()); // 컴퓨터의 갯수
			d = Integer.valueOf(st.nextToken()); // 의존성 갯수
			c = Integer.valueOf(st.nextToken()); // 해킹당한 컴퓨터의 번호(시작점)
			
			adjList = new ArrayList[n+1];
			
			for(int i=1; i<=n; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.valueOf(st.nextToken());
				b = Integer.valueOf(st.nextToken());
				s = Integer.valueOf(st.nextToken());
				
				adjList[b].add(new Computer(a,s));
			}
			
			dijkstra();
			
			int cnt = 0;
			int maxTime = 0;
			
			for(int i=1; i<=n; i++) {
				if(time[i] == INF) continue;
				cnt++;
				if(time[i] > maxTime) {
					maxTime = time[i];
				}
			}
			
			sb.append(cnt).append(" ").append(maxTime).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static void dijkstra() {
		time = new int[n+1];
		visited = new boolean[n+1];
		PriorityQueue<Computer> pq = new PriorityQueue<>(); //시작점으로 부터 가장 가까운 컴퓨터
		
		Arrays.fill(time, INF);
		time[c] = 0;
		pq.offer(new Computer(c, 0));
		
		while(!pq.isEmpty()) {
			Computer current = pq.poll();
			visited[current.num] = true;
			
			for(Computer next : adjList[current.num]) {
				if(!visited[next.num] && time[next.num] > current.time + next.time) {
					time[next.num] = current.time + next.time;
					pq.offer(new Computer(next.num, time[next.num]));
				}
			}
		}
	}

}
