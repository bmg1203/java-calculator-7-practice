# 🖥️ java-calculator-precourse

![Static Badge](https://img.shields.io/badge/woowa-1week-yellow)

### 👀 소개

<hr>

- 우아한테크코스 웹 백엔드 7기 프리코스

- 2024.10.15 ~ 2024.10.21

### 🗒️ 구현할 기능 목록

<hr>

1. 입력 받기
   > 문제에서 제공하는 readLine()함수 사용

2. 구분자 세팅
    - 옳은 입력 vs 잘못된 입력
      > 추가적으로 고려할 custom 구분자가 있는지 확인하기
      >
      > 옳은 양식이라면 "//"과 "\n"의 위치는 고정
      >
      > 문자열의 앞부분 입력 양식 판단
      >
      > 기본 구분자에 custom 구분자 추가
      >
      > (error판단은 여기서 하지않음)

3. 문자열 tokenizing
    - custom 구분자 양식 자르기
      > custom 구분자가 있다면 문자열 앞의 5칸을 자름
      >
      > expression이 남게됨
    - tokenize expression
      > delimiters에 따라 문자열을 자르고 반환

4. 덧셈
    - 잘못된 입력 검사하며 token 더하기
      > 옳은 입력에는 몇 가지 조건 존재
      >
      > - 시작은 숫자
      > - 끝은 숫자
      > - 구분자 뒤에는 숫자
      > - 숫자는 모두 양의 정수
      > - 구분자는 ',' or ':' or '{customDelimiter}'
      >
      > 이 조건을 벗어나는 입력은 IllegalArgumentException 처리
      >
      > 숫자는 모두 합하여 최종 결과 계산

5. 결과 출력
   > 결과를 옳은 형식으로 출력
   
