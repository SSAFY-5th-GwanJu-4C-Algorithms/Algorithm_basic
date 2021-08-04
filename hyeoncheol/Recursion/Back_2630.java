package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2630 {
	static int[][] arr;
	static int ans1;
	static int ans2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int tmp = arr[0][0];
		boolean flag=false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]!=tmp) {
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
		if(flag==false&&tmp==1){
			System.out.println(0);
			System.out.println(1);
			System.exit(0);
		}else if(flag==false&&tmp==0) {
			System.out.println(1);
			System.out.println(0);
			System.exit(0);
		}
		
		search(0, 0, N, N);
		System.out.println(ans1);
		System.out.println(ans2);
	}

	private static void search(int x, int y, int xx, int yy) {
		int tmp = 0;
		boolean flag = false;
		tmp = arr[x][y];
		for (int i = x; i < (xx+x) / 2; i++) {
			for (int j = y; j < (yy+y)/2; j++) {
				if(arr[i][j]!=tmp) {
					search(x,y,(xx+x)/2,(yy+y)/2);
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
		if(flag==false&&tmp==0) {
			ans1++;
		}else if(flag==false&&tmp==1) {
			ans2++;
		}
		
		flag=false;
		tmp = arr[(xx+x)/2][y];
		for (int i = (xx+x)/2; i < xx ; i++) {
			for (int j = y; j < (yy+y) / 2; j++) {
				if(arr[i][j]!=tmp) {
					search((xx+x)/2,y,xx,(y+yy)/2);
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
		if(flag==false&&tmp==0) {
			ans1++;
		}else if(flag==false&&tmp==1) {
			ans2++;
		}
		
		flag=false;
		tmp = arr[x][(y+yy)/2];
		for (int i = x; i < (xx+x)/2; i++) {
			for (int j = (y+yy)/2; j < yy ; j++) {
				if(arr[i][j]!=tmp) {
					search(x,(y+yy)/2,(xx+x)/2,yy);
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
		if(flag==false&&tmp==0) {
			ans1++;
		}else if(flag==false&&tmp==1) {
			ans2++;
		}
		
		flag=false;
		tmp = arr[(xx+x)/2][(y+yy)/2];
		for (int i = (x+xx)/2; i < xx ; i++) {
			for (int j = (y+yy)/2; j < yy ; j++) {
				if(arr[i][j]!=tmp) {
					search((xx+x)/2,(y+yy)/2,xx,yy);
					flag=true;
					break;
				}
			}
			if(flag==true)break;
		}
		if(flag==false&&tmp==0) {
			ans1++;
		}else if(flag==false&&tmp==1) {
			ans2++;
		}
		
	}
}
