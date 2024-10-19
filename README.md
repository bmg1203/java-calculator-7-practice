# java-calculator-precourse

* 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현

  1. 쉼표(,) 또는 콜론(:) 구분자를 기준으로 분리한 각 숫자의 합
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

  2. 음수 입력시 예외 발생

   3. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자 지정
    - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환.
