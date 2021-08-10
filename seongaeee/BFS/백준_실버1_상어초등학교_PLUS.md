## 문제

![image](https://user-images.githubusercontent.com/62600984/128634985-b84ab25d-570b-4bb6-b890-c4491504f1a2.png)
![image](https://user-images.githubusercontent.com/62600984/128635020-7f89c84e-8c47-486a-834f-675ebe4af963.png)


[문제보기](https://www.acmicpc.net/problem/21608)

<br>

## 문제 풀이

다른 사람의 코드를 분석하면서 정말 쉬운 문제였구나 깨달았다.

기억해야할 `KeyPoint`는 다음과 같다.

```
1. 조건을 동시에 비교하기
2. 비교할때 쓰는 방법
  - 우선순위 큐
  - 직접 비교
```

`조건을 동시에 비교`한다는 말은 무엇이냐.
내가 풀었을 때는, 1번조건(좋아하는학생수)을 통과한 자리를 리스트에 저장을하여 2번조건(비어있는칸수)으로 넘겨주었다.
하지만, 1번 조건 & 2번 조건 동시에 구해주어 비교하는 것이다. 1번조건이 같으면 2번조건으로 비교하는 식이다.
이때, 비교하는 방법은 우선순위 큐를 이용하여 자동으로 정렬하거나 직접 비교할 수 있다.

<br>

## 전체 코드

```java
public class Main {

	static class Position implements Comparable<Position>{
		int r, c, like, empty;

		public Position(int r, int c, int like, int empty) {
			super();
			this.r = r;
			this.c = c;
			this.like = like;
			this.empty = empty;
		}

		@Override
		public int compareTo(Position p) {
			if(this.like < p.like) {
				return 1; //like에 대해서 내림차순
			} else if(this.like == p.like) {
				
				if(this.empty < p.empty) {
					return 1; //empty에 대해서 내림차순
				} else if(this.empty == p.empty) {
					
					if(this.r > p.r) {
						return 1; //r에 대해서 오름차순						
					} else if(this.r==p.r) {
						
						if(this.c > p.c) {
							return 1; //c에 대해서 오름차순 
						}
					}
				} 
			}
			
			return -1;
		}
	}
	static int N, board[][], student, likeMember[][], ans;
	static int dr[] = {0,0,-1,1}; //좌우상하
	static int dc[] = {-1,1,0,0};
	static int score[] = {0,1,10,100,1000};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		likeMember = new int[N*N+1][4];
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Position> pq = new PriorityQueue<>();
			
			student = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				likeMember[student][j] = Integer.parseInt(st.nextToken());
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if(board[r][c]!=0) continue;
					
					int likeCnt = 0;
					int emptyCnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						
						if( nr < 0 || nc < 0 || nr >= N || nc >= N ) continue;
						for (int k = 0; k < 4; k++) {
							if(board[nr][nc] == likeMember[student][k]) {
								likeCnt++;
								break;
							}
						}
						if(board[nr][nc] == 0) emptyCnt++;
					}
					
					pq.add(new Position(r, c, likeCnt, emptyCnt));
				}
			}
			Position p = pq.poll();
			board[p.r][p.c] = student;
		}
			
			
		
		// 만족도 구하기
		getAns();
		
		System.out.println(ans);
	}

	private static void getAns() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int likeCnt = 0;
				for (int dir = 0; dir < 4; dir++) {
					int r = i + dr[dir];
					int c = j + dc[dir];
					
					if( r < 0 || c < 0 || r >= N || c >= N ) continue;
					for (int k = 0; k < 4; k++) {
						if(board[r][c] == likeMember[board[i][j]][k]) {
							likeCnt++;
							break;
						}
					}
				}
				ans += score[likeCnt];
			}
		}
	}

}
```
