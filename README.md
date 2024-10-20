# java-calculator-precourse
# 문자열 덧셈 계산기
## 기능
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
## 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
    - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록
### 1. Main
- 동작
    - 문자열을 입력받는다.
    - 해당 문자열을 계산 프로그램에 입력 후 계산 결과를 받는다.
    - 결과를 출력한다.
### 2. 계산 컨트롤러
- 기능
    - 뷰를 통해 값을 입출력한다.
    - 서비스를 통해 값을 처리한다.
### 3. 계산 서비스
- 기능
    - 문자열을 입력받고, Calculator(계산기)와 StringSeparator(문자열 분리기)를 통해 숫자의 합을 계산한다.
- 입출력
    - 입력 : `String`, 문자열
    - 출력 : `Integer`, 문자열 속 모든 숫자들의 합
### 2. 계산기
- 기능
    - 입력받은 숫자들을 계산한다.
- 입출력
    - 입력 : `List<Integer>`, 계산할 숫자 리스트
    - 출력 : `Integer`, 리스트의 모든 숫자들의 합
### 3. 분리기
- 기능
    - 구분자와 숫자가 포함되어 있는 문자열에서 커스텀 구분자를 판별한다.
    - 커스텀 구분자를 포함한 구분자들로 문자열을 파싱(분리)한다.
- 입출력
    - 입력 : `String`, 구분자와 숫자가 포함되어있는 문자열
    - 출력 : `List<Integer>`, 계산할 숫자 리스트
### 4. 뷰
- 기능
    - 사용자로부터 문자열을 입력받는다.
    - 결과값을 화면에 출력한다.
### 5. 테스트
- 기능
    - 다양한 케이스에 대해 테스트 한다.
