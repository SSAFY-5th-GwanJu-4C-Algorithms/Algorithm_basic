## 문제

![image](https://user-images.githubusercontent.com/62600984/127007108-d52d2dac-7e62-403f-abee-ea1344b435d1.png)

[문제보기](https://www.acmicpc.net/problem/5430)

<br>

## 문제 풀이

두 개의 함수에 따라 문자열을 조작해야한다.

- R은 배열에 있는 숫자의 순서를 뒤집는 함수
- D는 첫 번째 숫자를 버리는 함수

<br>

### 50%, 시간 초과

1. R 함수

- `stack`을 이용하여 순서 그대로 `push` 후 `pop`을 하면 순서가 거꾸로 된다.

```java
private static void Reverse() {
  Stack<Integer> stack = new Stack<Integer>();

  for (int i = 0; i < N; i++) {
    stack.push(number[i]);
  }

  for (int i = 0; i < N; i++) {
    number[i] = stack.pop();
  }
}
```

2. D 함수

- `-1`이 아닌 첫번째 숫자를 찾으면 `-1`로 바꾼다.
- 배열을 탐색해보았을때 전체가 `-1`이면 `error`이다.

```java
private static boolean DeleteFirst() {
  for (int i = 0; i < N; i++) {
    if(number[i] == -1) continue;
    else{
      number[i] = -1;
      return true;
    }
  }
  return false;
}
```

<br>

## 전체 코드

### 50%, 시간 초과

```java
public class Main {
	
	static String P;
	static char command[];
	static int N, number[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			P = br.readLine();
			command = P.toCharArray();
			
			N = Integer.parseInt(br.readLine());
			number = new int[N];
			
			String tmp = br.readLine();
			tmp = tmp.replace("[", "");
			tmp = tmp.replace("]", "");
			tmp = tmp.replace(",", " ");
			
			st = new StringTokenizer(tmp);
			
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean isError = false;
			
			for (int i = 0; i < command.length; i++) {
				
				if(command[i] == 'R') {
					Reverse();
				}else {
					if(!DeleteFirst()) {
						isError = true;
						break;
					}
				}
			}
			
			if(isError) {
				System.out.println("error");
			}
			else {
				StringBuffer sb = new StringBuffer();
				
				sb.append('[');
				for (int i = 0; i < N; i++) {
					if(number[i]==-1) continue;
					sb.append(number[i]);
					if(i!=N-1) sb.append(',');
				}
				sb.append(']');
				
				System.out.println(sb.toString());
			}
		}
		
	}

	private static boolean DeleteFirst() {
		for (int i = 0; i < N; i++) {
			if(number[i] == -1) continue;
			else{
				number[i] = -1;
				return true;
			}
		}
		return false;
	}

	private static void Reverse() {
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			stack.push(number[i]);
		}
		
		for (int i = 0; i < N; i++) {
			number[i] = stack.pop();
		}
	}
}
```
