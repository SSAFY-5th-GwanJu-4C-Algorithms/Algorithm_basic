# 이진탐색 (Binary Search)

`탐색` 알고리즘이다.

<br>

## 1. 이진탐색 개념

> 정렬된 배열을 전제로 탐색하는 알고리즘

`이진`이란 이름이 붙여진 이유는 `한번 비교를 거칠때 탐색 범위가 반(1/2)`으로 줄어들기 때문이다.

이진 탐색 알고리즘 동작 과정은 다음과 같다.

<img src="https://user-images.githubusercontent.com/62600984/124863154-95e72d00-dff1-11eb-9089-ca9d52a6f800.png" width=500>

```
1. 중앙요소 선택
2-1. 찾으려는 값이 중앙요소보다 작으면? 왼편에서 중앙요소 선택
2-2. 찾으려는 값이 중앙요소보다 크면? 오른편에서 중앙요소 선택
3. 2번 반복, 찾으려는 데이터와 일치하면 끝.
```

<br>

## 2. 이진탐색 구현

```java
int BinarySearch(int dataArr[], int size, int findData) {

  int low = 0, high = size - 1, mid;

  while (low <= high) {

   mid = (low + high) / 2;

   if (dataArr[mid] > findData) high = mid - 1;
   else if (dataArr[mid] < findData) low = mid + 1;
   else return mid;

  }

  return -1;
}
```
<br>

## 3. 이진탐색 시간복잡도

데이터 크기가 n 일때, 시간복잡도는 `O(logN)`이다.

이에 대한 증명은 다음과 같다.

<img src="https://user-images.githubusercontent.com/62600984/124863250-bd3dfa00-dff1-11eb-9d17-9cf878e23f99.png" width=100>

<br>

## 참고 사이트

- [이진 탐색(Binary Search)](https://blog.hexabrain.net/246)
