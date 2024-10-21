# java-calculator-precourse

## 문자열 덧셈 계산기 기능 목록

### 1. 입력 값 처리
- 사용자의 문자열 입력을 받는다.
- 입력이 빈 문자열이거나 null인 경우 결과는 0을 반환한다.

### 2. 구분자 처리
- 기본 구분자는 쉼표(`,`)와 콜론(`:`)을 사용한다.
- 커스텀 구분자를 지원하며, 커스텀 구분자는 `//`와 `\n` 사이에 위치한다.

### 3. 문자열 분리
- 입력된 문자열을 구분자를 기준으로 분리한다.

### 4. 숫자 합 계산
- 분리된 각 숫자의 합을 계산한다.
- 음수를 입력한 경우 `IllegalArgumentException`을 발생시킨다.

### 5. 예외 처리
- 음수를 입력할 경우 예외를 발생시키고, 해당 입력에 대해 에러 메시지를 출력한다.
- 유효하지 않은 숫자를 입력한 경우 예외를 발생시킨다.