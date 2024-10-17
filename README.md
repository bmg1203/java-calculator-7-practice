# java-calculator-precourse

## 구현 기능 목록

### 기능

- [x] 쉼표(,) 또는 콜론(:)을 구분하여 숫자를 추출
- [x] //와 \n 사이에 위치한 커스텀 구분자 추출
    - [x] 커스텀 구분자 여러 개 입력할 수 있도록 처리
- [x] 커스텀 구분자(문자)를 구분하여 숫자를 추출
- [x] 추출한 숫자의 합 반환

### 입력

- [x] 사용자 문자열 입력
    - [x] 공백 입력할 수 있도록 처리
- [ ] 잘못된 입력 예외처리
    - [x] 양수가 아닌 숫자의 입력에 대한 예외처리
    - [ ] 구분자 사이 숫자가 아닌 입력의 예외처리
    - [ ] 기본 구분자의 경우 다른 구분자 사용 시 예외처리
    - [ ] 커스텀 구분자 시작(//) 또는 종료(\n)에 대한 잘못된 입력의 예외처리
    - [ ] 커스텀 구분자가 문자가 아닌 입력의 예외처리 (구분자를 숫자로 사용할 수 없다)

### 출력

- [x] 문자열 입력 안내 문구 출력
- [x] 덧셈 결과 출력