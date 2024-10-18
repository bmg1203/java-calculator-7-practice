# 문자열 덧셈 계산기

## 구현할 기능 목록

### 숫자 입력 받기

덧셈할 숫자와 구분자를 입력받는다.

- [ ] "덧셈할 문자열을 입력해 주세요." 입력

### 숫자와 구분자 검사하기

양수로 된 숫자인지, 구분자 쉼표(,) 또는 콜론(:)이 있는지, 커스텀 구분자가 있는지 알맞게 있는지 검사한다.

- [ ] 구분자 쉼표(,) 또는 콜론(:)을 가지는 경우
    - [ ] seperator 배열에 저장
- [ ] 커스텀 구분자가 있는 경우
    - [ ] "//" 와 "\n" 사이에 위치하는 커스텀 구분자를 확인
    - [ ] 확인된 커스텀 구분자를 seperator 배열에 저장
- [ ] 커스텀 구분자 양식이 잘못된 경우
    - [ ] 잘못된 입력값이므로 IllegalArgumentException을 발생시킨 후 프로그램 종료
- [ ] 양수 이외의 숫자가 입력될 경우
    - [ ] 잘못된 입력값이므로 IllegalArgumentException을 발생시킨 후 프로그램 종료

### 숫자 더하기

구분자와 숫자를 나눈 후, 숫자를 덧셈한다.

- [ ] 양수와 구분자 구분하기
    - [ ] 구분자 기준으로 split한 후, 숫자를 배열에 저정함
- [ ] string형으로 되어 있는 숫자를 int형으로 형변환 후, 숫자를 전부 더함

### 숫자 출력하기

더한 숫자를 출력한다.

- [ ] 형변환된 숫자를 "결과 : {답}" 형태로 출력

---

### 고민해본 예외 처리

- [ ] 커스텀 구분자가 하나라는 말은 없음
    - [ ] 확장 가능한 커스텀 구분자 구현 - 배열 대신 리스트 형태로 구분자 설정