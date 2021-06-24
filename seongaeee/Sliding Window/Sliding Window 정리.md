# 슬라이딩 윈도우(Sliding Window)

1차원 배열을 반복적으로 탐색할 경우, `부분 배열`을 활용하는 알고리즘이다.

<br>

## 1. 슬라이딩 윈도우의 개념

> **크기가 고정**된 부분배열을 이용하여 1차원 배열 탐색하는 알고리즘.

슬라이딩 윈도우은 이름 그대로 `고정된 윈도우가 슬라이딩하는 것처럼 움직인다`는 의미이다.

슬라이딩 윈도우 알고리즘 동작 과정은 다음과 같다.

```
1. 윈도우가 오른쪽으로 한칸 옮겨짐.
2. 새 구간의 값 추가.
3. 가장 왼쪽 칸의 값 삭제.
```

<img src="https://user-images.githubusercontent.com/62600984/123208464-19852200-d4fa-11eb-89b0-9470d68d69b7.png" width=600>
<img src="https://user-images.githubusercontent.com/62600984/123208481-20139980-d4fa-11eb-941a-4ffb703304eb.png" width=600>

<br>

## 2. 슬라이딩 윈도우 구현

```java
int arr[];
int k; //윈도우 크기

window_sum = 0;
max_sum = 0;
window_start = 0;

for( int window_end = 0; window_end < arr.length; window_end++) {
  window_sum += arr[window_end];

  if( window_end >= (k-1) ) {
    max_sum = Math.max(max_sum, window_sum);
    window_sum -= arr[window_start];
    window_start += 1;
  }
}
```

<br>

## 슬라이딩 윈도우 시간 복잡도

- for 루프로 모든 배열를 특정 길이만큼 순회하는 방법: O(N^2)

```java
for(int i = 0; i < arr.length-k+1; i++>){
  for(int j = i; j < i+k; j++){}
}
```

- 슬라이딩 윈도우: O(N)

<br>

## 참고 사이트

- [투 포인터 / 슬라이딩 윈도우 알고리즘 간단 정리 (Java)](https://bbangson.tistory.com/72?category=924985)
- [[알고리즘] 슬라이딩 윈도우 알고리즘](https://blog.fakecoding.com/archives/algorithm-slidingwindow/)
