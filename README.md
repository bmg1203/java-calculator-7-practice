# java-calculator-precourse

## 🚀 구현할 기능 목록 

### ⌨️ 입력

- [ ] 덧셈할 문자열을 입력받는 기능을 구현한다.
  - [x] 덧셈 문자열 입력 안내 메시지를 출력한다.
  - [x] 사용자로부터 덧셈할 문자열을 입력받는다.
  - [x] 입력된 문자열을 검증한다.
    - [x] 숫자가 하나라도 포함되어있지 않은 경우, 예외를 반환한다.
    - [x] 기본 구분자 중 하나라도 포함되어있지 않은 경우, 예외를 반환한다.
  - [x] 입력된 문자열을 파싱 및 추가 검증한다.
    - [x] 입력값에서 편리하게 숫자를 추출하기 위해 전처리를 진행한다.
      - [x] 문자열에 커스텀 구분자가 포함되어 있는지 확인한다.
      - [x] 문자열 앞 부분에 커스텀 구분자가 있는 경우, 이를 따로 저장한다.
      - [x] 커스텀 구분자를 뺸 문자열을 입력값으로 최종 저장한다.
    - [x] 문자열로부터 숫자들을 추출한다.
      - [x] 주어진 문자열에 구분자가 포함되어 있는지 확인한다.
      - [x] 만약 구분자가 포함되어 있는 경우, 구분자를 기준으로 문자열을 분리한다.
      - [x] 구분자를 통해 분리된 값이 빈 문자열일 경우, 결과로 0을 반환한다.
      - [x] 구분자를 통해 분리된 값이 숫자가 아닐 경우, 예외를 반환한다.
      - [x] 구분자를 통해 분리된 값이 음수일 경우, 예외를 반환한다.
    - [x] 최종적으로 분리된 숫자들을 리스트에 저장한다.

### 🖥 출력

- [ ] 덧셈 결과를 출력한다.
  - [x] "결과"라는 문자열와 덧셈 결과를 ":" 구분자를 통해 구분한다.

### ⚙️ 로직

- [ ] 리스트에 저장된 숫자들을 더하는 기능을 구현한다.
  - [x] 리스트에 저장된 숫자들을 모두 더한 결과를 반환한다.