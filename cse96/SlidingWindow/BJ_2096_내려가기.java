package study.June.Slide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2096_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int max[] = new int[3];
		int min[] = new int[3];
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
				int v1 = Integer.valueOf(str[0]);
				int v2 = Integer.valueOf(str[1]);
				int v3 = Integer.valueOf(str[2]);
				if(i == 0) {
					max[0] = min[0] = v1;
					max[1] = min[1] = v2;
					max[2] = min[2] = v3;
				}
				else {
					int before_max0 = max[0];
					int before_max1 = max[1];
					max[0] = v1 + Math.max(max[0], max[1]);
					max[1] = v2 + Math.max(before_max0, Math.max(max[1], max[2]));
					max[2] = v3 + Math.max(before_max1, max[2]);
					
					int before_min0 = min[0];
					int before_min1 = min[1];
					min[0] = v1 + Math.min(min[0], min[1]);
					min[1] = v2 + Math.min(before_min0, Math.min(min[1], min[2]));
					min[2] = v3 + Math.min(before_min1, min[2]);
				}
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(max[0], Math.max(max[1], max[2]))).append(" ").append(Math.min(min[0], Math.min(min[1], min[2])));
		System.out.println(sb.toString());
		
	}

}
