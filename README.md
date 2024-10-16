# java-calculator-precourse

## 구현할 기능 목록

- [x] 계산할 문자 입력받는 기능
- [x] 문자열에서 숫자를 추출하는 기능
  - [x] 커스텀 구분자 추출하는 기능
      - 커스텀 구분자가 단일 문자가 아니면 예외를 던진다. (기능 요구 사항에 문자열이 아닌 문자로 기재되어 있음)
      - 커스텀 구분자에 음수가 아닌 숫자가 올 수 있다. (숫자는 문자의 하위 집합)
  - [x] 문자열에 포함된 커스텀 구분자 제거하는 기능
  - [x] 구분자로 문자열 분리하는 기능
  - [x] 문자열 목록을 숫자 목록으로 변환하는 기능
      - 숫자로 변환할 수 없으면 예외를 던진다.
      - 양수가 아니면 예외를 던진다.
- [x] 숫자 더하는 기능
- [x] 결과 출력하는 기능

## TODO
- 빈 값에 대한 예외 처리
- 입력 값 유효 길이 정하기
