package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BJ_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		LinkedList<Class> l = new LinkedList<Class>();
//		for(int i = 0; i < N; i++) {
//			String str[] = br.readLine().split(" ");
//			l.add(new Class(Integer.valueOf(str[0]),Integer.valueOf(str[1])));
//		}//입력 끝
		
//		Collections.sort(l, (o1,o2)->{
//			return o1.start - o2.start;
//		});//정렬
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			arr[i][0] = Integer.valueOf(str[0]);
			arr[i][1] = Integer.valueOf(str[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
		int count = 1;
		int tmp = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(arr[0][1]);
		
		for(int i = 1; i < N; i++) {
			int end = arr[i][1];
			
			if(!pq.isEmpty() && pq.peek() <=  arr[i][0]) {
				pq.poll();
			}
			pq.offer(end);
		
//		for(int i = 1; i < N; i++) {
//			if(l.get(tmp).end <= l.get(i).start) {
//				count++;
//				tmp = i;
//			}
//		}
//		for(int i = 1; i < N; i++) {
//			//강의 끝나는 시간보다 강의 시작시간이 더 빠르면
//			if(arr[tmp][1] > arr[i][0]) {
//				//강의실 개수 증가
//				count++;
////				tmp = i;
//			}
//			else if(arr[tmp][1] == arr[i][0]) {
//				tmp = i;
//			}
			
		}
		System.out.println(pq.size());

	}

}

//class Class implements Comparator<Class>{
//	int start;
//	int end;
//	
//	Class(int start, int end){
//		this.start = start;
//		this.end = end;
//	}
//
//	@Override
//	public int compare(Class o1, Class o2) {
//		return o1.start - o2.start;
//	}
//}