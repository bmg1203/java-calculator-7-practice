# java-calculator-precourse

## 1주차 - 문자열 덧셈 계산기

## 🎯 목표
1. `개발 환경 적응`
   - 이전 버전과 JDK 21의 차이를 학습한다.
   - 프리코스를 위한 개발 환경에 익숙해진다.
2. `좋은 개발 습관 만들기`
   - 자바 코드 컨벤션을 지킨다.
   - 커밋 메시지 컨벤션 및 커밋 단위를 지킨다.
   - 학습한 것, 고민한 것은 모두 문서화한다.
   - 요구 사항을 모두 지킨다.
   - 도메인 로직 구현 후 테스트 코드를 통해 검증한다.
3. `그 외`
   - 기능 목록을 정확히 도출하고 개발을 시작한다.
   - 요구 사항에 기재되지 않은 것에 대한 기준을 정한다.
   - 네이밍을 통해 의도를 분명히 나타낸다.
   - 객체지향적인 코드를 작성하기 위해 고민한다.
      - 예외 처리의 책임은 누가, 어떻게 할 것인지 고민한다.
      - getter, setter 사용을 지양하고, 메시지를 던지도록 한다.
---

## 🚀 기능 목록
### 1. 숫자 기능
- [X] 하나의 숫자를 가진다.
- [X] 한 개 이상의 숫자를 가진다.
- [X] `예외 사항` : 숫자 형식이 아닌 경우 예외가 발생해야 한다.
- [X] `예외 사항` : 음수라면 예외가 발생해야 한다.
- [X] `예외 사항` : 힌 숫자의 자릿수가 30을 초과하면 예외가 발생해야 한다.
- [X] `예외 사항` : 총 숫자의 갯수가 30개를 초과하면 예외가 발생해야 한다.

### 2. 계산기 기능
- [X] 숫자의 합을 계산한다.

### 3. 구분자 추출 기능
- [X] 정해진 규칙에 따라 커스텀 구분자를 추출한다.
- [X] `예외 사항` : 커스텀 구분자가 숫자라면 예외가 발생해야 한다.
- [X] `예외 사항` : 커스텀 구분자가 기본 구분자와 중복되면 예외가 발생해야 한다.
- [X] `예외 사항` : 커스텀 구분자 지정을 위한 문자가 `//`, `\\n`가 아니라면 예외가 발생해야 한다.
- [X] `예외 사항` : 커스텀 구분자가 하나의 문자가 아니라면 예외가 발생해야 한다.

### 4. 문자열 처리(파싱) 기능
- [X] 커스텀 구분자가 없다면, 기본 구분자인 쉼표(,) 또는 콜론(:)을 기준으로 문자열을 파싱한다.
- [X] 커스텀 구분자가 있다면, 기본 구분자와 커스텀 구분자를 기준으로 문자열을 파싱한다.
- [X] 파싱한 문자열을 숫자로 변환한다.
- [X] `예외 사항` : 구분자가 연속으로 존재하면 예외가 발생해야 한다.

### 5. 입력 기능
- [X] 사용자로부터 문자열을 입력 받는다.

### 6. 출력 기능
- [X] 시작 메시지를 출력한다. : `덧셈할 문자열을 입력해 주세요.`
- [X] 덧셈 결과를 출력한다. : `결과 : {덧셈 결과}`

### 7. 공통 기능
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.

---

## 🔎 고민한 점
### 1) 추가 요구 사항
> 요구 사항에 명확히 기재되어 있지 않은 조건들이 꽤 많다고 판단.<br>
> 미션 진행 방식에 따라 스스로 기준을 정하고, 예외 처리 로직에 많은 고민을 함<br>
> 아래는 미션을 진행하며 추가해본 요구 사항
- 입력한 숫자는 최대 30 자릿수를 초과하면 안 된다. (숫자 하나, 숫자를 더한 결과 포함)
- 입력한 숫자는 최대 50 개를 초과하면 안 된다.
- 입력한 숫자는 중복을 허용한다.
- 구분자는 숫자를 제외한 문자만 허용한다.
- 커스텀 구분자를 지정하면, 기본 구분자를 무시하지 않고 추가로 적용한다.
---
### 2) 숫자의 자료형
> 요구 사항에 숫자에 대한 범위가 기재되어 있지 않아, 범위를 정해야한다고 판단.<br>
> 자료형에 따라 표현 가능한 숫자의 범위가 다르므로, 처음엔 문자열로 처리하는 Biginteger 사용 고려.<br>
> 하지만 작은 숫자를 계산할 땐 메모리 낭비가 될 수 있으므로, 숫자 범위에 따라 자료형을 다르게 저장하는 방법을 고민.
---
### 3) getter, setter
> 개인적인 목표로 getter, setter를 사용하지 않고 객체간 메시지로 데이터를 전달해야겠다고 생각.<br>
> 예를 들어 계산기는 숫자의 내부 로직을 몰라도 `plus` 메서드만으로 덧셈을 수행할 수 있음.<br>
> 숫자의 값을 직접 가져오지 않아 값을 변경할 수 없고, 이는 불변성을 보장함.<br>

```java
    public static Number calculateSum(Numbers numbers) {
        Number sumResult = Number.zero();
        for (int index = 0; index < numbers.size(); index++) {
            sumResult.plus(numbers.findByIndex(index));
        }
        return sumResult;
    }
```
---
### 4) Wrapper 클래스, 일급 컬렉션
> 해당 미션에서 '숫자'의 개념이 가장 중요하다고 생각.<br>
> 숫자를 의미있게 사용하기 위해 단순 원시 자료형이 아닌, 도메인 로직을 포함한 래퍼 클래스로 구현<br>
> 비즈니스 로직을 캡슐화하고, 검증 로직을 추가해 객체 상태를 안전하게 유지할 수 있음
> 클래스명을 통해 특정 규칙을 가진 숫자라는 것을 명확히 알 수 있음

```java
public class Number {

    private static final int MAX_NUMBER_DIGITS = 30;

    private BigInteger value;

    private Number(BigInteger value) {
        validate(value);
        this.value = value;
    }
// ...
}
```
```java
public class Numbers {

    private static final int MIN_INDEX = 0;
    private static final int MAX_NUMBER_DIGITS = 30;

    private final List<Number> values;

    private Numbers(List<Number> values) {
        validateNumberCount(values.size());
        this.values = values;
    }
// ...
}
```
---
### 5) 정적 팩토리 메서드 패턴
> 상황에 따라 인스턴스를 반환하는 로직이 필요하여 정적 팩토리 메서드 패턴을 적용<br>
> of(), from(), zero(), emtpy() 등 메서드명을 통해 어떤 인스턴스인지 나타냄<br>

```java
    // Number.class
    public static Numbers empty() {
        return new Numbers(Collections.emptyList());
    }

    public static Numbers of(List<Number> values) {
        return new Numbers(values);
    }
```
```java
    // Numbers.class
    public static Number zero() {
        return new Number(BigInteger.ZERO);
    }

    public static Number from(String value) {
        try {
            return new Number(new BigInteger(value));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 숫자 형식입니다.");
        }
    }
```