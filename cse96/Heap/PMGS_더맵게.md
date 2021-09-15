```JAVA
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> s_score = new PriorityQueue<Integer>();
        for(int scovil : scoville){
            s_score.add(scovil);
        }
        int mix = 0;
        while(s_score.peek() < K){
            if(s_score.size() < 2) return -1;
            int min = s_score.poll();
            int next_min = s_score.poll();
            s_score.add(min + 2 * next_min);
            mix++;
        }
        
        int answer = mix;
        return answer;
    }
}
```
