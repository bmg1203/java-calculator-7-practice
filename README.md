# java-calculator-precourse

### 기능 목록
- [X] 문자열 입력
- [X] 문자열에서 구분자 추출
    - 기본: `,`, `:`
    - 커스텀: 문자열 앞부분 `//`와 `\n`사이 문자
- [X] 구분자를 바탕으로 문자열에서 숫자 추출
- [X] 덧셈 수행
- [X] 시작 메시지 출력
- [X] 결과 메시지 출력
- [X] 예외 처리
    - [X] 구분자로 분리한 문자가 정수 형식이 아니면 `IllegalArgumentException` 발생
    - [X] 피연산자가 음수이면 `IllegalArgumentException` 발생