# java-calculator-precourse

## 기능 목록
- [X] 덧셈할 문자열을 입력받는다.
      
- [X] 입력 받은 문자열을 구분자와 숫자로 구분한다.
  - [X] 커스텀 구분자("//"와 "\n" 사이에 위치)를 기본 구분자와 함께 목록에 추가한다.
  - [X] 목록에 있는 구분자에 따라 숫자를 구분한다.

- [X] 숫자를 모두 더해 결과로 출력한다.

## 주의 사항(예외 처리 사항)
- [X] 숫자는 양수만 입력 가능하다(음수 혹은 소수점 등의 문자가 들어가면 안된다.)

- [X] 커스텀 구분자의 유무에 따라 입력이 옳게 되었는지 확인한다.
  - [X] 커스텀 구분자가 있을 경우, "//"와 "\n"이 문자열의 앞부분에 순서대로 작성되어 있어야 한다.
  - [X] 기본 구문자(쉼표, 콜론) 외의 문자는 들어가면 안되며, 커스텀 구분자가 있을 경우에는 이 구분자까지는 가능하다.

- [X] 아무런 숫자와 문자를 입력하지 않았을 경우에는 0을 출력한다.

## 의문점
- [ ] 커스텀 구분자를 여러개 입력 가능한가
  - [ ] 만약 가능하다면 "//"와 "\n"를 여러번 입력해서 하는 것인지, "//"와 "\n" 사이에 설정하고 싶은 구분자들을 입력하면 되는 것인가

- [ ] 숫자 없이 쉼표, 콜론만 입력 했을 경우에는 출력을 어떻게 해야하는 것인가
