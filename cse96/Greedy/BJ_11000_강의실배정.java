package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11000_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
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
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//정렬 후 첫 강의 종료시간 우선순위 큐에 넣어줌
		pq.offer(arr[0][1]);
		
		for(int i = 1; i < N; i++) {
			//현재 탐색하는 강의의 종료시간
			int end = arr[i][1];
			//비어있지않고 강의 종료시간보다 시작시간이 크거나 같으면
			if(!pq.isEmpty() && pq.peek() <=  arr[i][0]) {
				pq.poll();//해당 종료시간을 없앰, 이 강의가 이뤄진 강의실에서 현재 강의가 이뤄짐
			}
			//지금 강의의 종료시간을 넣어줌
			pq.offer(end);
		}
		System.out.println(pq.size());

	}
}

