package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		ArrayList<Integer> queue = new ArrayList<Integer>();
		String str[] = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			queue.add(Integer.valueOf(str[i]));
		}
		Collections.sort(queue);
		//ÀÔ·Â ³¡
		int waiting_time = 0;
		int total_time = 0;
		for(int i = 0; i < N; i++) {
			waiting_time += queue.get(i);
			total_time += waiting_time;
		}
		System.out.println(total_time);
		
	}

}
