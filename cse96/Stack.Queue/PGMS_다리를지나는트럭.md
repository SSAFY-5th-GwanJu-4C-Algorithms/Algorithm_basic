```JAVA
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //트럭 도착시간 큐
        Queue<Integer> q = new LinkedList<Integer>();
        int cur_weight = 0;
        int time = 0;
        //선두 트럭(가장 먼저 도착할 트럭)
        int idx = 0;
        for(int i = 0; i < truck_weights.length; i++){
            time++;
            
            //적재 가능해질때까지 다리 무게를 줄임(트럭도착할때까지 대기)
            while(cur_weight + truck_weights[i] > weight){
                time = q.poll();
                cur_weight -= truck_weights[idx++];
            }
    
            //다리에 올라갈 수 있는 상태
            q.add(time + bridge_length);
            cur_weight += truck_weights[i];
        }
        while(!q.isEmpty()) time = q.poll();
        answer = time;
        return answer;
    }
}
현재까지 풀던 코드
```

![image](https://user-images.githubusercontent.com/78025547/133114616-b2097506-635b-4494-85ea-c1c1f3518a24.png)
도착시간을 큐에 넣고 다리 제한 무게를 넘어가면 선두의 트럭을 도착시키고 큐에서 그시간을 가져오는 방식으로 접근했는데 틀림 더해결해볼 예정
