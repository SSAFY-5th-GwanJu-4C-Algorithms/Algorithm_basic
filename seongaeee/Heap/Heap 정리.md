# 힙(heap)

`우선순위 큐` 구현 알고리즘이다.

<br>

## 1. 힙의 개념

> `완전 이진 트리`의 일종으로 `우선순위 큐`를 위하여 만들어진 자료구조.

> `최댓값`이나 `최솟값`을 빠르게 찾아냄.

최대값을 찾는 힙의 경우, 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있는 정도로 이 같은 상태를 `반정렬 상태`라고 한다.

힙 트리에서는 `중복된 값`을 허용한다.

<br>

## 2. 힙의 종류

> 최대 힙: 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리

> 최소 힙: 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리

<img src="https://user-images.githubusercontent.com/62600984/126067298-1f88e7ac-695d-41fb-8d16-40e40eda7829.png" width=700>

<br>

## 3-1. 힙의 구현

- 힙을 저장하는 표준적인 자료구조는 `배열`이다.
- 구현을 쉽게 하기 위하여 배열의 첫 번째 `인덱스인 0은 사용되지 않는다.`

```
왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
부모의 인덱스 = (자식의 인덱스) / 2
```

```java
public MaxHeap(){
  heap = new ArrayList<>();
  heap.add(Integer.MAX_VALUE); //1부터 시작위해 0인덱스 채워줌
}
```

<br>

## 3-2. 힙의 삽입

```
1. 새로운 노드를 힙의 마지막 노드에 이어서 삽입한다.
2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.
```

<img src="https://user-images.githubusercontent.com/62600984/126067316-6add60b1-ffbe-4430-b5bb-de00971bde1c.png" width=700>

```java
public void insert(int val){
  heap.add(val); //마지막 노드에 삽입
  int index = heap.size()-1;

  while(index > 1 && heap.get(index/2) < heap.get(index)){ //부모노드와 비교하며 자리변경
    int tmp = heap.get(index/2);
    heap.set(index/2, heap.get(index));
    heap.set(index, tmp);
    index=index/2;
  }
}
```

<br>

## 3-3. 힙의 삭제

```
1. 최대 힙에서 최댓값은 루트 노드이므로 루트 노드가 삭제된다.
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
3. 힙을 재구성한다.
```

<img src="https://user-images.githubusercontent.com/62600984/126067332-745fbadc-021f-4e5f-afca-1282631eda1b.png" width=700>

```java
public int delete(){
  if(heap.size()-1 < 1){
    return 0;
  }

  //root노드
  int deleteVal = heap.get(1);
  heap.set(1, heap.get(heap.size()-1));
  heap.remove(heap.size()-1);

  int index=1;
  //자식노드가 있다면 계속 탐색
  while(index*2 < heap.size()){
    int max = heap.get(index*2);
    int maxIndex = index*2;

    //자식노드 2개중에 max값 찾음
    if((maxIndex+1) < heap.size() && max < heap.get(maxIndex+1)){
      max = heap.get(maxIndex+1);
      maxIndex = maxIndex+1;
    }

    //max값보다 커서 변경할 노드가 없을경우 리턴
    if(heap.get(index) > max){
      return deleteVal;
    }

    //크기가 큰 자식노드와 자리변경
    int tmp = heap.get(index);
    heap.set(index, heap.get(maxIndex));
    heap.set(maxIndex, tmp);
    index = maxIndex;

  }
  return deleteVal;
}
```

<br>

## 참고 사이트

- [[자료구조] 힙(heap)이란](https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html)
- [[우선순위 큐/힙]Heap이란?](https://technote-mezza.tistory.com/40)
- [[자료구조] 힙(heap) 구조 (max heap/min heap)](https://tosuccess.tistory.com/31)
