# java-calculator-precourse


## :skull: 구현할 기능 목록


### 구분자 처리

**구분자**는 과제의 <b><기능 요구 사항></b>에서 주어진 *기본 구분자*와, 특정한 방법으로 전달하는 *사용자 정의 구분자*를 의미합니다.

- [ ] 구분자 검사식에 기본 구분자(`:`, `,`) 포함
- [ ] 구분자 검사식에 `//` ... `\n`으로 전달하는 사용자 정의 구분자 포함
    - 예: `//$\n1$2$3` + <kbd>⏎ Enter</kbd>
- [ ] 구분자 검사식에 `//` ... <kbd>⏎ Enter</kbd> 으로 전달하는 사용자 정의 구분자 포함
    - 예: `//$` + <kbd>⏎ Enter</kbd> + `1$2$3` + <kbd>⏎ Enter</kbd>
- [ ] [Metacharacters](https://www.geeksforgeeks.org/metacharacters-in-java-regex/) 유의하며 처리
  - `Pattern.quote()` 이용
- [ ] 구분자로 적절하지 않은 문자 처리
  - `[0-9]` 처리


### 사용자 입력 식 처리

**사용자 입력 식**은 *숫자와 구분자로 이루어진 문자열*을 의미합니다.
- [ ] 전달받은 구분자로 사용자 입력 식을 분할
  - 분할된 문자열이 비어 있다면 무시
  - 분할된 문자열이 음수 정수를 의미한다면 예외 처리
  - 분할된 문자열에 구분자나 숫자가 아닌 문자가 있다면 예외 처리
- [ ] 음수 부호의 의미로 전달된 `-` 처리.


### 메시지 처리

**메시지**는 콘솔에 표시되는 문자열로, *일반 메시지*와 *예외 메시지*를 의미합니다.

- [ ] `덧셈할 문자열을 입력해 주세요.`
- [ ] `결과 : `
- [ ] 올바른 행동을 유도하는 예외 메시지
  - 예: `음수가 아닌 정수만 입력하세요. 문제가 된 입력: "-3"`