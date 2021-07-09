package study.July.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class BJ_11286_Àý´ñ°ªÈü {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i = 0; i < N; i++) {
			int cur = Integer.valueOf(br.readLine());
			if(cur == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else {
					Node c = pq.poll();
					System.out.println(c.cur);
				}
			}
			else {
				pq.add(new Node(cur));
			}
			
		}
		
		
	}
	static class Node implements Comparable<Node>{
		int cur;
		int abs;
		
		public Node(int cur) {
			this.cur = cur;
			this.abs = Math.abs(cur);
		}

		@Override
		public int compareTo(Node o) {
			if(this.abs == o.abs) {
				return this.cur < o.cur ? -1 : 1;
			}
			return this.abs < o.abs ? -1 : 1;
		}
	}
}
