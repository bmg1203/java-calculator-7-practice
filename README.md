# 문자열 숫자 덧셈기

### 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 구현 기능 목록

1. 입력 처리 : 사용자로부터 문자열을 입력받는 기능.
    - 입력을 처리하고, 이를 문자열 계산기(StringCalculator)에 전달.
    - 구현 세부 사항:
        - Console.readLine()을 통해 문자열을 입력받는다.
            - 입력 형식: `'문자열을 입력하세요.'`과 같은 형태로 출력한다.
        - 입력이 빈 문자열이거나 잘못된 형식일 경우 예외를 처리한다.
            - 빈 문자열 입력 시: `'입력값이 없습니다.'` 메시지를 출력하고 종료한다.
            - 잘못된 형식의 입력 시: `'잘못된 형식의 입력입니다.'` 메시지를 출력하고 종료한다.


2. 구분자 처리 : 문자열에서 사용할 구분자를 식별하고, 이를 통해 숫자들을 분리하는 기능
    - 기본 구분자(`,` 및 `:`)와 커스텀 구분자를 식별하고, 이를 처리한다.
    - 구현 세부 사항:
        - 기본 구분자(`,`, `:`)로 숫자를 분리하는 기능을 구현한다.
        - 커스텀 구분자(`//;\n`)를 처리할 수 있도록 확장성을 고려한다.
        - 구분자 처리 인터페이스(DelimiterHandler)를 만들고, 이를 구현하는 기본 및 커스텀 구분자 처리 클래스를 만든다.


3. 문자열 계산 로직 : 입력된 문자열을 숫자로 변환하고, 합을 계산하는 기능.
    - 주어진 문자열에서 숫자들만 추출하여 더한 값을 반환한다.
    - 구현 세부 사항:
        - 문자열을 구분자 처리기를 통해 분리하고, 이를 숫자 배열로 변환한 뒤 합산한다.
        - 구분자와 관계없이 숫자를 추출하고 계산할 수 있도록 StringCalculator를 구현한다.
        - 만약 입력값이 음수이거나 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다.


4. 예외 처리 : 잘못된 입력이나 규칙에 맞지 않는 값에 대해 예외를 처리하는 기능.
    - 사용자의 잘못된 입력에 대한 오류 메시지를 제공하고 프로그램을 종료한다.
    - 구현 세부 사항:
        - 빈 문자열이 입력된 경우 예외를 발생시킨다.
        - 음수가 입력된 경우에도 예외를 발생시킨다.
        - 구분자가 맞지 않는 경우 IllegalArgumentException을 발생시킨다.


5. 출력 처리 : 계산 결과를 출력하는 기능.
    - 계산된 합을 사용자에게 출력한다.
    - 구현 세부 사항:
        - 결과값을 Console.printLine()을 통해 출력한다.
        - 출력 형식: `'결과 : '`과 같은 형태로 출력한다.
        - 결과를 출력할 때 잘못된 값이 입력된 경우 예외 메시지를 출력하고 종료한다.
