# 백트래킹(Backtracking)

`최적화 문제`와 `결정 문제`를 위한 알고리즘이다.

<br>

## 1. 백트래킹의 개념

> 해를 찾는 도중 해가 아니어서 막히면, **되돌아가서** 다시 해를 찾아가는 기법.

주로 문제 풀이에서는 DFS 등으로 `모든 경우의 수`를 탐색하는 과정에서,

조건문 등을 걸어 `답이 절대로 될 수 없는 상황`을 정의하고,

그러한 상황일 경우에는 탐색을 중지시킨 뒤 그 `이전으로 돌아가서` 다시 다른 경우를 탐색하게끔 구현한다.

<br>

백트래킹 알고리즘 동작 과정은 다음과 같다.

```
1. 어떤 노드의 유망성을 점검.
2. 유망하지 않으면 배제.(가지치기)
3. 해당 노드의 부모노드로 되돌아간 후 다른 자손노드를 검색.
```

> 유망성(Promising) : 가망이 있는가 없는가를 따지는 기준

> 가지치기(Pruning) : 유망성을 따져보고, 유망하지 않는 경우의 수는 배제

<br>

<img src="https://user-images.githubusercontent.com/62600984/125807147-226d081b-8b2b-49e5-a8eb-d83c81224b18.png" width=500>

<br>

## 참고 사이트

- [알고리즘 - 백트래킹(Backtracking)의 정의 및 예시문제](https://chanhuiseok.github.io/posts/algo-23/)
- [DFS, BFS, 백트래킹(Backtracking)](https://velog.io/@leobit/DFS-BFS-%EB%B0%B1%ED%8A%B8%EB%9E%98%ED%82%B9Backtracking)
