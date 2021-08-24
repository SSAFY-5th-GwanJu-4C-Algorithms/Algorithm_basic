package study.August.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2812_크게만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);//N자리수
		int K = Integer.valueOf(str[1]);//지울 수
		
		String num = br.readLine();
		//입력 끝
		int cnt = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			//현재 수
			int now = num.charAt(i) - '0';
			//더 지울 수 있고 stack의 top보다 지금 숫자가 더 크다면 지움
			while(cnt < K && !stack.isEmpty() && stack.peek() < now) {
				stack.pop();
				cnt++;
			}
			stack.add(now);
		}
		int size = stack.size();
		if(size > N - K) {
			for(int i = 0; i < size - (N - K); i++) {
				stack.pop();
			}
		}
//		System.out.println(stack.toString());
		size = stack.size();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse().toString());
		
	}

}
