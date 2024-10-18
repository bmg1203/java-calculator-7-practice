# java-calculator-precourse

#### Application에서 controller.CalculatorOperation의 operateCalculator 메서드를 실행하면서 프로그램이 동작한다.

### view
  - [x] 사용자의 입력을 받는 InputView 클래스를 구현한다.
  - [x] 사용자에게 계산 결과를 출력하는 OutputView 클래스를 구현한다.
### validator
  - [x] 사용자 입력에 대해 검증하고 예외 발생 시 IllegalArgumentException을 throw하는 InputValidator 클래스를 구현한다.
### controller
  - [x] CalculatorOperation 클래스를 구현한다.
    - [x] 로직을 순차적으로 수행하는 operateCalculator 메서드를 생성한다.
      - [x] view.InputView을 통해 사용자로부터 입력을 받는다.
      - [x] splitDelimiterAndOperand 메서드를 통해 구분자와 피연산자에 대한 처리를 진행한다.
      - [x] calculateAndGetResult 메서드를 통해 계산을 하고 결과를 받아온다.
      - [x] fetchResultToView 메서드를 통해 결과를 OutputView로 전달한다.
      - [x] 예외 발생 상황을 추적한다.
### model
  - [x] Calculator 클래스를 구현한다.
    - [x] 피연산자들에 대한 operands, 구분자들에 대한 delimiters, 연산 결과에 대한 result를 멤버변수로 갖는다.
    - [x] 피연산자를 입력받기 위해, setOperands 메서드를 구현한다.
    - [x] 피연산자들을 더하여 결과 저장하는 saveResult 메서드를 구현한다.
    - [x] 결과를 return하기 위해 getResult 메서드를 구현한다.
    - [x] 커스텀 구분자가 존재하는 경우가 있으니, 구분자 목록에 구분자를 추가하는 addCustomDelimiter 메서드를 구현한다.
    - [x] 구분자를 기준으로 피연산자들을 split 하기 위해서, delimiters를 return하는 getDelimiters 메서드를 구현한다.
### service
  - [x] StringCalculate 클래스를 구현한다.
    - [x] 커스텀 연산자에 대한 전처리를 하는 preprocessDelimiter 메서드를 구현한다.
      - [x] 커스텀 구분자의 존재 여부를 파악하여 저장한다.
      - [x] 커스텀 구분자와 관련된 문자열 (// ~ \n) 부분을 떼어낸다.
    - [x] 피연산자들을 구분하고 저장하는 splitAndSaveOperands 메서드를 구현한다.
        - [x] 구분자들을 기준으로 피연산자를 구분한다.
        - [x] 구분한 피연산자들을 문자열에서 정수로 변환한다.
        - [x] 정수로 변환한 피연산자들을 모델에 저장한다.
    - [x] 결과를 모델로부터 얻어 반환하는 fetchResult 메서드를 구현한다.