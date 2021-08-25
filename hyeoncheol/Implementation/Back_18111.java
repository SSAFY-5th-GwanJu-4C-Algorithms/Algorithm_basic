package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int ansS = Integer.MAX_VALUE;
		int ansH = -1;
		for (int f = min; f <= max; f++) {
			int time = 0;
			int block = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int dif = map[i][j] - f;

					if (dif > 0) {
						time += Math.abs(dif) * 2;
						block += Math.abs(dif);
					} else if (dif < 0) {
						time += Math.abs(dif);
						block -= Math.abs(dif);
					}

				}
			}
			if (block < 0)
				continue;
			if (ansS >= time) {
				ansS = time;
				ansH = f;
			}
		}

		System.out.println(ansS + " " + ansH);
	}
}
