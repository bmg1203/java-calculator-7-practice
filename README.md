# java-calculator-precourse

## 프로젝트 소개
이 프로젝트는 사용자가 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현하는 과제입니다. 다양한 구분자를 사용하여 숫자를 분리하고, 그 합을 계산하는 기능을 포함합니다. 또한, 잘못된 입력에 대한 예외 처리를 합니다.

## 기능 요구 사항
1. 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예:
        - `""` => `0`
        - `"1,2"` => `3`
        - `"1,2,3"` => `6`
        - `"1,2:3"` => `6`

2. 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 구분자로 사용한다.
    - 예:
        - `"//;\n1;2;3"` => `6` (구분자: `;`)
        - `"//|\n1|2|3"` => `6` (구분자: `|`)

3. 사용자가 잘못된 값을 입력하는 경우, `IllegalArgumentException`을 발생시키고 프로그램이 종료된다.
    - 예:
        - 음수 입력 시 예외 발생 (`"-1,2,-3"`)

## 기능 목록
1. **빈 문자열 처리**: 빈 문자열("")이 입력되면 0을 반환한다.
2. **기본 구분자 처리**: 기본 구분자인 .을 기준으로 숫자를 분리하고, 이를 합산한다.
3. **커스텀 구분자 지원:** 입력 문자열이 //로 시작하고 \n이 포함된 경우, 사용자 정의 구분자를 추출하여 이를 기준으로 숫자를 분리하고 합산한다.
4. **잘못된 입력 예외 처리**: 음수 또는 잘못된 입력이 들어오면 `IllegalArgumentException`을 발생시킨다.

