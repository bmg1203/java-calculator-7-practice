# java-calculator-precourse

처음에는 절차 지향 방식으로 코딩했지만 (처음부터 커밋 해시 **9f26604**까지),  
이후 객체 지향 방식으로 변경했습니다.

<br>

## 구현 기능 목록

- [x] **문자열 입력 기능**  
  사용자로부터 문자열 `String`을 입력 받습니다.
    - **메서드**: `InputHandler.getInput()`


- [x] **커스텀 구분자 확인 기능**  
  문자열에 커스텀 구분자가 지정되어 있는지 확인하고 `boolean` 형태로 반환합니다.
    - **메서드**: `Validator.hasCustomDelimiter()`


- [x] **커스텀 구분자 반환 기능**  
  문자열에서 커스텀 구분자를 추출하고 반환합니다.
    - **메서드**: `StringParser.getCustomDelimiter()`


- [x] **숫자 배열 변환 기능**  
  문자열을 구분자 기준으로 분리하여 숫자 배열을 반환합니다.
    - **메서드**: `StringParser.convertStringToIntArray()`


- [x] **숫자 배열 합 계산 기능**  
  배열의 모든 숫자의 합을 계산하고 반환합니다.
    - **메서드**: `Calculator.calculateNumbers()`


- [x] **입력값 검증 기능**  
  입력된 문자열이 잘못된 값이라면, `IllegalArgumentException`을 발생시킨 후 종료합니다.
    - **메서드**: `Validator.checkString()`

<br>

## 구체적인 조건

1. **구분자는 단일 문자여야 합니다.**  
   구분자(character) 이기에 이렇게 판단했습니다.

2. **구분자는 숫자일 수 없습니다.**  
   이것이 숫자로서의 입력인지 구분자로서의 입력인지 파악하는 것이 불가능하기 때문입니다.

3. **구분자 다음에는 숫자를 입력해야 합니다.**  
   두 번 연속 구분자를 입력하거나, 구분자가 문자열의 마지막에 있다면 `IllegalArgumentException`으로 처리합니다.

4. **입력된 모든 숫자의 합은 int 범위를 넘지 않습니다.**
