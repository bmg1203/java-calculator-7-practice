# 1주차 과제 - 문자열 덧셈 계산기

----

## 기능 목록

### 1. **사용자 입력 받기**

- 덧셈할 문자열을 입력하도록 요청한다.


- 콘솔을 통해 입력된 문자열을 처리하여 이후 계산에 사용한다.

### 2. **기본 구분자(쉼표, 콜론)를 이용한 문자열 분리 및 합산**

- 입력된 문자열을 쉼표(`,`)와 콜론(`:`)으로 구분한다.


- 구분된 숫자를 합산하여 결과를 도출한다.

### 3. **커스텀 구분자 기능**

- 사용자가 지정한 커스텀 구분자를 지원한다.


- 입력 문자열의 앞부분에 `//`와 `\n` 사이의 구분자를 읽어들이고 이를 기준으로 문자열을 분리하고 합산한다.

### 4. **음수 입력에 대한 예외 처리**

- 음수가 입력되면 `IllegalArgumentException`을 발생시켜 "음수는 허용되지 않습니다" 와 같은 에러 메시지를 출력한다.


- 입력에 음수가 포함되면 계산을 진행하지 않고 예외를 던진다.

### 5. **잘못된 입력에 대한 예외 처리**

- 숫자가 아닌 값이 입력된 경우 `IllegalArgumentException`을 발생시켜 "잘못된 입력 값입니다."와 같은 에러 메시지를 출력한다.

### 6.**결과 출력**

- 계산된 합산 결과를 출력한다.


- 입력한 값에 따른 덧셈 결과를 전달한다. 