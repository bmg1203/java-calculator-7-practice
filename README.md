# java-calculator-precourse

1. 사용자 입력 값을 받기 위해 camp.nextstep.edu.missionutils.Console의 readLine()을 활용 <br>
main 메소드 실행 시 <br>
예) 덧셈할 문자열을 입력해 주세요. <br>
출력 후 입력값 받기

2. 빈 문자열인 경우 0을 출력, 구분자 없이 길이가 1인 문자인 경우에 숫자일 때 숫자반환,  <br>
이외 IllegalArgumentException을 발생시킨 후 애플리케이션 종료  

3. 첫 문자가 숫자인 경우 쉼표(,) 또는 콜론(:)을 구분자로 분리한 배열을 반환하는 메소드 구현  <br>
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6  

4.  문자열 앞부분의 "//"와 "\n" 사이에 위치하는 커스텀 구분자 사용 시  <br>
커스텀 구분자와 뒤의 문자열을 반환하는 메소드 구현

6. 반환된 배열을 숫자로 변환  <br>
문자이거나 음수면 IllegalArgumentException을 발생시킨 후 애플리케이션 종료하도록 구현

7. 양수인 경우 더한 값을 출력하도록 구현  <br>
예) 
결과 : 6
