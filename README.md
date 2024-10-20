# **문자열 덧셈 계산기**

## 구현 기능 목록

### 빈 문자열의 처리

- [X]  입력이 “” 일때, 0으로 인식하도록 구현하기

### 쉼표(,)와 콜론(:)을 구분자로 사용하는 기본 덧셈

- [X]  쉼표(,) 또는 콜론(:)을 구분자로 사용하는 기본적인 덧셈 기능을 구현하기
    - 예: `"1,2" => 3`, `"1,2:3" => 6`

### 커스텀 구분자의 처리

- [X]  문자열 앞부분의 "//"와 "\n" 사이에 커스텀 구분자로 사용커스텀 구분자가 포함된 경우 이를 처리하는 기능을 추가하기
    - 예: `"//;\n1;2;3" => 6`

### 숫자 추출 및 실제 덧셈 로직

- [X]  기본 + 커스텀 구분자를 기준으로 숫자를 추출하고, 해당 숫자들을 더하는 기능을 구현하기

### 예외 처리

- [X]  ‘잘못된’ 입력이 들어온 경우, `IllegalArgumentException`을 발생시키는 예외 처리 로직을 구현하기
    - [X]  **음수가 입력된 경우**: 입력 조건은 **구분자와 양수로 구성된 문자열**이므로 **음수**가 들어왔을 때 예외를 발생시킨다
    - [X]  **숫자가 아닌 입력의 경우:** 숫자와 구분자 외에 다른 문자가 입력된 경우 예외를 발생시킨다
        - 예: `"1,a,3"` 또는 `"1,2:b"` → `IllegalArgumentException` 발생
    - [X]  **구분자가 연속으로 나타난 경우:** 기본 구분자(쉼표, 콜론) 또는 커스텀 구분자가 연속으로 나타난 경우 예외를 발생시킨다
        - 예: `"1,,2"` 또는 `"1::2"` → `IllegalArgumentException` 발생
    - [X]  **입력 문자열이 구분자로 시작하거나 끝나는 경우**: 입력 문자열의 시작 또는 끝이 구분자인 경우 예외를 발생시킨다
        - 예: `“,1,2”`, `"1,2,"` → `IllegalArgumentException` 발생
    - [X]  **공백이 포함된 경우**: 입력 문자열에 불필요한 공백이 포함된 경우 예외를 발생시킨다
        - 예: `"1, 2"` 또는 `"1 ,2:3 "` → `IllegalArgumentException` 발생
    - [X]  **정의되지 않은 구분자가 입력된 경우:** 사전에 정의되지 않은 구분자가 입력된 경우 예외를 발생시킨다
        - 예: `"//;\n1;2@3"` → `IllegalArgumentException` 발생
    - [X]  **유효하지 않은 커스텀 구분자를 정의한 경우**: 커스텀 구분자를 알파벳과 같은 문자나 숫자로 지정한 경우, 혹은 비워둔 경우 예외를 발생시킨다
        - 예: `"//\n1;2;3"` → `IllegalArgumentException` 발생
        - 예: `"//121\n112121213"` → `IllegalArgumentException` 발생

### 최종 계산값 출력

- [X]  덧셈 결과를 출력하는 기능을 구현