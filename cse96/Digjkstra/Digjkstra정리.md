# Dijkstra

참고:https://blog.naver.com/PostView.naver?blogId=ndb796&logNo=221234424646&parentCategoryNo=&categoryNo=128&viewDate=&isShowPopularPosts=false&from=postView

최단경로 알고리즘

최단경로: 간선의 가중치가 있는 그래프에서 두 정점 사이의 경로들 중에 간선의 가중치의 합이 최소인 경로

하나의 시작 정점에서 끝 정점까지의 최단 경로

- 다익스트라(dijkstra)
  :음의 가중치가 없는 경우

* 벨만-포드(bellman-ford)
  :음의 가중치가 있는 경우

```
s:시작 정점, A:인접 행렬, D: 시작정점에서의 거리
V: 정점 집합, U: 선택된 정점 집합
Dijkstra(s,A,D){
  U = {s};

  for (v : V){
    D[v] = A[s][v]
  }

  while(U != V){
    D[w]가 최소인 아직 선택되지 않은 정점 w를 선택
    for (v in w){
      D[v] = min(D[v],D[w] + A[w][v])
    }
  }
}
```

특징

- 시작 정점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구하는 방식
- 탐욕 기법을 사용한 알고리즘으로 MST의 프림 알고리즘과 유사하다.
- 다이나믹 프로그래밍을 기초로한 알고리즘이다.
- 인접행렬의 경우 시간복잡도가 O(N*N)이고 인접 리스트 방식을 이용하면 시간복잡도는 O(N * logN)이다.
