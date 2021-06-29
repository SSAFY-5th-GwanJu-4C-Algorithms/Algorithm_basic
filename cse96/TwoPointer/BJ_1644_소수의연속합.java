package study.June.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_1644_소수의연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//입력끝
		int end = 4000001;
		int[] num = new int[end];
		for(int i = 2; i < end; i++) {
			num[i] = i;
		}
		ArrayList<Integer> prime_num = new ArrayList<Integer>();
		for(int i = 2; i < end; i++) {
			if(num[i] == 0) continue;
			
			for(int j = 2 * i; j < end; j += i) {
				num[j] = 0;
			}
			prime_num.add(i);
		}
		int cnt = 0;
		int size = prime_num.size();
		int s = 0;
		int e = 1;
		
		int sum = prime_num.get(0);
		while(e < size) {
			if(sum == N) {
				cnt++;
				sum -= prime_num.get(s++);
			}
			else if(sum < N) {
				sum += prime_num.get(e++);
			}
			else {
				sum -= prime_num.get(s++);
			}
			if(prime_num.get(s) > N) break;
		}
		System.out.println(cnt);
	
	}

}
