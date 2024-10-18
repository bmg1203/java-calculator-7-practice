# 문자열 덧셈 계산기

## 기능 목록

1. **빈 문자열 또는 `NULL` 입력 처리**
   - 입력값이 빈 문자열("")이거나 `NULL`일 경우, `0`을 반환한다.

2. **쉼표(`,`) 또는 콜론(`:`)을 구분자로 사용**
   - 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달할 경우, 해당 문자열에 포함된 숫자의 합을 반환한다.
   - 예시: `"1,2,3"` => `6`, `"1:2:3"` => `6`

3. **커스텀 구분자 지정**
   - 커스텀 구분자를 사용할 수 있다. 커스텀 구분자는 문자열의 앞부분에 `"//"`와 `"\n"` 사이에 위치하는 문자를 사용하여 지정한다.
   - 예시: `"//;\n1;2;3"` => `6`

4. **숫자가 아닌 값 입력 시 예외 발생**
   - 입력된 값 중 숫자가 아닌 값이 포함될 경우, `IllegalArgumentException` 예외를 발생시킨다.
