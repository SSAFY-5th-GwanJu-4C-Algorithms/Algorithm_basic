package Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Acmicpc_10025_게으른백곰 {
	
	static int N, K;
	static final int END_POINT = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.valueOf(st.nextToken()); //양동이의 갯수
		K = Integer.valueOf(st.nextToken()); //얼음의 양
		
		int[] arr = new int[END_POINT+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g = Integer.valueOf(st.nextToken());
			int idx = Integer.valueOf(st.nextToken());
			
			arr[idx] = g;
		}
		
		int answer = 0;
		int sum = 0;
		int left = 0;
		int right = 0;
		int range = K*2;
		
		while(right <= END_POINT) {
			if(right <= range) {
				sum += arr[right++];
			}
			
			if(right > range) {
				sum -= arr[left++];
				sum += arr[right++];
			}
			
			answer = Math.max(sum, answer);
		}
		
		System.out.println(answer);
	}

}
