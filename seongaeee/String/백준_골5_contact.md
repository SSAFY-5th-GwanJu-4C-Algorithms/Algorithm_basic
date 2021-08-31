## 문제

![image](https://user-images.githubusercontent.com/62600984/131506321-cd7e19f2-7e2e-4ec5-91fb-40ad05019e41.png)

[문제보기](https://www.acmicpc.net/problem/1013)

<br>

## 문제 풀이

정규표현식만 알면 바로 적용해서 풀 수 있는 문제이다.

여기서 알아야될 부분은 정규표현식에 `띄어쓰기를 포함하지 않는 것`이다.

잘 모르고 처음에 문제에 있는 정규 그대로 복붙..했더니 자꾸 답이 안나왔다. 주의하자!

<br>

## 전체 코드

```java
String pattern = "(100+1+|01)+";
int T = Integer.parseInt(br.readLine());

for (int t = 0; t < T; t++) {

  String s = br.readLine();
  System.out.println(s.matches(pattern)? "YES": "NO");
}
```
