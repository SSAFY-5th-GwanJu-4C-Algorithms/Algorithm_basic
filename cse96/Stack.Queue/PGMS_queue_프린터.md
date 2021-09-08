```JAVA
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<Document>();
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        
        int len  = priorities.length;
        for(int i = 0; i < len; i++){
            queue.add(new Document(priorities[i],i));
            hashMap.put(priorities[i],hashMap.getOrDefault(priorities[i],0) + 1);
        }
        
        int important = 9;
        ArrayList<Document> printSeq = new ArrayList<Document>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                if(hashMap.get(important) == null) break;
                else{
                    Document doc = queue.poll();
                    if(doc.priority == important){
                        printSeq.add(doc);
                        hashMap.put(important,hashMap.get(important)-1);
                        if(hashMap.get(important) == 0) break;
                    }
                    else{
                        queue.add(doc);
                    }
                    
                }
            }
            important--;
            if(important == 0) break;
        }
        len = printSeq.size();
        int answer = 0;
        for(int i = 0; i < len; i++){
            if(printSeq.get(i).loc == location) answer = i + 1;
            if(answer != 0) break;
        }
        
        return answer;
    }
    private static class Document{
        int priority;
        int loc;
        Document(int priority, int loc){
            this.priority = priority;
            this.loc = loc;
        }
    }
}
```
