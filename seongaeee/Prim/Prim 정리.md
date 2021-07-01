# 프림(Prim)

> MST(최소 신장 트리, minimum spanning tree): 간선들의 가중치 합이 최소인 신장 트리

`MST` 알고리즘이다.

<br>

## 1. 프림(Prim)의 개념

`단계적 확장`을 하는 방법을 사용한다.

프림 알고리즘 동작 과정은 다음과 같다.

<img src="https://user-images.githubusercontent.com/62600984/124134135-7fa31380-dabd-11eb-8587-ba03c7931fe8.png" width=500>

```
1. 초기화 및 시작 정점 설정(dist[start] = 0)
2. dist배열 중 가장 짧은 간선 선택
3. 2번에서 선택한 정점을 기준으로 연결된 정점과의 거리가, 기존 dist보다 작으면 갱신
4. 2, 3번 반복(간선 갯수만큼)
```

<br>

## 2. 프림(Prim)의 구현

- 초기화 및 시작 정점 설정

```java
int[] minEdge=new int[N]; //신장트리에 연결된 정점에서 자신으로의 최소간선비용
for (int i = 0; i < N; i++) {
  minEdge[i]=Integer.MAX_VALUE;
}

int result=0; //가중치 합
minEdge[0]=0; //처음 선택한 정점(0)은 0으로 초기화
```

- prim

```java
for (int c = 0; c < N; c++) {

  //신장트리에 연결되지 않은 정점 중 minEdge비용이 최소인 정점
  int min=Integer.MAX_VALUE;
  int minVertex=0;
  for (int i = 0; i < N; i++) {
    if(!visited[i] && min>minEdge[i]) {
      min=minEdge[i];
      minVertex=i;
    }
  }

  //선택되면?
  result+=min; //해당정점의 간선 비용 누적
  visited[minVertex]=true;

  //선택된 정점의 인접 정점까지의 간선비용 vs 최소비용
  for (int i = 0; i < N; i++) {
    //아직 방문 안했고 && 연결되어있으며 && 인접 정점 최소간선비용 > 선택된 정점의 인접 정점까지의 간선비용
    if(!visited[i] && adjMatrix[minVertex][i]!=0 && minEdge[i]>adjMatrix[minVertex][i]) {
      minEdge[i]=adjMatrix[minVertex][i];
    }
  }
}
```

<br>

## 참고 블로그

- [<Prim의 MST 알고리즘> 기본개념과 알고리즘](https://mattlee.tistory.com/46)
- [프림 알고리즘](https://m.blog.naver.com/arceus2/222079740841)
