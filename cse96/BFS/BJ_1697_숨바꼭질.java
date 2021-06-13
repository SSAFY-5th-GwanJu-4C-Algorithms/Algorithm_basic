package study.June;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질 {
	static int K, time = Integer.MAX_VALUE,count = 0;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());//수빈이가 있는 위치
		K = Integer.valueOf(st.nextToken());//동생이 있는 위치
		visit = new boolean[100001];
		Queue<Turn> q = new LinkedList<Turn>();
		q.add(new Turn(0,N));
		while(!q.isEmpty()) {
			Turn t = q.poll();
			int cur = t.cnt;
			int number = t.num;
			visit[number] = true;
			if(number == K) {
				time = cur;
			}
			if(number + 1 <= 100000 && !visit[number+1]) {
				q.add(new Turn(cur+1,number+1));
				visit[number+1] = true;
			}
			if(number - 1 >= 0 && !visit[number-1]) {
				q.add(new Turn(cur+1,number-1));
				visit[number-1] = true;
			}
			if(number * 2 < 100001 && !visit[number*2]) {
				q.add(new Turn(cur+1,number*2));
				visit[number*2] = true;
			}
		}
		System.out.println(time);
	}
	static class Turn{
		int cnt;
		int num;
		public Turn(int cnt, int num) {
			super();
			this.cnt = cnt;
			this.num = num;
		}
	}
}
