# 투 포인터(Two Pointer)

배열을 반복적으로 탐색할 경우, `부분 배열`을 활용하는 알고리즘이다.

<br>

## 1. 투 포인터의 개념

> **가변적인 크기 & 연속적인** 부분배열을 이용하여 배열을 탐색하는 알고리즘.

먼저 투 포인터는 배열을 가리키는 `2개 포인터`를 뜻한다.

보통 Left, Right를 사용하며, `[Left, Right)`를 의미한다. = (`arr[Left]~arr[Right-1]`)

예시를 통해 투 포인터 알고리즘 동작 과정을 알아보자.

```
ex. 부분배열의 합이 특정 값(Target)을 이루는 부분배열의 개수

- 합이 더 크거나 같으면? Left++
- 합이 더 작으면? Right++
- 합이 같으면? cnt++

같으면 Left를 늘려주는 이유는, 다음 배열 탐색을 위해서이다.
```

<br>

## 2. 투 포인터의 구현

**투 포인터의 시작 위치 배치** 방법에 따라 구현이 달라진다.

<br>

#### 1) 첫번째 원소와 마지막 원소에서 시작

```java
// Q. 두 원소의 합이 x인 경우가 있는지 확인

int[] n; //정렬된 배열
int x;

int left = 0;
int right = n.length-1;

while(left < right>){

  if(n[left] + n[right] == x) {
    return true;
  }else if(n[left] + n[right] > x) {
    right--;
  }else {
    left++;
  }
}

return false;
```

<br>

#### 2) 둘 다 첫번째 원소에서 시작

```java
//Q. 부분배열의 합이 target인 경우의 수

int[] n;
int target;
int sum;
int cnt;

int left = 0;
int right = 0;

while(start < n.length){

  if(sum == target){
    cnt++;
  }

  if(sum >= target) {
    sum -= n[left];
    left++;
  }else {
    sum += n[left];
    right++;
  }
}
```

<br>

## 참고 블로그

- [투 포인터 / 슬라이딩 윈도우 알고리즘 간단 정리 (Java)](https://bbangson.tistory.com/72?category=924985)
- [[java] 투 포인터 알고리즘](https://hongjuzzang.github.io/cs/two_pointers/)
