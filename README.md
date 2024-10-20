# java-calculator-precourse

# Project Directory
    calculator
    ┣ config
    ┃ ┗ Configuration.java
    ┣ constant
    ┃ ┗ CalConst.java
    ┣ controller
    ┃ ┗ CalculatorController.java
    ┣ dto
    ┃ ┗ CheckSeparatorDto.java
    ┣ service
    ┃ ┣ separator
    ┃ ┃ ┗ Separator.java
    ┃ ┣ validator
    ┃ ┃ ┗ Validator.java
    ┃ ┗ CalculatorService.java
    ┣ view
    ┃ ┣ InputView.java
    ┃ ┗ OutputView.java
    ┗ Application.java

## 구현할 기능 목록

    1. 문자열을 입력 받는 기능
    2. 문자열에 추가 구분자 입력이 있는지 확인하는 기능
    3. 문자열을 구분자를 기준으로 나누는 기능
    4. 구분자로 나눠진 문자열에 숫자 외의 다른 문자가 있는지 확인하는 기능 있으면 IllegalArgumentException
    5. 나눠진 숫자를 더하는 기능

## 테스트 필요 하다 생각 되는 것들

- [x] 문자열을 아무 것도 주지 않았을 때
- [x] 추가 구분자로 숫자를 줬을 때
- [x] 소수 넣어 보기(추가 구분자로 .을 줬을 때와 아닐 때)
- [x] 역슬래시(이스케이프 문자를 구분자로 줬을 때)
- [x] 구분자 사이에 숫자가 없을 때

## 확인 필요

### 1. 커스텀 구분자가 여러 개라면?
    현재 만들어진 로직은 커스텀 구분자가 한 개인 경우만을 받고 있으나 그렇지 않을 수도 있음.
    만약에 //와 \n 사이에 두 개가 들어가면 그건 따로 떨어뜨려서 구분을 해야하나?
    //ea\n1ea2ea3ea 이 주어지면 ea로 묶어서 구분자로 사용해야 하나?
    
### 2. 커스텀 구분자에 숫자가 들어온다면?
    당연히 계산기라면 커스텀 구분자에 숫자가 들어오면 안되긴 함. 
    커스텀 구분자에 숫자가 들어오는 경우 IllegalArgumentException 해야하는가? 
    아니면 구분자로 인식하고 계산시켜야 하는가?
    지금은 계산하도록 만들어둠.

### 3. 아무 입력도 하지 않았다면?
    입력이 없으면 0을 출력하도록 했음. 근데 IllegalArgumentException 해야하는지?

### 4. 구분자 사이에 숫자가 없다면?
    현재는 사이에 숫자가 없다면 0으로 인식하고 계산을 진행하도록 하였음.
    이것도 throw 해야하는 경우인가?