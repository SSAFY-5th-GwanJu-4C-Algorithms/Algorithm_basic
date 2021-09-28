```
0. 상어 (0,0)먹기
1. 물고기 이동
1-1. 번호가 작은 순서대로 && 살아있는 물고기
1-2. 한칸이동
1-2-1. 경계를 넘거나 상어있으면 이동불가, 빈칸이거나 다른 물고기 있으면 이동가능
1-2-2. 이동할 수 있을때까지 45도 반시계 방향 회전
1-2-3. 이동할 자리 없으면 원래 자리
1-2-4. 빈칸이면 그냥 이동, 물고기 있으면 자리 change
2. 상어 이동
2-1. 한 번에 여러칸 이동 가능 (dfs)
2-1. 물고기 없는 칸은 이동 불가능
3. 1,2 반복하다가 상어 이동할 곳이 없으면, 최대값 비교하고 return
```

<br>

[2021.09.24]

아니... 어디가 논리적으로 안맞는거지...?

[해당 블로그](https://bcp0109.tistory.com/entry/%EB%B0%B1%EC%A4%80-19236%EB%B2%88-%EC%B2%AD%EC%86%8C%EB%85%84-%EC%83%81%EC%96%B4-Java)를 보면 나와 거의 똑같은 형식으로 작성한 것을 볼 수 있다.

아마 물고기 list나 board를 처리할 때 잘못한 것 같다..!


<br>

[2021.09.25]

진짜 아무리 생각해도 모르겠다.. 똑같이 했는데 이번엔 왜 스택오버플로우 나냐..?

<br>

### usecase 1 : 예제 틀림

```java
public class Main {

	static class Fish {
		int idx, dir, r, c;
		boolean live = true;
		
		public Fish(int idx, int dir, int r, int c) {
			this.idx = idx;
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
	}
	static class Shark {
		int dir, r, c, eat;
		public Shark(int dir, int r, int c, int eat) {
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.eat = eat;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max;
	static int[] dr = {0,-1,-1,0,1,1,1,0,-1}; //0,↑, ↖, ←, ↙, ↓, ↘, →, ↗
	static int[] dc = {0,0,-1,-1,-1,0,1,1,1}; //0,↑, ↖, ←, ↙, ↓, ↘, →, ↗
	
	public static void main(String[] args) throws IOException {
		
		Fish[] list = new Fish[17]; 
		int[][] board = new int[4][4];
		Shark shark = new Shark(0, 0, 0, 0);
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				list[idx] = new Fish(idx, dir, i, j);
				board[i][j] = idx;
			}
		}
		
		// 0,0 물고기 먹기
		int idx = board[0][0];
		shark.dir = list[idx].dir;
		shark.eat += idx;
		list[idx].live = false;
		board[0][0] = 0;
		
		dfs(shark, list, board);
		
		System.out.println(max);
	}

	private static void dfs(Shark shark, Fish[] list, int[][] board) {
		
		// 1. 물고기 이동
		moveFish(shark, list, board);
		
		System.out.println();
		
		// 2. 상어 이동
		boolean flag = moveShark(shark, list, board);
		
		System.out.println();

		// 3. 종료
		if(!flag) {
			max = Math.max(max, shark.eat);
			return;
		}
	}

	private static void makeNew(Fish[] newList, int[][] newBoard, Fish[] list, int[][] board) {
		
		for (int i = 1; i <= 16; i++) {
			Fish f = list[i];
			newList[i] = new Fish(f.idx, f.dir, f.r, f.c);
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
	}

	private static boolean moveShark(Shark shark, Fish[] list, int[][] board) {
		
		boolean flag = false;
		
		// 갈 수 있는 곳까지
		for (int cnt = 1; cnt <= 3; cnt++) {
			
			int nr = shark.r + dr[shark.dir]*cnt;
			int nc = shark.c + dc[shark.dir]*cnt;
			
			// 경계
			if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) break;
			// 물고기 없음
			if(board[nr][nc] == 0) continue;
			
			flag = true;
			
			Shark newShark = new Shark(shark.dir, 0, 0, shark.eat);
			Fish[] newList = new Fish[17];
			int[][] newBoard = new int[4][4];
			makeNew(newList, newBoard, list, board);
			
			//물고기 먹기
			int idx = board[nr][nc];
			newShark.r = nr;
			newShark.c = nc;
			newShark.dir = newList[idx].dir;
			newShark.eat += idx;
			newList[idx].live = false;
			newBoard[nr][nc] = 0;
			
			dfs(newShark, newList, newBoard);
		}
		
		return flag;
		
	}

	private static void moveFish(Shark shark, Fish[] list, int[][] board) {
		
		for (int idx = 1; idx <= 16; idx++) {
			// 살아있는 물고기만
			if(!list[idx].live) continue;
			
			// 반시계
			for (int i = 0; i < 8; i++) {
				
				Fish f = list[idx];
				
				int nr = f.r + dr[f.dir];
				int nc = f.c + dc[f.dir];
				
				// 경계
				if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) {
					f.dir++;
					if(f.dir == 9) f.dir = 1;
					continue;
				}
				// 상어
				if(nr == shark.r && nc == shark.c) {
					f.dir++; 
					if(f.dir == 9) f.dir = 1;
					continue;
				}
				// 빈칸
				if(board[nr][nc] == 0) {
					board[nr][nc] = f.idx; board[f.r][f.c] = 0;
					f.r = nr; f.c = nc;
				}
				// 다른 상어
				else {
					Fish o = list[board[nr][nc]];
					board[o.r][o.c] = f.idx; board[f.r][f.c] = o.idx;
					int tmpR = f.r; int tmpC = f.c;
					f.r = o.r; f.c = o.c;
					o.r = tmpR; o.c = tmpC;
				}
				break;
			}
			
		}
		
	}
}

```

<br>

### usecase 2 : 스택오버플로우

```java
public class Main {

	static class Fish {
		int idx, dir, r, c;
		boolean live = true;
		
		public Fish(int idx, int dir, int r, int c) {
			this.idx = idx;
			this.dir = dir;
			this.r = r;
			this.c = c;
		}
	}
	static class Shark {
		int dir, r, c, eat;
		public Shark(int dir, int r, int c, int eat) {
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.eat = eat;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max;
	static int[] dr = {-1,-1,0,1,1,1,0,-1}; //↑, ↖, ←, ↙, ↓, ↘, →, ↗
	static int[] dc = {0,-1,-1,-1,0,1,1,1}; //↑, ↖, ←, ↙, ↓, ↘, →, ↗
	
	public static void main(String[] args) throws IOException {
		
		Fish[] list = new Fish[17]; 
		int[][] board = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				
				list[idx] = new Fish(idx, dir, i, j);
				board[i][j] = idx;
			}
		}
		
		// 0,0 물고기 먹기
		Fish f = list[board[0][0]];
		Shark shark = new Shark(f.dir, 0, 0, f.idx);
		f.live = false;
		board[0][0] = -1;
		
		dfs(shark, list, board);
		
		System.out.println(max);
	}

	private static void dfs(Shark shark, Fish[] list, int[][] board) {
		
		// 0. 상어 먹은 양 비교
		max = Math.max(max, shark.eat);
		
		// 1. 물고기 이동
		moveFish(shark, list, board);
		
		// 2. 상어 이동
		// 갈 수 있는 곳까지
		for (int cnt = 1; cnt <= 3; cnt++) {
			
			int nr = shark.r + dr[shark.dir]*cnt;
			int nc = shark.c + dc[shark.dir]*cnt;
			
			// 경계
			if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
			// 물고기 없음
			if(board[nr][nc] < 1) continue;
			
			Fish[] newList = copyList(list);
			int[][] newBoard = copyBoard(board);
			
			//물고기 먹기
			newBoard[shark.r][shark.c] = 0;
			int idx = board[nr][nc];
			Fish f = newList[idx];
			Shark newShark = new Shark(f.dir, f.r, f.c, shark.eat + idx);
			newList[idx].live = false;
			newBoard[nr][nc] = -1;
			
			dfs(newShark, newList, newBoard);
		}
	}

	private static int[][] copyBoard(int[][] board) {
		int[][] newBoard = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}

	private static Fish[] copyList(Fish[] list) {
		Fish[] newList = new Fish[17];
		
		for (int i = 1; i <= 16; i++) {
			Fish f = list[i];
			newList[i] = new Fish(f.idx, f.dir, f.r, f.c);
		}
		return newList;
	}

	private static void moveFish(Shark shark, Fish[] list, int[][] board) {
		
		for (int idx = 1; idx <= 16; idx++) {
			// 살아있는 물고기만
			if(list[idx].live == false) continue;
			
			Fish f = list[idx];
			
			// 반시계
			for (int i = 0; i < 8; i++) {
				
				int nextDir = (f.dir+i) % 8;
				int nr = f.r + dr[nextDir];
				int nc = f.c + dc[nextDir];
				
				// 경계
				if(nr < 0 || nc < 0 || nr >= 4 || nc >= 4) continue;
				// 상어
				if(board[nr][nc] == -1) continue;
				// 빈칸
				if(board[nr][nc] == 0) {
					board[f.r][f.c] = 0;
					f.r = nr; f.c = nc;
				}
				// 다른 상어
				else {
					Fish o = list[board[nr][nc]];
					o.r = f.r;
					o.c = f.c;
					board[f.r][f.c] = o.idx;
					
					f.r = o.r;
					f.c = o.c;
					
//					board[f.r][f.c] = o.idx;
//					int tmpR = f.r; int tmpC = f.c;
//					f.r = o.r; f.c = o.c;
//					o.r = tmpR; o.c = tmpC;
				}
				
				board[nr][nc] = f.idx;
				f.dir = nextDir;
				break;
			}
			
		}
		
	}
}
```
