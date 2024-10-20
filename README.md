# java-calculator-precourse

## 기능 요구 사항

1. **빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.**

    - 예시: `""` → 0, `null` → 0

2. **숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.**

    - 예시: `"1"` → 1

3. **쉼표(,) 또는 콜론(:) 구분자로 연결된 문자열을 입력할 경우 숫자의 합을 반환한다.**

    - 예시: `"1,2:3"` → 6

4. **커스텀 구분자를 지정할 수 있다.**

    - 문자열 앞부분에 `"//"`와 `"\n"` 사이에 위치한 문자를 커스텀 구분자로 사용한다.
    - 예시: `"//;\n1;2;3"` → 6 (`;`를 구분자로 사용)

5. **음수나 숫자가 아닌 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.**

    - 예시: `"1,-2,3"` → `IllegalArgumentException`, `"1,a,3"` → `IllegalArgumentException`

6. **사용자로부터 문자열을 입력받고 결과를 출력하는 기능을 구현한다.**

    - 콘솔을 통해 문자열을 입력받고 결과를 출력한다.
    - 입력 안내 문구: `"덧셈할 문자열을 입력해 주세요."`
    - 출력 형식: `"결과 : 6"`
