# 크루스칼(Kruskal)

> MST(최소 신장 트리, minimum spanning tree): 간선들의 가중치 합이 최소인 신장 트리 (모든 정점을 최소 간선 합으로 연결하는 트리)

`MST` 알고리즘이다.

<br>

## 1. 크루스칼(Kruskal)의 개념

간선 선택을 기반으로 하는 그리디 방식이다.

모든 간선들을 가중치 기준으로 `오름차순`한 후, 순서대로 `사이클`이 있는지 확인해보고 연결해보는 방식이다.

크루스칼 알고리즘 동작 과정은 다음과 같다.

<img src="https://user-images.githubusercontent.com/62600984/124385369-2aab0b80-dd10-11eb-89e6-c46b06840302.png" width=700>

```
1. 간선리스트 가중치 기준 오름차순 정렬
2. 정렬된 간선을 순서대로 선택
3. 사이클 생성 여부 판단 (Union-Find)
4. 사이클 생성이 안되면 그래프에 포함
```

<br>

## 2. 크루스칼(Kruskal)의 구현

- 간선 클래스 생성

```java
static class Edge implements Comparable<Edge>{
  int from,to,weight;

  public Edge(int from, int to, int weight) {
    super();
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge o) {
    return Integer.compare(this.weight, o.weight);
  }
}
```

- 간선리스트 가중치 기준 오름차순 정렬

```java
Arrays.sort(edgeList);
```

- Union-Find

```java
static void make() {
  for (int i = 0; i < V; i++) {
    parents[i]=i; //자기 자신이 대표자
  }
}

static int findSet(int a) {
  if(parents[a]==a) return a;
  return parents[a]=findSet(parents[a]);
}

static boolean union(int a, int b) {
  int aRoot=findSet(a);
  int bRoot=findSet(b);
  if(aRoot==bRoot) return false;

  parents[bRoot]=aRoot;
  return true;
}
```

- 사이클 생성 여부 판단 후, 그래프에 포함

```java
make();
int result=0; //가중치 합
int count=0; //선택한 간선수

for(Edge edge:edgeList) {
  if(union(edge.from, edge.to)) { //싸이클x
    result+=edge.weight;
    if(++count==V-1) break; //V-1개 간선 완성
  }
}
```

<br>

## 참고 블로그

- [[알고리즘] Kruskal 알고리즘 이란](https://gmlwjd9405.github.io/2018/08/29/algorithm-kruskal-mst.html)
