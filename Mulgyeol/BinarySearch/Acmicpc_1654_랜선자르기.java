package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_1654_랜선자르기 {
	
	static int K, N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		K = Integer.valueOf(st.nextToken());
		N = Integer.valueOf(st.nextToken());
		
		
		arr = new int[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 0;
		long right = arr[K-1];
		long answer = 0;
		
		while(true) {
			long mid = (left+right)/2;
			
			if(checkN(mid)) {
				if(mid == arr[K-1] || !checkN(mid+1)) {
					answer = mid;
					break;
				}
				
				left = mid+1;
			}else {
				right = mid-1;
			}
			
		}
		
		System.out.println(answer);	
	}
	
	static boolean checkN(long num) {
		System.out.println("numis" + num);
		int result = 0;
		for(int i=0; i<K; i++) {
			result += arr[i] / num;
		}
		
		if(result >= N) {
			return true;
		}
		
		return false;
	}

}
