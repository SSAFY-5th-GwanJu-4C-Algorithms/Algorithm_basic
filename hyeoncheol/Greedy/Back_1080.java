package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1080 {

	static int ori[][];
	static int cha[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ori = new int[N][M];
		cha = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp=br.readLine();
			for (int j = 0; j < M; j++) {
				ori[i][j] = tmp.charAt(j)-'0';
			}
		}
		for (int i = 0; i < N; i++) {
			String tmp=br.readLine();
			for (int j = 0; j < M; j++) {
				cha[i][j] = tmp.charAt(j)-'0';
			}
		}

		int ans = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (ori[i][j] != cha[i][j]) {
					ans++;
					change(i, j);
				}
			}
		}
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ori[i][j] != cha[i][j]) {
					System.out.println(-1);
					flag = true;
					break;
				}
			}
			if (flag == true)
				break;
		}
		if (flag == false) {
			System.out.println(ans);
		}
	}

	private static void change(int x, int y) {
		for (int i = x; i <= x + 2; i++) {
			for (int j = y; j <= y + 2; j++) {
				ori[i][j] = 1 - ori[i][j];
			}
		}
	}
}
