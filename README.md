# java-calculator-precourse
## Introduction
우아한테크 프리코스 1주차 미션입니다. 사용자의 인풋을 받아 숫자를 올바르게 추출하여 더하는 계산기를 구현하는 프로그램입니다. 
## Implementation Breakdown
### Input Handling
1. `InputHandler` 클래스를 생성할것.
2. 사용자로부터 인풋 스트링을 받기. 이떄 쓸 읽을 콘솔은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 쓸것.
3. 처음으로 커스텀 구분자를 확인 할것, 확인이 된후 `//`, `\n`, 그리고 이 사이에 있는 커스텀 구분자를 기존의 인풋에서 제거할것. (커스텀 구분자 선언 위치는 불확실)
   1. 커스텀 구분자가 숫자인지 체크할것.
4. 그 다음 으로 쉼표, 콜롬, 커스텀 구분자를 기준으로 문자열을 분리할것 
5. 분리한 토큰이 valid한지 체크할것
   1. 분리한 토큰이 `integer` 인지 확인할것 
   2. 분리한 토큰이 숫자가 negative가 될수 있는지? 된다면 try and catch문을 써서 확인 할것 
   3. 분리한 토큰이 문자열이면 IllegalArgumentException을 발생하고 Application Terminate시키기 
### Calculator Operation
1. `Calculator` 클래스를 생성할것.
2. `Strategy` 인터페이스로 `Calculate`를 쓰고 `Add`에 상속받아 클래스로 작성할것
3. `Add` 클래스에 `Input Handling` section에서 모든 사항을 충족한 token list를 임자로 받아서 더한 값을 리턴하는 메소드를 쓸것 
4. 결과값을 출력할것

## Log
- 1.1 Strategy Pattern을 활용해서, 더하는 Operation을 구현하기 위해 Strategy Interface로 Calculate을 생성하고 구현체로 구현했다. 그다음으로 strategy를 쓰기 위한 context class인 Calculator class를 구현했다. 
- 1.2. Input Handling을 Calculator class에 구현할려고 했으나 SOLID principle 중에 Single Responsibility를 omit하는 거 같아 InputHandler라는 class를 생성했다.

## Restriction
1. 프로그램 종료시 `System.exit()`을 호출하지 않을 것
2. 제공된 `build.gradle`은 변경하지 않을 것
3. 패키지의 이름을 바꾸지 않을 것

### TODO
Review the notes on Records vs. Lombok and consider whether refactoring the immutable classes is feasible.