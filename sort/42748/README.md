#문제 풀이
링크 
프로그래머스 K번째 (링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42748)

## 제한조건
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

## 시간 복잡도 분석 및 전략
commnad M 만큼 아래의 시간복잡도 사용
O(M*NlogN)

### 해결방안
정렬과 복사를 사용

### 예외케이스


### 고민했던 흔적들
Arrays.sort와 Arrays.copyofRange 두가지 함수를 사용
정렬과 복사 함수를 사용할떄 각각 아래와 같이 시간복잡도가 필요
Arrays.copyOfRange: 최대 N만큼 복사하므로 O(N)
Arrays.sort: quickSort사용시 O(NlogN) 사용