#문제 풀이
링크 
프로그래머스 카펫 (링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42842)

## 제한조건
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.

## 시간 복잡도 분석 및 전략
시간복잡도 : O(N)

### 해결방안
선형 탐색

### 예외케이스

### 고민했던 흔적들
편법?일수도 있지만 아래의 규칙이 존재 이 규칙말고도 완탐으로 풀수있는방법도 고려해봐야함
가로는 brown = horizon*2+(vertical-2)*2
 (brown/2)+2 = horizon+vertical
7=horizon+vertical
최소 vertical은 3이상 어야함 horizon은 뭐가나와도 상관없음
최소 탈출조건 크거나 아래 조건을 만족하면 esccape
 (brown/2)+2 = horizon+vertical