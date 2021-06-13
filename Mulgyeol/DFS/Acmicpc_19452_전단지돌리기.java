import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Acmicpc_19452_전단지돌리기 {

	static int N, S, D;
	static boolean[] visited;
	static int[] parent;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> leafNode;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken()); //노드 갯수
		S = Integer.valueOf(st.nextToken()); //케니소프트의 위치
		D = Integer.valueOf(st.nextToken()); //힘(현재 현민이의 위치에서 전단지를 던져질 수 있는 노드 만큼의 거리)
		
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			
			list[A].add(B);
			list[B].add(A);
		}
		
		leafNode = new ArrayList<>();
		findLeafNode(S);
		
		Arrays.fill(visited, false);
		
		for(int leaf : leafNode) {
			findPositionDFS(leaf, 0);
		}
		
		System.out.println(answer*2);
		
		
	}

	private static void findPositionDFS(int current, int distance) {
		if(current == S) {
			if(distance > D) {
				answer += distance - D;
				return;
			}else {
				return;
			}
		}
		
		if(visited[current]) {
			if(distance > D) {
				answer += distance - D;
				return;
			}else {
				return;
			}
		}
		
		if(distance >= D) {
			//힘보다 거리가 멀어야 방문을 하기 때문에 설정해준다.
			visited[current] = true;
		}
		findPositionDFS(parent[current], distance+1);

	}

	private static void findLeafNode(int current) {
		visited[current] = true;
		int cnt = 0;
		
		for(int next : list[current]) {
			if(!visited[next]) {
				parent[next] = current;
				findLeafNode(next);
				cnt++;
			}
		}
		
		if(cnt == 0) {
			leafNode.add(current);
		}
		
	}

}
