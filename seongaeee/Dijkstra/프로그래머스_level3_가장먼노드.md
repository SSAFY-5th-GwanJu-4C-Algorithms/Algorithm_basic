## 문제

![image](https://user-images.githubusercontent.com/62600984/130250496-58d9d236-902e-45ea-91b3-ae3382d2d141.png)

[문제보기](https://programmers.co.kr/learn/courses/30/lessons/49189?language=java)

<br>

## 문제 풀이

`시작 정점에서 다른 정점까지의 최단 거리`를 구하는 문제이다.

즉, `다익스트라`로 풀었다.


<br>

### 다익스트라 구현 종류

```
메모리 초과 : 인접행렬 + 다익스트라 기본 구현
시간 초과 : 인접리스트 + 다익스트라 기본 구현
성공 : 인접리스트 + 다익스트라 우선순위 큐 구현
```


인접행렬을 이용한 다익스트라로 풀면, 노드에 대한 배열을 만들게 되므로 메모리 효율성이 떨어질 수 있다.

<img src="https://user-images.githubusercontent.com/62600984/130250426-55f39474-0494-4175-ba97-05d3ed5bee9a.png" width=300>

<br>

인접리스트와 우선순위 큐를 이용하면, 메모리와 시간 효율성이 좋다.

<img src="https://user-images.githubusercontent.com/62600984/133259478-60dd4e74-94ae-40b8-91c8-b481a3bfb7b9.png" width=300>

<br>

## 전체 코드

<br>

### 인접 행렬

```java
static int n = 6;
static int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
static int[][] adj; // 인접 행렬
static int[] dist; // 1번 노드와의 거리
public static void main(String[] args) {

  adj = new int[n+1][n+1];
  dist = new int[n+1];
  Arrays.fill(dist, Integer.MAX_VALUE);

  for (int i = 0; i < edge.length; i++) {
    adj[edge[i][0]][edge[i][1]] = adj[edge[i][1]][edge[i][0]] = 1;
  }

  process(1);

  int max = 0;
  int answer = 0;
  for (int i = 2; i <= n; i++) {
    if(dist[i] > max) {
      max = dist[i];
      answer = 1;
    } else if(dist[i]==max) {
      answer++;
    }
  }

  System.out.println(answer);
}

private static void process(int start) {

  boolean[] visit = new boolean[n+1];
  dist[start] = 0;

  for (int i = 1; i <= n; i++) {

    int min = Integer.MAX_VALUE;
    int minIdx = -1;
    for (int j = 1; j <= n; j++) {
      if(!visit[j] && dist[j] < min) {
        min = dist[j];
        minIdx = j;
      }
    }

    visit[minIdx] = true;

    for (int j = 1; j <= n; j++) {
      if(!visit[j] && adj[j][minIdx]==1 && dist[j]>min+1) {
        dist[j]=min+1;
      }
    }
  }
}
```

<br>

### 인접 리스트 + 우선순위 큐

```java
import java.util.*;
import java.lang.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int idx, weight;
        
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static int INF = 30000;
    
    public int solution(int n, int[][] edge) {
        
        adj = new ArrayList[n+1];
        dist = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i <= n; i++){
            dist[i] = INF;
        }
        
        for(int i = 0; i < edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        
        process(n);
        
        int max = 0;
        int maxCnt = 0;
        for(int i = 2; i <= n; i++){
            if(max<dist[i]){
                max = dist[i];
                maxCnt = 1;
            }
            else if(max == dist[i]){
                maxCnt++;
            } else continue;
        }
        
        int answer = maxCnt;
        return answer;
    }
    
    public static void process(int n){
        
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1]; 
            
        q.offer(new Node(1,0));
        visit[1] = true;
        
        while(!q.isEmpty()){
            
            Node node = q.poll();
            visit[node.idx] = true;
            
            for(int tmp : adj[node.idx]){
                if(!visit[tmp] && dist[tmp] > node.weight+1){
                    dist[tmp] = node.weight+1;
                    q.offer(new Node(tmp, dist[tmp]));
                }
            }
        }
    }
}
```
