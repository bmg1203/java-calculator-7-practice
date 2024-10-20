# java-calculator-precourse

# 💬 우테코 프리코스 1주차 - 문자열 계산기

**`입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.`**

---

## 📝 기능 요구 사항 정리

- [x] 어플리케이션이 시작되면, `Console.readLine()`을 통해 **구분자**와 **양수**로 구성된 문자열을 입력 받는다.
- [x] 쉼표`(,)` 또는 콜론`(:)`은 기본 구분자로 사용된다.
- [x] **문자열 앞부분**에 `"//"` 와  `"\n"` 사이에 위치하는 문자를 **커스텀 구분자**로 사용할 수 있다.
- [x] 각 구분자를 기준으로 분리된 모든 숫자를 더해 결과값을 출력한다.
- [x] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

## ✏️ 기능 구현 목록

- 입출력 기능
    - [x] `덧셈할 문자열을 입력해 주세요` 라는 문구를 출력한다.
    - [x] `Console.readLine()` 메서드를 통해 사용자의 입력을 받는다.
    - [x] 성공적으로 작업이 수행되면, 결과값을 `결과 : N` 과 같이 사용자에게 출력한다.

- 구분자 판별 및 저장 기능
    - [x] 입력된 문자열 안에 **일반 구분자**인 콜론 `(:)` 과 쉼표 `(,)` 가 존재하는지 확인한다.
    - [x] 입력된 문자열 앞부분에 `"//"` 와 `"\n"` 사이에 위치하는 **커스텀 구분자**가 존재하는지 확인한다.
    - [x] **커스텀 구분자**가 존재한다면, 추가로 저장한다.

- 문자열 처리 기능
    - [x] 사용자가 입력한 문자열을 저장된 구분자를 기반으로 분할한다.
    - [x] 분할된 데이터가 정상적인 데이터인지 확인한다.
    - [x] 정상적으로 최종 분할된 내용을 모두 더해 결과값을 산출한다.

---

## ⁉️ 고려해야할 사항

- [ ] **아무 것도 입력되지 않은 경우**, 결과값은 0으로 출력되어야 한다.
- [x] **구분자 없이 숫자만 입력된 경우**, 숫자 그대로를 출력할 수 있어야 한다.
- [x] 커스텀 구분자로 **숫자**가 설정될 수 있다. (숫자도 문자이다)
- [x] **이스케이프 문자`(\)`** 혹은 **공백(whitespace)** 에 유의해야 한다. (공백도 문자이다)
- [x] 최종 연산 대상에 **음수**는 포함될 수 없지만, 커스텀 구분자에 `(-)` 가 오는 경우는 가능할 수 있다.
- [x] 일반 구분자 보다 **커스텀 구분자의 분리를 우선적으로 진행**한다. (음수, 공백, 숫자 등 특이케이스를 위해)
- [x] 입력되는 양수는 **한 자리 수가 아닌 여러 자릿수**가 입력될 수도 있다.
- [x] 최종 연산 값의 범위가 지정되지 않았기 때문에, 단순 int로 처리되지 못할 수 있다.
- [x] `(+)` 또한 커스텀 구분자로 설정되지 않는다면 사용이 불가해야 한다.
- [x] 커스텀 구분자를 지정하는 곳은 반드시 문자열 맨 앞이어야 한다.
- [x] 문자열 앞 부분에 "//"와 "\n"이 모두 존재하지만, 그 사이가 아닌 곳에 문자가 주어지면 안된다.

---

## 😈 예외 사항
**사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.**
- [x] "//" 와 "\n" 사이의 커스텀 구분자로 콜론(:)과 콤마(,)가 올 수 없다.
- [x] 커스텀 구분자로 **문자** 가 아닌 **문자열** 이 주어질 수 없다.
- [x] 입력되는 숫자에는 음수가 올 수 없다.
- [x] "//" 와 "\n" 사이가 아닌 곳에 숫자와 일반 구분자가 아닌 이외의 문자가 입력될 수 없다.
- [x] 커스텀 구분자로 공백이 설정되지 않는 이상 공백이 사용될 수 없다.

---

## 🖥️ 예시

```markdown
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## 🤔 구현 과정

### 생각 해보기
\#1 여러 번의 분할을 진행할 때, 분할된 모든 경우에 따라 n번의 분할을 계속 반복 하는 방법과 조건문을 통해
더 이상 분할되지 않는다면 따로 관리하는 방법. 어떤 것이 더 좋을지에 대해 고려해보기

\#2 ~~숫자의 범위가 주어지지 않았으므로, 범위에 대한 고민이 필요하다~~

\#3 일반 구분자와 커스텀 구분자의 처리 방식을 하나로 통일하고 싶었는데, 커스텀 구분자의 경우
input을 수정해야 한다는 추가 작업이 필요하여 고민이 되었다.

### 생각 해본 뒤

\#2 -> 지금껏 사용해왔던 Integer나 Long 이외에 BigInteger라는 새로운 개념을 알게 되었다.

\#3 -> 마땅히 다른 방법이 떠오르지 않아 일단 분리를 한 후, json 같은 느낌으로 Map 자료형을 사용하여
처리하였다. 더 좋은 방법이 생각나면 리팩토링을 해야 할 듯 하다.