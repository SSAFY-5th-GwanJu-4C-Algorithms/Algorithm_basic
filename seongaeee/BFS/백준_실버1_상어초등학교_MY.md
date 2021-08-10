## 문제

![image](https://user-images.githubusercontent.com/62600984/128634985-b84ab25d-570b-4bb6-b890-c4491504f1a2.png)
![image](https://user-images.githubusercontent.com/62600984/128635020-7f89c84e-8c47-486a-834f-675ebe4af963.png)


[문제보기](https://www.acmicpc.net/problem/21608)

<br>

## 문제 풀이

이게 실버1이라구...?

오래간만에 BFS 문제 풀어서 그런지 너무 어려웠다..

풀고 나서 다른 블로그 보니까 다양한 방법으로 더 효율적이게 짠 코드들이 많아서 참고해서 다시 풀어야겠다고 생각했다!

<br>

로직은 문제 그대로이다.


<img src="https://user-images.githubusercontent.com/62600984/128635216-dc91dba1-a509-48b3-a806-df90f0cb8fc1.png" width=700>

<br>

헷갈렸던 부분은 `만족도 점수`를 구할 때가 **모두 자리를 정한 후**이다.

왜냐하면 나중에 앉은 좋아하는 학생들이 초반에 자리를 결정했던 학생들의 좋아하는 학생일 수 있기 때문이다.

사실 문제에도 다 나와있었다.. 문제를 잘 읽자!

<br>

## 전체 코드

```java
public class Main {

	static class Position implements Comparable<Position>{
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Position o) {
			if(r == o.r) {
				return Integer.compare(c, o.c);
			}
			else return Integer.compare(r, o.r);
		}
	}
	static int N, board[][], student, studentLikeMember[], likeMember[][], ans;
	static int dr[] = {0,0,-1,1}; //좌우상하
	static int dc[] = {-1,1,0,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		studentLikeMember = new int[4];
		likeMember = new int[N*N+1][4];
		
		for (int i = 0; i < N*N; i++) {
			st = new StringTokenizer(br.readLine());
			
			student = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				studentLikeMember[j] = Integer.parseInt(st.nextToken());
				likeMember[student][j] = studentLikeMember[j];
			}
			
			// 1단계
			ArrayList<Position> positionList = firstStep();
			
			if(positionList.size() == 1) {
				Position p = positionList.get(0);
				board[p.r][p.c] = student;
				continue;
			} 
			
			// 2단계
			positionList = secondStep(positionList);
			
			if(positionList.size() == 1) {
				Position p = positionList.get(0);
				board[p.r][p.c] = student;
				continue;
			}
			
			// 3단계
			Collections.sort(positionList);
			Position p = positionList.get(0);
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
				if(likeCnt == 1) {
					ans += 1;
				} else if (likeCnt == 2) {
					ans += 10;
				} else if (likeCnt == 3) {
					ans += 100;
				} else if (likeCnt == 4) {
					ans += 1000;
				}
			}
		}
	}

	private static ArrayList<Position> secondStep(ArrayList<Position> positionList) {
		
		int maxNullCnt = 0;
		ArrayList<Position> newPositionList = new ArrayList<>();
		
		for (int idx = 0; idx < positionList.size(); idx++) {
			
			Position p = positionList.get(idx);
			int i = p.r;
			int j = p.c;
			
			// 1. 인접한 칸 중 비어있는 칸의 개수
			int nullCnt = 0;
			for (int dir = 0; dir < 4; dir++) {
				int r = i + dr[dir];
				int c = j + dc[dir];
				
				if( r < 0 || c < 0 || r >= N || c >= N ) continue;
				if(board[r][c] == 0) {
					nullCnt++;
				}
			}
			
			// 2. 비교
			if( nullCnt == maxNullCnt ) {
				newPositionList.add(new Position(i, j));
			} else if ( nullCnt > maxNullCnt ) {
				maxNullCnt = nullCnt;
				newPositionList.clear();
				newPositionList.add(new Position(i, j));
			}
			
		}
		
		return newPositionList;
		
	}

	private static ArrayList<Position> firstStep() {
		
		int maxLikeCnt = 0;
		ArrayList<Position> positionList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// 1. 비어있는 칸
				if(board[i][j]==0) {
					
					// 2. 좋아하는 학생이 인접한 칸의 개수
					int likeCnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int r = i + dr[dir];
						int c = j + dc[dir];
						
						if( r < 0 || c < 0 || r >= N || c >= N ) continue;
						for (int k = 0; k < 4; k++) {
							if(board[r][c] == studentLikeMember[k]) {
								likeCnt++;
								break;
							}
						}
					}
					
					// 3. 비교
					if( likeCnt == maxLikeCnt ) {
						positionList.add(new Position(i, j));
					} else if ( likeCnt > maxLikeCnt ) {
						maxLikeCnt = likeCnt;
						positionList.clear();
						positionList.add(new Position(i, j));
					}
				}
			}
		}
		
		return positionList;
	}
}
```

<br>

## 다시 풀어보기

- [[BOJ] 백준 21608 상어 초등학교](https://zoosso.tistory.com/922)
- [[백준 21608] 상어 초등학교 with JAVA](https://waristo.tistory.com/43)
- ⭐ [[C++ 알고리즘] 백준 21608번 : 상어 초등학교](https://4z7l.github.io/2021/04/29/algorithms-boj-21608.html)
- ⭐ [https://hillier.tistory.com/76](https://hillier.tistory.com/76)
- 🙊 [백준 21608 - 상어 초등학교](https://taxol1203.github.io/codingtest/bj-%EC%83%81%EC%96%B4-%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90/)
