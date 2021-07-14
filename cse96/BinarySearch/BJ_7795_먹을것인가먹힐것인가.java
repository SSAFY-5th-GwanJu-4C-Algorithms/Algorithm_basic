package study.July.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_7795_먹을것인가먹힐것인가 {

	static ArrayList<Integer> A = new ArrayList<Integer>();
	static ArrayList<Integer> B = new ArrayList<Integer>();
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			A.clear();
			B.clear();
			String str[] = br.readLine().split(" ");
			int N = Integer.valueOf(str[0]);
			M = Integer.valueOf(str[1]);
			str = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				A.add(Integer.valueOf(str[i]));
			}
			str = br.readLine().split(" ");
			for(int i = 0; i < M; i++) {
				B.add(Integer.valueOf(str[i]));
			}//입력 끝
			
			Collections.sort(B);
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				cnt += binarySearch(A.get(i));
			}
			System.out.println(cnt);
		}
	}
	//target보다 mid_value가 크면 right = mid_idx - 1;
	//target이 mid_value보다 크면 left = mid_idx + 1; ans = mid_idx;
	private static int binarySearch(Integer target) {
		int left = 0;
		int right = M - 1;
		int ans = 0;
		while(left <= right) {
			int mid_idx = (left + right) / 2;
			int mid_value = B.get(mid_idx);
			if(mid_value >= target) {
				right = mid_idx - 1;
			}
			else {
				left = mid_idx + 1;
				ans = left;
			}
		}
		if ( ans == 0) return 0;
		return ans;
	}

}
