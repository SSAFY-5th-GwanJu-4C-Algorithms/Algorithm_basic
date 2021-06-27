package Two_Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_3273_두수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		int x = Integer.valueOf(br.readLine());
		
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		
		int answer = 0;
		
		while(start < end) {
			int sum = arr[start]+arr[end];
			if(sum == x) {
				answer++;
				start++;
			}
			if(sum < x) {
				start++;
			}
			if(sum > x) {
				end--;
			}
		}
		
		System.out.println(answer);
	}

}
