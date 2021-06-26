package study.June.Slide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12847_꿀알바 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		int salary[] = new int[N];
		str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			salary[i] = Integer.valueOf(str[i]);
		}//입력 끝
		int start = 0;
		long sum = 0;
		for(int i = 0; i < M; i++) {
			sum += salary[i];
		}
		long max = sum;
		for(int i = M; i < N; i++) {
			sum -= salary[start];
			sum += salary[i];
			if (sum  > max) max =sum;
			start++;
		}
		System.out.println(max);
	}

}
