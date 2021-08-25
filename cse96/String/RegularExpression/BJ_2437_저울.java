package August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2437_저울 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.valueOf(br.readLine());
		String str[] = br.readLine().split(" ");
		ArrayList<Integer> l = new ArrayList<Integer>();
//		int idx = 0;
		for(int i = 0; i < N; i++) {
			int num = Integer.valueOf(str[i]);
			l.add(num);
//			idx += num;
		}
		
		Collections.sort(l);
		if(l.get(0) != 1) {
			System.out.println(1);
			return;
		}
		else {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(l.get(i) > sum + 1) {
					break;
				}
				sum += l.get(i);
			}
			System.out.println(sum + 1);
		}
//		int[][] possible = new int[idx+1][2];
//		//입력 & 정렬 끝
//		
//		int max_idx = 0;
////		System.out.println(l.toString());
//		for(int i = 0; i < N; i++) {
//			int cur = l.get(i);
//			possible[cur][0]++;
//			max_idx += cur;
//			int j = 1;
//			while(j + cur <= max_idx) {
//				if(possible[cur][0] != 0 && possible[cur][1] != -max_idx) {
//					possible[j+cur][0]++;
//					possible[j+cur][1] = -max_idx;
//				}
//				j++;
//			}
//			
//		}
////		System.out.println(max_idx);
////		System.out.println(Arrays.toString(possible));
//		for(int i = 1; i < max_idx; i++) {
//			if(possible[i][0] == 0) {
//				System.out.println(i);
//				break;
//			}
//		}
		
	}

}
