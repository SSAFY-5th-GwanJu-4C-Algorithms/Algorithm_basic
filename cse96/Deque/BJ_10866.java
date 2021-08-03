package study.August;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class BJ_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String str[];
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			String command = str[0];
			int num = 0;
			if(str.length > 1) {
				num = Integer.valueOf(str[1]);
			}
			if(command.equals("push_front")) {
				l.addFirst(num);
			}
			else if(command.equals("push_back")) {
				l.addLast(num);
			}
			else if(command.equals("pop_front")) {
				if(l.isEmpty()) System.out.println(-1);
				else System.out.println(l.pollFirst());
			}
			else if(command.equals("pop_back")) {
				if(l.isEmpty()) System.out.println(-1);
				else System.out.println(l.pollLast());
			}
			else if(command.equals("size")) {
				System.out.println(l.size());
			}
			else if(command.equals("empty")) {
				if(l.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(command.equals("front")) {
				if(l.isEmpty()) System.out.println(-1);
				else System.out.println(l.peekFirst());
			}
			else if(command.equals("back")) {
				if(l.isEmpty()) System.out.println(-1);
				else System.out.println(l.peekLast());
			}
		}
	}

}
