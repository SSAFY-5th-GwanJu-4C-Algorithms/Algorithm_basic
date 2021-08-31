기존 배열에서 새로운 배열을 추출해내어 정렬하는 문제이다.

ide없이 프로그래머스에서만 작성했는데 생각보다 ide에 많이 의존하고 있구나를 깨닫고 반성하게 된다..

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i < commands.length; i++){
            
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int idx = commands[i][2]-1;
            
            int[] newArray = new int[end-start+1];
            for(int j=start; j <= end; j++){
                newArray[j-start] = array[j];
            }
            System.out.println();
            
            Arrays.sort(newArray);
            
            answer[i] = newArray[idx];
        }
        
        return answer;
    }
}
```

---

### 참고 코드

```java
int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
```
