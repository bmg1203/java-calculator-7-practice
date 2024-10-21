# java-calculator-precourse

## ✔ 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6


- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.


- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

## ✔ 입출력 요구 사항

### 입력

- 구분자와 양수로 구성된 문자열

### 출력

- 덧셈 결과

```
결과 : 6
```

### 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

---

## ✔ 추가적인 요구사항 분석 및 가정

- 구분자 관련
    - 모든 구분자는 단 하나의 문자(= char)로 구성된다.
    - "//"와 "\n" 사이에 여러개의 문자를 입력할 수 있고, 각 문자는 모두 커스텀 구분자로 지정된다.
      <br> 예제) 입력 : `//$#\n1$2#3` 출력 : `6`
    - 커스텀 구분자로 온점(.)을 지정할 수 있고, 이 때 숫자로 소수 입력이 불가능하다.
      <br> 예제1) 입력 : `1.5,2.2` 출력 : `3.7`
      <br> 예제2) 입력 : `//.\n1.5,2.2` 출력 : `10`
    - 커스텀 구분자로 알파벳과 숫자를 지정할 수 없다.
    - 구분자로 지정되지 않은 문자는 잘못된 입력으로 판단한다.


- 숫자(양수) 관련
    - 입력되는 숫자는 양수로 제한되어 있으므로, 단독의 0은 잘못된 입력으로 판단한다.

---

## ✔ 구현할 기능 목록

1. 사용자 입력

- [x] 문자열 입력

2. 입력된 문자열 검사 및 분리

- [x] 커스텀 구분자 지정
- [x] 잘못된 입력 예외 처리
- [x] 구분자를 기준으로 문자열 분리

3. 결과값 생성 및 출력

- [x] 덧셈 연산
- [x] 결과값 출력
