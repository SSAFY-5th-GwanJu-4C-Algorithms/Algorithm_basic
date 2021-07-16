package study.July.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_1003_fibo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		int fibo[][] = new int[41][2];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		for(int i = 2; i <= 40; i++) {
			fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
			fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
		}
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.valueOf(br.readLine());
			System.out.println(fibo[N][0] + " " + fibo[N][1]);
		}
		
	}

}
