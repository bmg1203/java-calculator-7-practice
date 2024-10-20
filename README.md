# java-calculator-precourse

### 구현할 기능 목록

1. "덧셈할 문자열을 입력해 주세요." 를 출력한다.

2. 사용자가 입력하는 값을 문자열로 받는다.

3.
    1. 사용자가 입력한 문자열이 완전한 공백일 경우 ("")에는 "결과 : 0" 을 출력한다.

    2. 기본 구분자 변수를 쉼표(,) 와 콜론(:) 으로 초기화한다.
       덧셈 결과를 저장할 변수를 0으로 초기화한다.

    3. 입력값 앞부분의 (//) 와 (\n) 사이에 위치하는 문자가 존재한다면, 이를 커스텀 구분자 변수로 저장한다.
       커스텀 구분자를 기준으로 입력값을 분리한다.
       양수 추출 메소드를 호출한다.
       추출한 숫자를 덧셈하여 sum 변수에 저장하고, "결과 : " + sum 을 출력한다.

    4. 입력값에 위의 커스텀 구분자가 존재하지 않고, 기본 구분자는 존재한다면,
       기본 구분자를 기준으로 입력값을 분리한다.
       양수 추출 메소드를 호출한다.
       추출한 숫자를 덧셈하여 sum 변수에 저장하고, "결과 : " + sum 을 출력한다.

    5. 입력값에 커스텀구분자와 기본구분자 모두 없을 경우,
       숫자 사이의 공백, 문자, 기호가 없다면  (예를들어 "222")
       "결과 : " + 숫자값(222) 그대로를 출력한다.

4. 양수 추출 메소드() 작성
   양의 정수 리스트를 선언한다.
   토큰이 양의 정수인지를 확인 후 리스트에 추가한다. 리스트를 반환한다.
   잘못된 입력값 발견 시 IllegalArgumentException 예외를 발생시켜, 프로그램은 종료된다.

------------------------------------------------------------

### 기능 요구 사항

- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
- (종료 시 System.exit() 을 호출하지 않는다.)

------------------------------------------------------------

### 입출력 요구 사항

- 입력 : 구분자와 양수로 구성된 문자열
- 출력 : 덧셈 결과

------------------------------------------------------------

#### 사용자가 잘못된 값을 입력할 경우의 예외처리 테스트

1. 구분자가 하나도 없고, 양수의 숫자가 문자, 기호, 공백과 함께 입력될 경우 ("23=5") ("15+2>>15*45#55?장승희564") ("jang 11 sh14")
   => 구분자가 없으므로 종료

2. 구분자가 하나도 없고, 양수의 숫자 사이 공백이 입력될 경우 ("13 30")
   => 숫자가 하나인지 두개인지 모호하기 때문에 종료, 숫자 사이엔 공백 대신 구분자 필요

3. 양수의 숫자가 하나도 없을 경우 (",,,sad,happy:감정") (":$$::") ("//&\n,&,,,") ("//open the w i n d o w ..")
   => 종료

4. 음수와 실수가 있을 경우 ("-1,2.7,3.3") ("215,-215:-31,5,346:3.19,7.5") ("//-\n5-6-8--2") ("0.8.6.5.0.85")
   => 종료