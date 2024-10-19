# java-calculator-precourse

## 기능 요구 사항 분석 후, 구현할 기능 목록 (v1 - 2024.10.17)

---

## 리팩토링 전, 구현 기능 구체화 (v2 - 2024.10.20)

### 1. 입출력 기능

- [X] 입력값 받기
    - [X] 입력값은 주어진 라이브러리를 이용함
    - [X] 입력 정수의 크기에 제한이 없어야 함

- [X] 결과 출력 하기
    - [X] 정상적인 출력은 "결과 : [Answer]" 형태임

### 2. 구분자 기능

- [X] 커스텀 구분자 사용 여부 확인
    - [X] 구분자는 유니코드에 속하는 모든 문자가 가능해야함
    - [X] 커스텀 구분자 사용 시, 기본 구분자에 더해지는 형태임

### 3. 문자열 숫자 추출 기능

- [X] 문자열 유효성 확인 및 구분자를 통한 숫자 추출
    - [X] 문자열은 구분자, 숫자로만 구성 되어야함
    - [X] 0으로 시작하는 수("012")는 12로 취급함 (단, "0"은 예외 발생)
    - [X] 추출한 숫자는 반드시 양수여야 함
    - [X] 커스텀 구분자로 숫자가 들어올 경우, 해당 수는 구분자로 우선함
    - [X] 빈 문자열("")은 0으로 취급함
    - [X] 추출한 숫자들은 BigInteger List에 저장함
    - [ ] 추출 과정에서의 에러는 모두 IllegalArgumentException을 발생시킴

- [X] 숫자 덧셈
    - [X] 추출한 숫자 리스트가 비어있는 경우 0을 반환함