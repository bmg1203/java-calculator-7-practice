# java-calculator-precourse

### 최종 목적

- 숫자 합을 출력한다.

### 주요 기능

- 커스텀 구분자가 있는지 확인한다.
- 기본 구분자(쉼표, 클론)과 커스텀 구분자로부터 숫자를 분리한다.
- 숫자의 합을 구한다.

### 플로우

1. (input) 문자열을 입력 받는다
2. _커스텀 구분자가 있는지 확인한다._ //커스텀구분자\\n
3. 커스텀 구분자 양식을 삭제한 식을 저장한다.
4. _구분자와 숫자를 분리한다._
5. 숫자를 저장한다.
6. _숫자의 총 합을 구한다._
7. (output) 출력한다.

### 유효검사

- (커스텀 문자 제외) 입력된 값이 쉼표, 클론, 숫자 뿐인가? 1,2\\3
- 숫자가 음수인가? 1,-2:3
- 아무것도 입력되지 않았는가? ""
- 등록되지 않은 구분자를 사용했는가? //!\\n1,2!3$5
- 양식에 맞는 커스텀 구분자를 추가했는가? ///$\n1$2
- 커스텀 구분자가 ""은 아닌가? //\\n1,2:3
- 커스텀 구분자가 문자가 아니라 문자열인가? //**\\n1**2,3
- 커스텀 구분자가 -일때 음수인가? //-\\n1,2-3--4

---

### 고민해볼 부분

- 공백처리
- 문자란 무엇인가? 영어, 숫자, 특수 문자, 공백
- ~~//;\n//!\n1;2;3! = 커스텀 문자가 여러개인 경우도 가능할까?~~
