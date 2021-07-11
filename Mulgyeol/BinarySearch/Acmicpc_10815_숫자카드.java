package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int num = Integer.valueOf(st.nextToken());
			
			int left = 0;
			int right = N-1;
			int find = 0;
			while(left <= right) {
				int mid = (left+right)/2;
				
				if(arr[mid] == num) {
					find = 1;
					break;
				}else if(arr[mid] > num) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			sb.append(find).append(" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
