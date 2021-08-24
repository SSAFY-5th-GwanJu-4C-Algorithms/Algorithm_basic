## 문제

[코딩테스트 연습 - 기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586?language=java)

<br>

## 첫번째 방법

약간 더럽게 풀고... stack이나 queue를 이용하지 않은... 풀이 방법이다.

```sql
- day에 따라 바로 100이상일시,
		- 배포 가능 횟수 늘려줌

- day에 따라 100이하일시,
		- 지금까지 배포 가능 횟수 추가
		- 배포 가능 횟수 0으로 초기화.
		- 100이상이 될때까지 day늘리기
```

```sql
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		int day = 0;
		int deployCnt = 0;
		
		for (int i = 0; i < progresses.length; i++) {
			
			if(progresses[i] + day * speeds[i] < 100) {
				list.add(deployCnt);
				deployCnt = 0;
				while(progresses[i] + day * speeds[i] < 100) {
					day++;
				}
			}
			deployCnt++;
		}
		
		list.add(deployCnt);
		
		int[] answer = new int[list.size()-1];
		for (int i = 1; i < list.size(); i++) {
			answer[i-1] = list.get(i);
		}
        
        return answer;
    }
}
```

<br>

### 두번째 방법

두번째 방법은 Queue를 이용하고자 하였다.

```sql
100 - progresses / speeds 올림 -> queue에 넣기
하나씩 꺼낼때 이전꺼보다 작으면, deployCnt++
하나씩 꺼낼때 이전꺼보다 크면, deployCnt를 list에 추가, deplopyCnt = 0.
```

아래와 같이 코드를 짰더니 일부가 틀리는 현상이 발생했다!

```sql
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Double> queue = new LinkedList<Double>();
		
		for (int i = 0; i < progresses.length; i++) {
			queue.add(Math.ceil((100 - progresses[i])/speeds[i]));
		}
		
		int deployCnt = 1;
		double beforeDay = queue.poll();
		
		while(!queue.isEmpty()) {
			
			double curDay = queue.poll();
			
			if (curDay < beforeDay) {
				deployCnt++;
			} else {
				list.add(deployCnt);
				deployCnt = 1;
				beforeDay = curDay;
			}
		}
		
		list.add(deployCnt);
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
```

<br>

두가지 문제점이 있었다.

- `curDay`가 `beforeDay`보다 같거나 작을때, `deployCnt`를 늘려주는 것.
- `Math.ceil((100 - progresses[i])/speeds[i])`에서 `(100 - progresses[i])/speeds[i]`가 이미 정수이기때문에 `Math.ceil`이 소용이 없다는 것이다.

```sql
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<Double> queue = new LinkedList<Double>();
		
		for (int i = 0; i < progresses.length; i++) {
			queue.add(Math.ceil((double)(100 - progresses[i])/speeds[i]));
		}
		
		int deployCnt = 0;
        double beforeDay = 0;
		if(!queue.isEmpty()) {
            deployCnt = 1;
            beforeDay = queue.poll();
        }
		
		while(!queue.isEmpty()) {
			
			double curDay = queue.poll();
			
			if (curDay <= beforeDay) {
				deployCnt++;
			} else {
				list.add(deployCnt);
				deployCnt = 1;
				beforeDay = curDay;
			}
		}
		
		if(deployCnt != 0) list.add(deployCnt);
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
```

<br>

## 참고 코드

```java
for (int i = 0; i < speeds.length; i++) {
    double remain = (100 - progresses[i]) / (double) speeds[i];
    int date = (int) Math.ceil(remain);

    if (!q.isEmpty() && q.peek() < date) {
        answerList.add(q.size());
        q.clear();
    }

    q.offer(date);
}
```
