# 문자열 덧셈 계산기

## 핵심 기능
- [x] 문자열에서 구분자를 기준으로 숫자를 분리한다.
- [x] 추출된 숫자의 합을 계산한다.
- [x] 커스텀 구분자를 등록한다.
- [x] 계산기 어플리케이션을 시작한다.

## 객체 도출
핵심 기능으로부터 객체를 도출한다.
- 구분자를 기준으로 숫자를 분리한다.
  - DelimiterParser
- 추출된 숫자의 합을 계산한다.
  - Calculator
- 커스텀 구분자를 등록한다.
  - DelimiterManager
- 계산기 어플리케이션을 시작한다.
  - CalculatorExecutor

## 추가 기능 도출
핵심 기능 외 추가적인 기능을 도출한다.
- [x] '덧셈할 문자열을 입력해 주세요.'를 출력한다.
- [x] 구분자와 양수로 구성된 문자열을 입력받는다.
- [x] 빈 문자열을 입력받으면 0을 반환한다.
- [x] 숫자가 하나만 입력되면 해당 숫자를 반환한다.
- [x] 잘못된 입력 시 예외를 처리한다.
- [x] 결과를 출력한다.
- [x] 등록된 구분자인지 확인한다.
- [x] 구분자들을 조합하여 정규표현식을 생성한다.
- [x] 커스텀 구분자를 파싱한다.
- [x] 기존 입력에서 커스텀 구분자를 제외한 문자열을 반환한다.
- [x] 입력값에서 구분자들만 추출하여 반환한다.

## 추가 객체 도출
추가 기능으로부터 객체를 도출한다.
- '덧셈할 문자열을 입력해주세요.'를 출력한다.
- 구분자와 양수로 구성된 문자열을 입력받는다.
  - InputHandler
- 빈 문자열 입력을 처리한다.
  - InputValidator
- 잘못된 입력 시 예외를 처리한다.
  - ExceptionHandler
- 결과를 출력한다.
  - ResultPrinter

## 객체 및 메서드
- DelimiterParser
  - parse()
  - buildDelimiterRegex()
  - parseCustomDelimiter()
  - removeCustomDelimiter()
- Calculator
  - sumNumbers()
- DelimiterManager
  - registerCustomDelimiter()
  - isValidDelimiter()
- CalculatorExecutor
  - run()
- InputHandler
  - getInput()
  - printInputMessage()
- InputValidator
  - isEmptyInput()
  - validateInputPattern()
  - validateCustomDelimiterPattern()
  - validateDefaultDelimiterPattern()
  - validateUnregisteredDelimiter()
  - isSingleNumberInput()
- ResultPrinter
  - printResult()

## 예외 처리
- 빈 값이 들어왔을 때
- input 패턴이 올바르지 않을 때
- 등록되지 않은 구분자를 사용했을 때
- 커스텀 구분자 등록 형식을 지키지 않았을 때
- 숫자의 형식이 올바르지 않을 때
  - ex) 123b
- 구분자 사이에 숫자가 있지 않을 때