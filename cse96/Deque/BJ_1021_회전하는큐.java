package study.August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		LinkedList<Integer> dq = new LinkedList<Integer>();
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		str = br.readLine().split(" ");
		for(int i = 1; i <= N; i++){
			dq.add(i);
		}//입력 끝
		int nums[] = new int[M];
		for(int i = 0; i < M; i++) {
			nums[i] = Integer.valueOf(str[i]);
		}
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			int target_idx = dq.indexOf(nums[i]);
			int half_idx;
			
			if(dq.peekFirst() == nums[i]) {
				dq.pollFirst();
				continue;
			}
			
			if(dq.size() % 2 == 0) {
				half_idx = dq.size() / 2 - 1;
			}
			
			else {
				half_idx = dq.size() / 2;
			}
			
			if(target_idx <= half_idx) {
				for(int j = 0; j < target_idx; j++) {
					dq.addLast(dq.pollFirst());
					cnt++;
				}
			}
			else {
				for(int j = 0; j < dq.size() - target_idx; j++) {
					dq.addFirst(dq.pollLast());
					cnt++;
				}
			}
			dq.pollFirst();
		}
		
		System.out.println(cnt);
		
	}

}
