package study.August.Hash;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_15686_치킨배달 {

	static int M, store_cnt, minDist = Integer.MAX_VALUE;
	static ArrayList<Point> house;
	static ArrayList<Point> store;
	static Stack<Point> selectStore;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		//N 2~50 M 1~13
		int N = Integer.valueOf(str[0]); //map의 크기
		M = Integer.valueOf(str[1]); // M 치킨집 최대 수
		house = new ArrayList<Point>();
		store = new ArrayList<Point>();
		selectStore = new Stack<Point>();
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int cur = Integer.valueOf(str[j]);
				if(cur == 1) {
					//집
					Point now = new Point(i+1,j+1);
					house.add(now);
				}
				else if(cur == 2) {
					//치킨 집
					Point now = new Point(i+1,j+1);
					store.add(now);
				}
			}		
		}//for-i
		store_cnt = store.size();
		select(0,0);
		
		System.out.println(minDist);
	}

	private static void select(int start, int count) {
		if(count == M) {
			calcDist();
			return;
		}
		
		for(int i = start; i < store_cnt; i++) {
			//stack을 활용해서 조합을 하면 visit처리가 필요없다.
			selectStore.push(store.get(i));
			select(i+1,count+1);
			selectStore.pop();
		}
	}

	private static void calcDist() {
		int sum = 0;
		for(Point home : house) {
			int min = Integer.MAX_VALUE;
			for(Point store : selectStore) {
				int dist = Math.abs(home.x - store.x) + Math.abs(home.y - store.y);
				min = Math.min(min, dist);
			}
			sum += min;
			
			if(sum > minDist) return;//백트래킹
			
		}
		//백트래킹에 안걸리면 sum이 최소값
		minDist = sum;
	}

}
