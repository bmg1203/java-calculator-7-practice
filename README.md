# java-calculator-precourse

## 기능 목록

- [x] 프로그램 시작 시 사용자에게 힌트를 출력한다.
- [x] 문자열을 입력받는다.
- [x] 문자열을 파싱한다.
  - [x] 커스텀 구분자가 존재하는지 확인한다.
    - [x] 커스텀 구분자가 존재한다면 구분자를 수정한다. (기본 구분자는 `,`와 `:`로 정의한다.)
  - [x] 구분자를 기준으로 문자열을 나눈다.
    - [x] 문자열을 나누었을 때, 숫자가 아닌 문자가 들어올 경우 `IllegalArgumentException`을 발생시킨다.
    - [x] 나눈 문자열을 정수로 변환한다.
- [x] 정수들의 합을 출력한다.
