```JAVA
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 0;
        boolean flag = false;
        Queue<Integer> q = new LinkedList<Integer>();
        while(true){
            for(int i = count; i < progresses.length; i++){
            	if(progresses[i] < 100)
            		progresses[i] += speeds[i];
            }//하루 개발 진행
            int complete_task = 0;
            //100퍼가 된 것 존재하면
            for(int i = count; i < progresses.length; i++){
                if(progresses[i] >= 100) {
                    complete_task++;
                }
                else {
                	break;
                }
            }
            if(complete_task > 0) {
            	q.add(complete_task);
                count += complete_task;
                if(count == progresses.length) flag = true;
            }
            if(flag) break;
        }
        int len = q.size();
        
        int[] answer = new int[len];
        for(int i = 0; i< len; i++){
            answer[i] = q.poll();
        }
        return answer;
    }
}
```
