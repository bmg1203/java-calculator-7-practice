# java-calculator-precourse

## 과제 목표 설정

1. 주어진 요구사항을 분석한 후, 문제를 해결한다.
2. 기본적인 기능 구현이 완료되었다면, **가능한 모든 예외 상황**을 가정하여 완성도를 높인다.
   - 이 과정에서 `TDD`를 학습 및 적용해본다.  
     👉🏻 _기존에 주어진 테스트 코드를 비롯하여 가능한 모든 예외상황을 테스트 코드로 추가 작성하고, 기능 요구사항 리스트를 작성한다._
3. 이 과정을 통해 **테스트 주도 개발**을 적용해보며, **Java 기본 문법**을 익힌다.

## 기능 목록

> 크게 `설계`, `기능 구현`, `예외 처리`로 카테고리를 분류하여 기능을 나열한다.  
> 우선, 설계 및 기본 기능 구현에 집중한 후에 예외 처리에 집중하는 단계로 진행한다.

- [ ] _(설계)_ 객체지향을 고려하여(= 역할을 분리해서) 구조를 설계한다.
- [ ] _(기능구현)_ 계산을 진행할 문자열을 입력받는 기능
- [ ] _(기능구현)_ 입력받은 문자열에서, 쉼표(`,`) 또는 콜론(`:`)을 기준으로 숫자를 더하는 기능
- [ ] _(기능구현)_ 커스텀 구분자 기능
- [ ] _(예외처리)_ 음수는 계산기에서 사용할 수 없다.
- [ ] _(예외처리)_ 커스텀 구분자의 올바른 위치(= 맨 앞)를 검증할 수 있다.
- [ ] _(예외처리)_ 커스텀 구분자의 올바른 형식(= `//`로 시작해서 `\n`으로 끝남)을 검증할 수 있다.
- [ ] _(예외처리)_ 공백 문자는 커스텀 구분자로 설정할 수 없다.
