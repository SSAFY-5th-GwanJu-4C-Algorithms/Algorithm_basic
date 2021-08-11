package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//도시의 개수
		long[] arr = new long[N];
		long[] price = new long[N];
		
		String str[] = br.readLine().split(" ");
		for(int i = 0; i < N - 1; i++) {
			arr[i] = Long.valueOf(str[i]);
		}
		
		str = br.readLine().split(" ");

		for(int i = 0; i < N; i++) {
			price[i] = Long.valueOf(str[i]);
		}
		//입력 끝

		long min = Long.MAX_VALUE;
		long sum = 0l;
		
		for(int i = 0; i < N - 1; i++) {
			if(min > price[i]) {
				min = price[i];
			}
			sum = sum + min * arr[i];
		}//for
		System.out.println(sum);
	}//main

}
