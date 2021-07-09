package study.July.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ_11279_√÷¥Î»¸ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int cur = Integer.valueOf(br.readLine());
			if(cur == 0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
			else {
				pq.add(cur);
			}
		}
	
	}

}
