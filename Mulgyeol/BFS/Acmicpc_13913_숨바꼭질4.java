package BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Acmicpc_13913_숨바꼭질4 {
	
	static int time;
	static int[] before;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int cur = Integer.valueOf(st.nextToken());
		int to = Integer.valueOf(st.nextToken());
		
		bfs(cur,to);
		Stack<Integer> stack = new Stack<>();
		while(cur != to) {
			stack.push(to);
			to = before[to];
		}
		
		sb.append(cur).append(" ");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(time);
		System.out.print(sb);
	}

	private static void bfs(int cur, int to) {
		boolean[] visited = new boolean[100001];
		before = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(cur);
		visited[cur] = true;
		time = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int current = queue.poll();
				if(current == to) {
					return;
				}
				
				int next1 = current*2;
				int next2 = current-1;
				int next3 = current+1;
				
				if(next1 <= 100000 && to > (next1+current)/2 && !visited[next1]) {
					before[next1] = current;
					visited[next1] = true;
					queue.offer(next1);
				}
				
				if(next2 >= 0 && !visited[next2]) {
					before[next2] = current;
					visited[next2] = true;
					queue.offer(next2);
				}
				
				if(next3 <= 100000 && !visited[next3]) {
					before[next3] = current;
					visited[next3] = true;
					queue.offer(next3);
				}
			}
			
			time++;
		}
		
		
	}

}
