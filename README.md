# java-calculator-precourse


## 개요
이 프로그램은 사용자로부터 입력받은 문자열을 파싱하여 숫자를 추출하고, 지정된 구분자(쉼표, 콜론 및 커스텀 구분자)를 기준으로 숫자들을 더한 결과를 반환한다. 
사용자는 기본 구분자(쉼표, 콜론) 외에 `//`와 `\n` 사이에 커스텀 구분자를 지정할 수 있다.

## 기능 목록
1. **입력 기능**
    - 사용자로부터 문자열을 입력받는다.

2. **커스텀 구분자 저장**
    - `//`와 `\n` 사이에서 커스텀 구분자를 추출한다.
    - 커스텀 구분자를 기억하여 이후의 파싱에 사용한다.
   
3. **예외 처리**
    - 지정된 구분자 대신 다른 구분자가 입력된 경우 예외 처리.
    - 커스텀 구분자 형식이 잘못된 경우 예외 처리.
    - 맨 앞, 혹은 맨 뒤가 숫자가 아닌 경우 예외 처리.
    - 음수가 입력된 경우 예외 처리.
    - 각 구분자의 사이가 숫자가 아니거나, 구분자가 중복으로 입력된 경우 예외 처리.
    - 입력된 구분자가 문자가 아니라 숫자인 경우 예외 처리.

4. **문자열에서 숫자 추출**
    - 구분자를 기준으로 문자열을 분리하여 숫자를 추출한다.
    - 추출된 String 형 숫자들을 Integer로 변환한다.
    - 변환된 숫자들을 저장한다.
   
5. **추출한 숫자들의 합을 구하고 값을 출력**
    - 저장된 숫자들의 합을 계산한다.
    - 계산 결과를 사용자에게 출력한다.

## 구현 상태 CheckList 
- [-] 사용자 입력 받기 기능 구현
- [-] 커스텀 구분자 추출 및 저장 기능 구현
- [-] 커스텀 구분자 형식 오류 처리
- [-] 음수 입력 시 예외 처리
- [-] 구분자 사이에 숫자가 없는 경우 예외 처리
- [-] 문자열에서 숫자 추출 기능 구현
- [-] 숫자 합산 기능 구현
- [-] 계산 결과 출력 기능 구현
