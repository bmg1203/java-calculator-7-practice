# java-calculator-precourse

---

## 구현 기능 목록

### 1. 문자열 입력 기능

- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 이외의 외부 라이브러리는 사용하지 않는다.

### 2. 기본 구분자(쉼표, 콜론)를 기준으로 숫자 분리 기능

- 빈 문자열의 경우 0을 반환한다.
- 예: "" => [0], "1,2" => [1,2], "1,2,3" => [1,2,3], "1,2:3" => [1,2,3]

### 3. 커스텀 구분자를 기준으로 숫자 분리 기능

- "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이다.

### 4. 분리한 숫자들의 합 계산 기능

- 숫자가 1 2 3일 경우 6을 반환한다.

---

### 예외 처리 - 잘못된 입력 값에 대한 IllegalArgumentException 발생 후 애플리케이션 종료

- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 잘못된 입력 값 예시
    - 구분자(기본+커스텀), 숫자 외 문자 또는 기호 입력
    - 문법 오류
    - 커스텀 구분자에 두 글자 이상 입력(문자열이 아닌 문자를 커스텀 구분자로 사용하기 때문)
    - 음수 입력 = 입출력 요구사항 중 입력: '구분자와 양수로 구성된 문자열'
    - 구분자가 숫자 사이에 존재하지 않는 입력 (예: 1,,2,3  /  1,2,3,)
      - 구분자는 숫자를 구분하는 역할을 하기 때문
      - 이를 허용할 경우 1,2,3,,,,,,,,도 가능
    - 커스텀 구분자로 숫자 입력

### 추가 고려 사항

1. 커스텀 구분자에 기본 구분자를 사용할 수 있는지 -> 가능
    - 커스텀 구분자에 기본 구분자를 사용할 수 없다는 요구사항이 없기 때문에 같아도 문제가 되지 않는다.
2. 커스텀 구분자를 지정하고 기본 구분자를 같이 사용할 수 있는지. 예시 "//;\n1;2,3" -> 가능
    - 커스텀 구분자는 추가적인 구분자이므로 기본 구분자 또한 유효하다.