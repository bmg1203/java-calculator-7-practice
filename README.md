# java-calculator-precourse

## Model
### WoowahanTokenizer
- 입력받은 문자열을 나누는 객체
- [x] 문자열에서 커스텀 구분자를 설정하는 명령을 수행해서 커스텀 구분자를 저장한다.
- [x] 설정한 구분자들로 문자열을 나누고 리스트 형식으로 반환한다.

### Operand
- 문자열에서 구분된 문자들을 숫자의 형태로 가공하는 객체
- [x] 나누어진 문자열들을 숫자로 바꾼다.


### Result
- 덧셈 결과를 수행하는 객체
- [x] 피연산자들을 모두 더한다.


## Controller
### Controller
- 요구한 기능을 수행하도록 지시하는 객체



## View
### InputView
- 값을 입력받는 객체
- [x] 과제에서 요구한대로 값을 입력받는다.

### OutputView
- 메시지를 출력하는 객체
- [x] 과제에서 요구한 메시지들을 출력한다.


## Exception
### WoowahanTokenizer
- [ ] 잘못된 값을 입력받았다면 IllegalArgumentException을 발생시킨다.
    - [x] "-"가 커스텀 구분자일 때, 커스텀 구분자가 연속으로 사용되었을 경우

### Operand
- [ ] 잘못된 값을 입력받았다면 IllegalArgumentException을 발생시킨다.
    - [x] Tokenizing된 값들 중 '0'~'9' 이외의 숫자가 포함되어 있는 경우
    - [x] 입력값 중 음수가 포함되어 있었을 경우
