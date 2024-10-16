# java-calculator-precourse

## 기능 목록

### 입력
- [X] 사용자에게 문자열을 입력하라는 문구를 전달한다. - InputView#readLine
- [X] 덧셈에 사용될 구분자가 포함된 문자열을 입력 받는다. - InputView#readLine

### 문자열 전처리
- [ ] 커스텀 구분자가 존재하는지 검사한다. - InputValidator#isExistCustomSeparator
- [ ] 커스텀 구분자가 있는 경우
  - [ ] 문자열의 5칸을 잘라 "//"와 "\n" 사이에 존재하는 구분자를 찾는다.
  - [ ] 숫자를 분리시키기 위해 문자열 5칸을 잘라낸다.
  - [ ] 커스텀 구분자와 기본 구분자를 사용해서 숫자를 분리한다.
- [ ] 커스텀 구분자가 없는 경우
  - [ ] 기본 구분자를 사용해서 숫자를 분리한다.

### 숫자 유효성 검사
- [ ] 분리된 숫자가 모두 양수인지 검사한다.

### 계산기
- [ ] 분리된 숫자를 모두 더한다.

### 출력
- [X] "결과 : result" 형식으로 계산된 덧셈 결과를 출력한다. - OutputView#printResult
