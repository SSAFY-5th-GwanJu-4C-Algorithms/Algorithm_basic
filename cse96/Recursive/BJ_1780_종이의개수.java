package study.August.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1780_종이의개수 {
	static int N;
	static int paper[][];
	static int kind[] = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.valueOf(str[j]);
			}
		}//입력 끝
		check(0,0,N);
		for(int i = 0; i < 3; i++) System.out.println(kind[i]);
			
	}
	private static void check(int x, int y,int size) {
		int cur = paper[x][y];
		boolean flag = false;
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(paper[i][j] != cur) {
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		if(flag) {
			int next_size = size/3;
			for(int i = x; i < x + size; i += next_size) {
				for(int j = y; j < y + size; j += next_size) {
					check(i,j,next_size);
				}
			}
		}
		else {
			if(cur == -1) kind[0]++;
			else if(cur == 0) kind[1]++;
			else kind[2]++;
		}
	}

}
