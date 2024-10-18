# java-calculator-precourse

# 문자열 덧셈 계산기

## 기능 요구 사항
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
  >1. ',' 와 ':' 은 기본 구분자
  >2. 반복문을 돌며 입력 받은 문자열의 문자를 하나씩 판별.


- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6


- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
- 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
  >1. 커스텀 구분자를 포함한 구분자들을 모아두는 저장소가 있어야 함.


- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
  >1. 구분자로 지정되지 않은 기호가 입력 되었을 때
  >2. 숫자가 입력되지 않은 경우(입출력 요구사항)
  >3. 구분자가 입력되지 않은 경우(입출력 요구사항)
  >4. 양수가 아닌 수가 입력된 경우(입출력 요구사항)
  >5. 아무것도 입력되지 않은 경우


- 실행 결과 예시
  > 덧셈할 문자열을 입력해 주세요.\
  > 1,2:3\
  > 결과 : 6


### Main(Domain)
- Calculator
  - 덧셈 계산을 실행하는 객체(문자열과 구분자 비교)
- Separator
  - 기본 구분자와 커스텀 구분자를 모아두는 저장소 역할
### View
- InputView
- OutputView
### Controller
- CalculatorController
