# 동적 계획법(다이나믹 프로그래밍, Dynaminc Programming)

`중복되는 부분 문제 해결` 알고리즘이다.

<br>

## 1. 다이나믹 프로그래밍의 개념

### 다이나믹 프로그래밍 조건

다이나믹 프로그래밍은 다음의 조건을 만족할 때 사용할 수 있다.

> `최적 부분 구조` : 큰 문제를 작은 문제로 나눌 수 있으며, 작은 문제의 답을 모아서 큰 문제를 해결할 수 있음.

> `중복되는 부분 문제` : 동일한 작은 문제를 반복적으로 해결해야됨.

<br>

### 다이나믹 프로그래밍 구현

`메모이제이션`은 다이나믹 프로그래밍 구현 방법 중 하나이다.

> 메모이제이션(Memoization): 한번 계산한 결과를 메모리 공간에 저장하며, 같은 문제가 다시 호출되면 메모했던 결과를 가져옴.

<br>

### 예시를 통해 이해하기

다이나믹 프로그래밍은 `피보나치 수열`로 쉽게 이해할 수 있다.

아래 그림에서 f(2)가 여러번 호출되는 것을 볼 수 있다.

즉, 피보나치 수열을 구하기 위해선 중복된 문제를 해결해야했다.

<img src="https://user-images.githubusercontent.com/62600984/125189392-db665d00-e272-11eb-82c5-9a09eaae1531.png" width=700>

<br>

이를 해결하기 위해 다이나믹 프로그래밍을 적용할 수 있다.

다이나믹 프로그래밍을 구현하기 위해서는 `메모이제이션`을 이용한다.

다이나믹 프로그래밍을 이용하면 다음과 같이 색칠된 노드만 처리한다.

<img src="https://user-images.githubusercontent.com/62600984/125189405-e15c3e00-e272-11eb-8dfc-b0874187f318.png" width=700>

<br>

## 2. 다이나믹 프로그래밍의 구현

예시로 피보나치 수열 구현.

### DP를 적용하지 않은 피보나치

```java
int fibo(int n) {
  if (n<=2)
    return 1;
  else
    return fibo(n-1) + fibo(n-2);
}
```

<br>

### DP를 적용한 피보나치

```java
int fiboData[]; //메모이제이션을 위한 배열

int fibo(int n) {
  if (n<=2)
    return 1;
  if (fiboData[n]==0)
    fiboData[n] = fibo(n-1) + fibo(n-2);
  return fiboData[n];
}
```

<br>

## 참고 사이트

- [[이것이 코딩 테스트다] 6. 다이나믹 프로그래밍](https://freedeveloper.tistory.com/276)
- [[자료구조와 알고리즘] 동적 계획법](https://velog.io/@chelsea/1-%EB%8F%99%EC%A0%81-%EA%B3%84%ED%9A%8D%EB%B2%95Dynamic-Programming-DP)
