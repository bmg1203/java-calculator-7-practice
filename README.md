# java-calculator-precourse

기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


입출력 요구 사항

입력
구분자와 양수로 구성된 문자열

출력
덧셈 결과

[구현할 기능]
1. 덧셈기능 -> input으로 숫자배열을 받아서, 덧셈결과를 반환한다.
2. 인풋 문자열 parsing 기능 -> 구분자 기준으로 숫자 나누기
3. 커스텀 구분자 지정기능 -> //와 \n 사이에 있는 문자를 커스텀 구분자로 지정해준다.

[생각해볼것]
1. 한번의 입력에 커스텀 구분자 여러개를 지정할 수 있는가? //a\n//b\n//c\n 이런식으로..
2. 양수라고 했으니.. int라고 가정하고 진행하면 되는것이겠지?