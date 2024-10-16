# java-calculator-precourse

# 📄기능 구현 목록

***기울기처리 + 볼드*** 된 항목에 대해서는 과제에 명시적으로 나와있지 않아 생각해볼 사항

## 1. 사용자로부터 문자열 입력받기

- 입력받는 화면 출력

  > 출력화면
  >    ```
  >    덧셈할 문자열을 입력해 주세요.
  >    ```

- 문자열 입력받기

---

## 2. 구분자 추출 및 입력받은 문자열 검증하기

- `//`와 `\n`사이의 문자에 대해서 구분자로 추출하기
    - `,`와 `:`는 기본 구분자
    - ***`//`와 `\n`사이의 모든 문자를 개별 구분자로 추출하기. (`//;|!\n`가 입력으로 들어올 시 구분자는 `;`, `|`, `!`)***
    - ***`//`와 `\n`사이에 아무것도 존재하지 않는다면 예외를 던지는 것이 아닌 무시할 것***
    - ***`//!!\n`와 같이 커스텀 문자의 중복은 예외를 던지지 않고 `!`하나만으로 처리할 것***
    - ***`1,,2`나 `,1,2`와 같이 구분자 사이에 아무것도 없는 경우 예외를 던지는 것이 아닌 무시할 것***
    - ***커스텀 구분자가 `.`이 들어오는 특별한 경우에는 뒤에 있는 내용에 있는 `.`은 소수가 아닌 구분자로 취급***
        - 나머지 경우는 소수로 취급할 것
        - 예시 : `//.\n1.2,4` -> `결과 : 7`, `//!\n1.2,4` -> `결과 : 5.2`
- 사용자가 정상적인 문자열을 입력하였는지 검증하기

  > 검증할 사항 (유효하지 않을 시 `IllegalArgumentException`)
  >
  > - [ ] 구분자와 숫자 이외의 문자가 들어가 있는지 검사
  >
  > - 입력은 양수만 허용하므로 `+`문자가 들어가있는 경우 또한 커스텀 구분자가 아니리면 오류로 간주할 것.
  >
  > - [ ] `/!\n1,2!3`과 같이 커스텀 구분자 설정을 잘못하는 등 기본적인 문법 오류

---

## 3. 더할 수 있는 형식으로 파싱하기

- 사용자가 입력한 문자열을 구분자에 맞추어 파싱해 요소들로 바꾸기
    - `String` 또는 `BigInteger`로 파싱할 것. `double`이나 `float`을 사용하여 숫자를 담을 경우 오버플로우 발생 가능성 있음.

  > 검증할 사항 (유효하지 않을 시 `IllegalArgumentException`)
  >
  > - [ ] 파싱된 요소가 양수인지 검사
  >
  > - [ ] 파싱된 요소가 `.`이 존재한다면 하나만 존재하는지 검사.

---

## 4. 로직 수행하기 (덧셈)

- 파싱의 결과인 요소들에 대한 덧셈 수행
    - 빈 문자열을 입력하거나, 요소가 없다면 0 출력

---

## 5. 사용자에게 결과 출력하기

- 사용자에게 결과 출력
  > 결과 화면
  >
  >  ```
  >  결과 : {덧셈 합}
  >  ```

- 예외 발생 시 ***사용자에게 알맞은 에러 메시지를 출력***한 후 프로그램을 종료한다.

---
