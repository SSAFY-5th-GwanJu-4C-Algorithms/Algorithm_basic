import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Acmicpc_2606_바이러스{
	static final int start = 1;
	static int answer = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int computerCnt = Integer.valueOf(br.readLine());
		int computerPair = Integer.valueOf(br.readLine());
		list = new ArrayList[computerCnt+1];
		visited = new boolean[computerCnt+1];
		
		for(int i=1; i<computerCnt+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<computerPair; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		DFS(start);
		answer--;
		
		System.out.println(answer);
	}

	private static void DFS(int current) {
		visited[current] = true;
		answer++;
		
		for(int next : list[current]) {
			if(!visited[next]) {
				DFS(next);
			}
		}
	}

}
