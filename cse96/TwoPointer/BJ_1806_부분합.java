package study.June.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1806_ºÎºÐÇÕ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int S = Integer.valueOf(str[1]);
		
		int nums[] = new int[N+1];
		str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.valueOf(str[i]);
		}
		int start = 0;
		int end = 1;
		int ans = Integer.MAX_VALUE;
		int sum = nums[start];
		while(end <= N && start <= N) {
			if(sum >= S && ans > end - start) {
				ans = end - start;
			}
			if(sum < S) {
				sum += nums[end++];
			}
			else {
				sum -= nums[start++];
			}
		}
		if(ans == Integer.MAX_VALUE) {
			System.out.println(0);
		}
		else if(ans == 0) System.out.println(1);
		else {
			System.out.println(ans);
		}
	}

}
