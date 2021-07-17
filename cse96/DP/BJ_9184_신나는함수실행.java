package study.July.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_9184_신나는함수실행 {
	static int dp [][][] = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		init();
		while(true) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int c = Integer.valueOf(str[2]);
			if(a == -1 && b == -1 && c == -1) break;
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(")").append(" = ").append(ret(a,b,c));
				System.out.println(sb.toString());
			}
		}
		
		
	}
	private static int ret(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) return 1;
		if(a > 20 || b > 20 || c > 20) return dp[20][20][20];
		else return dp[a][b][c];
	}
	private static void init() {
		for(int i = 1; i < 21; i++) {
			for(int j = 1; j < 21; j++) {
				for(int k = 1; k < 21; k++) {
					if(i <= 0 || j <= 0 || k <= 0) dp[i][j][k] = 1;
					if(i < j && j < k) {
						dp[i][j][k] = ret(i,j,k-1) + ret(i,j-1,k-1) -ret(i,j-1,k);
					}
					else {
						dp[i][j][k] = ret(i-1,j,k) + ret(i-1,j-1,k) + ret(i-1,j,k-1) - ret(i-1,j-1,k-1);
					}
				}
			}
		}
	}
}
