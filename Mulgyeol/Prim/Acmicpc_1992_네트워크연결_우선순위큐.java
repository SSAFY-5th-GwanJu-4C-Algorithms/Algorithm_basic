import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_1992_네트워크연결_우선순위큐 {
	
	static class Computer implements Comparable<Computer>{
		
		int num;
		int value;
		
		Computer(int num, int value){
			this.num = num;
			this.value = value;
		}

		@Override
		public int compareTo(Computer o) {
			return this.value - o.value;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(br.readLine());
		int M = Integer.valueOf(br.readLine());
		
		ArrayList<Computer>[] adjList = new ArrayList[N+1];
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		int[] minLength = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			minLength[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int value = Integer.valueOf(st.nextToken());
			
			adjList[a].add(new Computer(b, value));
			adjList[b].add(new Computer(a, value));
		}
		
		minLength[1] = 0;
		int answer = 0;
		pq.add(new Computer(1,0));
		
		for(int i=1; i<=N; i++) {
			int vertex = 0;
			Computer next = new Computer(0,0);
			
			while(!pq.isEmpty()) {
				Computer nextTemp = pq.poll();
				if(!visited[nextTemp.num]) {
					next = nextTemp;
					break;
				}
			}
			vertex = next.num;
			
			visited[vertex] = true;
			answer += minLength[vertex];
			System.out.println(vertex+"번");
			System.out.println(minLength[vertex]+"를 더해서 값은"+answer);
			
			for(Computer linkedVertex : adjList[vertex]) {
				if(!visited[linkedVertex.num] && minLength[linkedVertex.num] > linkedVertex.value) {
					minLength[linkedVertex.num] = linkedVertex.value;
					pq.offer(linkedVertex);
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
