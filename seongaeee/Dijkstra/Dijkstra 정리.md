# 다익스트라(Dijkstra)

`최단 경로` 알고리즘이다.

<br>

## 1. 다익스트라의 개념

> 하나의 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘.

> 단, 음의 간선을 포함할 수 없음.

다익스트라의 컨셉은 `최단 거리 갱신`이다.

다익스트라 알고리즘 동작 과정을 통해 자세히 이해해보자.

```
1. 최단 거리 배열 MAX로 초기화
2. 출발 노드 설정
3. 최단 거리 배열(출발 노드) 0으로 갱신
4. 방문하지 않은 노드 중, 최단 거리가 가장 짧은 노드 선택하고 방문 처리
5. 4번에서 선택한 노드를 거쳐 다른 노드(방문하지않은 노드)로 가는 비용 계산하여, 최단 거리 배열 갱신
6. 4번, 5번 반복
```

매 상황에서 방문하지 않은 가장 비용이 적은 노드를 선택하므로 `그리디 알고리즘`이라고 할 수 있다.

<br>

## 2-1. 다익스트라 구현 - 기본

```java
int N=Integer.parseInt(in.readLine()); //정점 수
int[] distance=new int[N]; //최단 거리
int[][] adMatrix=new int[N][N];
boolean[] visited=new boolean[N];

Arrays.fill(distance, Integer.MAX_VALUE);

int start=0; //출발점
distance[start]=0;

for (int i = 0; i < N-1; i++) {

    int min=Integer.MAX_VALUE;
    int current=0; //min 최단 거리에 해당하는 정점 번호
    for (int j = 0; j < N; j++) {
        if(!visited[j] && min>distance[j]) {
            min=distance[j];
            current=j;
        }
    }
    visited[current]=true;

    for (int j = 0; j < N; j++) {
        if(!visited[j] && adMatrix[current][j]!=0 && distance[j] > min+adMatrix[current][j]) {
            distance[j]=min+adMatrix[current][j];
        }
    }
}
```

<br>

## 2-2. 다익스트라 구현 - 우선순위 큐

위의 기본 구현에서 매번 최단 거리를 구하는 것(`4번 과정`)은 시간 복잡도를 높이는 주범이다.

이를 해결하기 위해, `최단 거리를 오름차순`으로 저장하는 우선 순위 큐를 추가한다.

- 우선 순위 큐를 위한 클래스

```java
static class Node implements Comparable<Node>{

    int idx, distance;

    public Node(int idx, int distance) {
        super();
        this.idx = idx;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }

}
```

- 코드

```java
int N=Integer.parseInt(in.readLine()); //정점 수
int[] distance=new int[N]; //최단 거리
int[][] adMatrix=new int[N][N];
PriorityQueue<Node> pq = new PriorityQueue<>();

Arrays.fill(distance, Integer.MAX_VALUE);

int start=0; //출발점
distance[start]=0;
pq.offer(new Node(start, 0));

while ( !pq.isEmpty() ) {

    Node curNode = pq.poll();
    int dist=curNode.distance;
    int cur=curNode.idx; //min 최소비용에 해당하는 정점 번호

    //이미 처리된 적 있으면 넘어감
    if(distance[cur] < dist) continue;

    for (int j = 0; j < N; j++) {
        if(adMatrix[cur][j]!=0 && distance[j] > dist+adMatrix[cur][j]) {
            distance[j]=dist+adMatrix[cur][j];
            pq.offer(new Node(j, distance[j]));
        }
    }
}
```

<br>

## 다익스트라의 시간 복잡도

n: 정점 수, e: 간선 수

- 기본 구현: O(n²)
- 우선순위 큐 구현: O(elogv)

<br>

## 참고 블로그

- [[이것이 코딩 테스트다] 7. 최단 경로 알고리즘](https://freedeveloper.tistory.com/277)
- [[알고리즘/자바] 다익스트라 알고리즘 (Dijkstra Algorithm)](https://gaybee.tistory.com/34)
