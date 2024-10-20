# java-calculator-precourse

## 💡 애플리케이션 설명

> ❓ 애플리케이션의 대략적인 설명입니다.
>

- 입력한 문자열에서 숫자를 추출해 더하는 계산기이다.

## 🛤️ 애플리케이션 플로우

> ❓ 애플리케이션의 대략적인 흐름을 정리합니다.
>

1. 문자열을 입력받는다.
2. 입력받은 문자열에서 숫자를 추출한 후, 숫자들의 합을 계산한다.
3. 숫자의 합을 반환한다.

## ⚙️ 필수 기능

> ❓ 프로젝트에 필요한 필수 기능 정리을 정리합니다.
>

- 핵심기능 1. 문자열에서 구분자를 인식한 후 숫자를 추출하는 기능
- 핵심기능 2. 추출한 숫자들을 더하는 기능

---

- 추가기능 1. 커스텀 구분자를 인식하는 기능

## ⚒️ 기능 분리

> ❓ 필수 기능을 객체에 분리합니다. 지속적으로 업데이트됩니다.
>

- `Number`
    - 분리된 숫자 한 개를 담당함.
    - 숫자에 대한 검증.
- `Numbers`
    - `Number` 들의 콜렉션. 여러 숫자들을 담당함.
    - 숫자들의 합에 대해 담당함.
- `OriginalInput`
    - 사용자 입력으로 들어온 문자열을 담당함.
    - 구분자와 숫자들을 구분함.
- `Delimiter`
    - 구분자를 담당함.
    - 특정 문자가 구분자로 사용되지 않게 함.

## 👉 입력

> ❓ 입력 예시입니다.
>

- 1,2:3
- (없음)
- 1,2
- 1,2,3
- //;\n1;2;3

## 👈 출력

> ❓ 출력 예시입니다.
>

```
덧셈할 문자열을 입력해 주세요.

(입력)

결과 : 6
```

## ⛔ 예외 목록

> ❓ 프로그램의 예외 상황입니다. 사양에 따라 추가되거나 삭제될 수 있습니다.
>

- [x]  입력이 공백이 아닐 때, 숫자 혹은 "//" 이외의 값으로 시작하는 경우
- [x]  커스텀 구분자가 없을 때, 입력된 문자열에 쉼표(,) 콜론(:) 이외의 구분자가 들어오는 경우. 즉 숫자가 들어올 공간에 공백, null 이외의 문자가 들어오는 경우.
- [x]  커스텀 구분자를 제시할 때, "//" 와 "\n" 이외의 문자로 구분하려고 시도하는 경우.
- [x]  커스텀 구분자가 주어졌을 때, 올바르지 않은 커스텀 구분자를 사용하려고 하는 경우 (ex 숫자, 공백, null, .(dot))
- [x]  커스텀 구분자가 주어졌을때, 이후 문자열에서 커스텀 구분자 이외의 구분자가 들어오는 경우
- [x]  입력된 문자열에 양수가 아닌 숫자가 들어있는 경우 (ex. 0, 음수)
- [x]  주어진 문자열에 올바른 구분자만 존재하는 경우 → 숫자가 없기 때문에 구분자의 의미가 없음

## ⭕ 예외가 아닌 경우

> ❓예외가 아닌 경우를 정리합니다.
>

- 주어준 문자열에 양수이면서 정수가 아닌 실수가 주어지는 경우 → 조건은 모든 양수만 제시하고 있음 (즉 3.5와 같은 실수는 가능할 것으로 보임)
- 구분자 없이 숫자만 주어지는 경우 → 하나의 숫자로 처리
- 입력으로 공백, null이 들어오는 경우 → 0으로 처리

## 📂 폴더 구성

> ❓ 폴더 및 파일 구성입니다.
>

```bash
└── src
    ├── main
    │  └── java
    │      └── calculator
    │          ├── Application.java
    │          ├── constants
    │          │   ├── DelimiterConstants.java
    │          │   ├── ErrorMessages.java
    │          │   ├── InputMessages.java
    │          │   └── OutputMessages.java
    │          ├── controller
    │          │   └── CalculatorController.java
    │          ├── model
    │          │   ├── Delimiter.java
    │          │   ├── Number.java
    │          │   ├── Numbers.java
    │          │   └── OriginalInput.java
    │          ├── utils
    │          │   ├── NumberUtils.java
    │          │   └── StringSplitter.java
    │          └── view
    │              ├── InputView.java
    │              └── OutputView.java
    └── test
        └── java
            └── calculator
                ├── ApplicationTest.java
                ├── model
                │   ├── DelimiterTest.java
                │   ├── NumberTest.java
                │   └── NumbersTest.java
                ├── MyApplicationTest.java
                └── utils
                    ├── NumberUtilsTest.java
                    └── StringSplitterTest.java
```