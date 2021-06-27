package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Acmicpc_14602_소금과후추 {
	
	static int R, C, T;
	static int[][] image;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		image = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				image[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		T = Integer.valueOf(br.readLine());
		
		int r = R-2;
		int c = C-2;
		int answer = 0;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				initPriorityQueue(i,j);
				int median = findMedian();
				if(median >= T) {
					answer++;
				}
			}
		}
		

		System.out.println(answer);
		
		
	}

	private static int findMedian() {
		int[] arr =  new int[4];
		for(int i=0; i<4; i++) {
			arr[i] = pq.poll(); 
		}
		int median = pq.poll();
		return median;
	}

	private static void initPriorityQueue(int r, int c) {
		pq = new PriorityQueue<>();
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				pq.offer(image[i][j]);
			}
		}
	}
}
