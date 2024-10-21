# java-calculator-precourse

## 기능 요구사항

### 입출력

#### 사용자로부터 입력받기

- `덧셈할 문자열을 입력해 주세요.`라는 메시지 아래에 구분자와 양수로 구성된 문자열을 입력받습니다.

#### 계산 결과 출력하기

- 계산 결과는 `결과 : ` 형태로 출력됩니다.

---

### 구분자 처리

#### 기본 구분자 처리

- 기본 구분자는 쉼표(`,`)와 콜론(`:`)입니다.

#### 커스텀 구분자 처리

- 문자열의 첫 부분에서 `//`와 `\n` 사이에 위치한 문자를 커스텀 구분자로 지정합니다.
- 예: `//;\n1;2;3` => 세미콜론(;)이 구분자가 되어 6이 출력됩니다.

---

### 계산 기능

#### 숫자 추출

- 구분자를 기준으로 문자열을 분리하여 숫자를 추출합니다.

#### 결과 계산

- 추출한 숫자를 더하여 결과를 계산합니다.

#### 빈 문자열 처리

- 빈 문자열(`""`) 입력 시, 0을 반환합니다.

---

### 예외처리

#### 잘못된 입력값 처리

- 잘못된 값이 입력될 경우 `IllegalArgumentException`을 발생시키며, 애플리케이션이 종료됩니다.

---

### 예외 상황 테스트

#### 커스텀 구분자에 숫자 혹은 공백 혹은 아무 문자가 오지 않을 경우

- 테스트 입력: `//1\n`, `// \n`, `//\n`

#### 커스텀 구분자에 기본 구분자를 사용하려는 경우

- 테스트 입력: `//:\n1:2:3`

#### 커스텀 구분자에 두 글자 이상의 길이의 구분자가 입력된 경우

- 테스트 입력: `//@@\n`, `//;;\n1`

#### 두 개 이상의 구분자가 연속으로 입력된 경우

- 테스트 입력: `1,,2`, `1::2`

#### 기본 구분자와 커스텀 구분자 외의 지정하지 않은 구분자를 사용한 경우

- 테스트 입력: `//;\n1@2@3`

#### 커스텀 구분자만 지정하고 숫자를 입력하지 않은 경우

- 테스트 입력: `//;\n`

#### 커스텀 구분자를 지정 형식을 잘못 작성한 경우

- 테스트 입력: `//;/n`