# java-calculator-precourse

## 구현할 기능
* 사용자 입력
  * (쉼표, 콜론 또는 커스텀 구분자) 구분자와 양수로 구성된 문자열
    * 커스텀 구분자: 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
      * "//;\n1;2;3” ⇒ ;
  * 쉼표와 콜론이 구분자인 경우에는 숫자가 먼저 입력됨
  * 커스텀 구분자인 경우에는 "//"이 먼저 입력됨
---
* 토큰 및 숫자 분리
  * 쉼표, 콜론, 커스텀 구분자와 숫자를 분리해야 함
  * 커스텀 구분자의 경우, //와 \n 사이에 위치하는 문자를 추출
---
* 결과 출력
  * 구분자로 구분되는 숫자들의 덧셈 결과를 출력
---
* 오류 처리
  * 음수 등 잘못된 값 입력시 IllegalArgumentException 발생 후 종료
---
