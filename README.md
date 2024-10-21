# java-calculator-precourse
<br><br>

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
<br><br>


## 입출력 요구 사항

입력

> 구분자와 양수로 구성된 문자열

실행 결과 예시

> 덧셈할 문자열을 입력해 주세요.
> 
> 1,2:3
>
> 결과 : 6

<br><br>

## 구현할 기능목록

## 1. 문자열 입력
- [X] **1-1.** 빈 문자열 입력 처리: 입력값이 빈 문자열일 경우 0을 출력한다.
- [X] **1-2.** 숫자 외의 값이 포함된 입력에 대한 예외 처리: 커스텀 구분자 관련 부분 제외한 문자열에 구분자가 아닌 다른 문자가 포함되어있을 경우 IllegalArgumentException을 발생시킴.
- [X] **1-3.** 음수 값 예외 처리: 입력된 숫자 중 음수가 있을 경우 IllegalArgumentException을 발생시킴.
## 2. 문자열 덧셈
- [X] **2-1.** 커스텀 구분자 확인: 문자열의 첫 부분 "//"와 "\n" 사이에 문자가 있을 경우 이를 커스텀 구분자로 정의한다.
- [X] **2-2.** 구분자(쉼표, 콜론, 커스텀 구분자)로 숫자 분리: 쉼표(,), 콜론(:) 또는 커스텀 구분자를 사용해 입력된 문자열을 분리한 후, 분리된 숫자들의 합을 계산한다.
## 3. 출력
- [X] **3-1.** 결과 값 출력: 계산 결과를 콘솔에 출력.
