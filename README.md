java-calculator-7
=

기능 요구사항
-
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현

1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. 
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

2. 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

3. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

--

### Calculator 클래스를 내 기능 구현
- Calculator(String readLine()) :: 생성자를 통해 사용자 입력 값을 인스턴스에 전달 과 checkCustom() 메소드 호출로 커스텀 구분자 여부 체크
- run() :: 
- checkCustom() :: 커스텀 구분자 사용 여부 체크 후 커스텀 및 디폴트 구분자 설정
- sum() :: 확인 된 구분자 및 입력 값으로 문자열 데이터를 int데이터로 변형 후 계산


