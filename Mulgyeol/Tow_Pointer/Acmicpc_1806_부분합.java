package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int S = Integer.valueOf(st.nextToken());
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		sum += arr[right++];
		
		while(true) {
			if(sum >= S) {
				sum -= arr[left++];
				answer = Math.min(answer, right-left+1);
			}else {
				sum +=arr[right++];
			}
			
			if(right == N && sum < S) {
				break;
			}

		}
		
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		
		System.out.println(answer);
		
		
		
	}

}
