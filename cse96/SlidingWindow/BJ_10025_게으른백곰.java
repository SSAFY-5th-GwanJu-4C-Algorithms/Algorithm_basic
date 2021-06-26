package study.June.Slide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10025_게으른백곰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);//양동이 개수
		int K = Integer.valueOf(str[1]);//범위
		int ice_bucket[] = new int[100002];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			int ice = Integer.valueOf(str[0]);
			int loc = Integer.valueOf(str[1]);
			if(loc < min) min = loc;
			if(loc > max) max = loc;
			ice_bucket[loc] = ice;
			
		}
		int cnt = 0;
		for(int i = min; i <= min + 2*K; i++) {
			cnt += ice_bucket[i];
		}
		int ans = cnt;
		int minus = min;
		for(int i = min + 2*K + 1; i <= max; i++) {
			cnt -= ice_bucket[minus];
			cnt += ice_bucket[i];
			if(cnt > ans) ans = cnt;
			minus++;
		}
		System.out.println(ans);
	}

}
