package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		int M = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.valueOf(st.nextToken());
			int result = search(num,0,N-1, arr);
			sb.append(result).append("\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
	
	static int search(int num, int left, int right, int[] arr) {
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(arr[mid] == num) {
				return 1;
			}else if(arr[mid] > num) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		
		return 0;
	}

}
