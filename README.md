# java-calculator-precourse

## 기능 요구 사항
- [] "덧셈할 문자열을 입력해 주세요."를 출력한다.
- [] 문자열을 입력받는다.
- [] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
- [] 기본 구분자(, 또는 :)로 문자열을 구분한다.
- [] 커스텀 구분자가 존재할 수 있다.(문자열 앞부분에 //와 \n 사이에 문자로 지정할 수 있다)
  - 예를 들어, //;\n1;2;3 이면 ; 가 커스텀 구분자가 된다
- [] 구분된 숫자를 더하여 덧셈 결과를 출력한다.
  - [] 빈 문자열의 경우 0을 출력한다.

## 프로그래밍 요구 사항
- 라이브러리 
  - camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다. 
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.