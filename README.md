# 기능 목록 정리

1. 목표: 더하기 기능을 제공하는 계산기를 구현한다.

2. 기능 분리
   - 1단계
     a. 구분자와 양수로 구성된 문자열을 입력
     b. 구분자를 기준으로 숫자를 추출
     c. 숫자를 더하고 반환
     
  - 2단계
    a. 기본 구분자(, 또는 :)가 포함된 문자열을 입력되면, 기본 구분자를 기준으로 숫자를 분리해서 더한 후 반환
    b. "//"와 "\n"사이에 지정된 구분자가 있는 문자열을 입력되면, 지정 구분자를 기준으로 숫자를 분리해서 더한 후 반환
    c. 음수같은 의도하지 않은 값이 입력되면, IllegalArgumentException을 발생후 프로그램 종료
    d. 빈 문자열이 입력되면, 0을 반환
    
  - 3단계
    a. 사용자로부터 문자열을 입력받고, 계산 결과를 반환해주는 Application 객체 구현
    b. 계산기가 제공하는 기능을 보여주는 Calculate 인터페이스     //지금은 plus기능만 가지고 있지만, 빼기와 곱셈등 기능이 추가 될 수 있음.
    c. Calculate의 plus기능을 구현하는 PlusImpl 객체 구현
    d. 사용자가 입력한 값의 유효성을 검증하는 Verify 객체 구현    //음수 같은 잘못된 값 입력 처리
    e. 사용자의 문자열 입력값을 계산 가능한 숫자 타입으로 가공해주는 CalculateFactory 객체 구현
    
