package study.June;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
	static ArrayList<ArrayList<Integer>> computer;
	static boolean visit[];
	static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());//컴퓨터 수
		int pair = Integer.valueOf(br.readLine());//연결된 쌍의 수
		computer = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < N; i++) {
			computer.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.valueOf(st.nextToken());
			int to = Integer.valueOf(st.nextToken());
			computer.get(from-1).add(to-1);
			computer.get(to-1).add(from-1);
		}
		visit = new boolean[N];
		dfs(0);
		System.out.println(count-1);
	}
	private static void dfs(int start) {
		if(visit[start]) return;
		visit[start] = true;
		count++;
		for(int a : computer.get(start)) {
			dfs(a);
		}
	}

}
