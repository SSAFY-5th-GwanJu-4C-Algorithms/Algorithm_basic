# 플로이드-워샬(Floyd-Warshall)

`최단 경로` 알고리즘이다.

<br>

## 1. 플로이드-워샬의 개념

> 모든 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘.

> 음의 간선을 포함할 수 있음.

> 단, 음의 사이클이 없어야됨.

다익스트라의 컨셉은 `모든 경유지 탐색`이다.

다익스트라 알고리즘 동작 과정을 통해 자세히 이해해보자.

```
1. 2차원 배열로 간선 정보 초기화(연결되어있지않으면 INF, 자기자신 0)
2. 선택된 정점을 경유지로 설정하여 2차원 테이블 업데이트
3. 2번을 모든 정점에 대해 반복
```

모든 정점 중 정점 하나씩 선택하여 경유지로 설정하고 최단 경로를 구하는 것이

큰 문제를 반복되는 작은 문제로 나누어 푸는 `다이나믹 프로그래밍` 방식이라고 할 수 있다.

<br>

## 2. 플로이드-워샬 구현

for문이 연속적으로 나오는데 각자 for은 다음을 의미한다. 

순서가 헷갈린다면, `경찰과 도둑`을 기억하자!
```
- 첫번째 for: 경유지
- 두번째 for: 출발점
- 세번째 for: 도착점
```

<br>

### 사이클 x

사이클을 고려하지 않는다는 것은 자기자신에 대한 경로를 생각하지 않는다는 뜻이다.

즉, 자기자신에 대한 거리 값은 항상 0이다.

- 초기화
```java
for (int i = 0; i < N; i++) {
  for (int j = 0; j < N; j++) {
    if( i != j && adj[i][j] == 0 ) {
      adj[i][j] = INF;
    }
  }
}
```

- 최단 경로
```java
for (int via = 0; via < N; via++) { //경유지
  for (int from = 0; from < N; from++) { //출발지
    if(via==from) continue;
    
    for (int to = 0; to < N; to++) { //도착지
      if(from==to || via==to) continue;
      
      if(adjMatrix[from][to]>adjMatrix[from][via]+adjMatrix[via][to]) {
        adjMatrix[from][to]=adjMatrix[from][via]+adjMatrix[via][to];
      }
    }
  }
}
```

<br>

### 사이클 o

사이클을 고려한다는 것은 자기자신에 대한 경로를 생각한다는 뜻이다.

즉, 자기자신에 대한 거리 값은 유한한 값이 될수도, 무한한 값이 될 수도 있다.

- 초기화
```java
for (int i = 0; i < N; i++) {
  for (int j = 0; j < N; j++) {
    if( adj[i][j] == 0 ) {
      adj[i][j] = INF;
    }
  }
}
```

- 최단 경로
```java
for (int via = 0; via < N; via++) { //경유지
  for (int from = 0; from < N; from++) { //출발지
    for (int to = 0; to < N; to++) { //도착지
      if(adjMatrix[from][to]>adjMatrix[from][via]+adjMatrix[via][to]) {
        adjMatrix[from][to]=adjMatrix[from][via]+adjMatrix[via][to];
      }
    }
  }
}
```

<br>

## 플로이드-와샬의 시간 복잡도

n: 정점 수

시간 복잡도: O(n^3)

<br>

## 참고 사이트

- [(C++) 플로이드 와샬 Floyd Warshall (+ 최단 경로 알고리즘 비교)](https://ansohxxn.github.io/algorithm/floyd/)
- [[Algorithm]Floyd-Warshall(플로이드-워샬 알고리즘)](https://engkimbs.tistory.com/371)
