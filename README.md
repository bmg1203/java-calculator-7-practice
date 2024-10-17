# 🔍 문자열 계산기 동작 순서

> 1. **문자열을 입력받는다.**
> 2. **입력받은 문자열에서 숫자를 추출한다.**  
     2-1. 문자열을 ***구분자***를 기준으로 분리한다.  
     2-2. 분리된 문자열들을 숫자로 변환한다.
> 3. **추출한 숫자를 모두 더한다.**
> 4. **더한 결과를 출력한다.**

#### ***구분자***

- 구분자란 문자열을 분리하는 기준이 되는 문자를 뜻한다.
- 구분자에는 기본 구분자, 사용자가 추가하는 커스텀 구분자가 존재한다.
    - 기본 구분자: `,`, `:`
    - 커스텀 구분자: 사용자가 `//` 와 `\n`을 통해 정의한 구분자

# 🚀 기능 목록

## 1. 문자열을 입력받는다.

- [X] 콘솔에 "덧셈할 문자열을 입력해 주세요." 라는 문구를 출력한다.
- [X] 사용자가 입력을 마무리할 때까지 기다린다.
- [X] 사용자는 원하는 문자 1개를 구분자로 추가할 수 있다.
    - 문자열 입력 시 `//` 로 시작한다.
    - 지정하고자 하는 문자를 입력한 뒤 `\n` 을 입력한다.
- [ ] 입력한 문자열은 `//`, `\n`, 구분자, 양수로만 구성되어야 한다.
    - [X] `//`는 문자열의 제일 앞에만 위치할 수 있다.
    - [ ] 문자열이 `//`로 시작했을 때 `\n`는 1번 입력될 수 있다.
    - [ ] 음수가 입력되었지만 구분자가 "-"인 경우는 정상 입력으로 판단한다.
    - [ ] 그 외의 경우, `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.

## 2. 입력받은 문자열에서 숫자를 추출한다.

- [ ] 문자열을 구분자를 기준으로 분리한다.
- [ ] 분리된 모든 문자열들을 숫자로 변환한다.
    - [ ] 변환된 숫자는 `long` 타입에 저장한다.
    - [ ] 변환된 숫자가 `long` 타입의 범위를 넘는 경우, `BigInteger` 타입에 저장한다.

## 3. 추출한 숫자를 모두 더한다.

- [ ] 2단계에서 추출된 숫자를 모두 더한다.
    - [ ] 변환된 숫자 중 `BigInteger`가 존재하면, `BigInteger` 타입에 저장한다.
    - [ ] 더한 결과가 `long` 타입의 범위를 넘는 경우, `BigInteger` 타입에 저장한다.

## 4. 더한 결과를 출력한다.

- [ ] "결과 : " 문자열 뒤에 더해진 결과를 붙여 출력한다.
- [ ] 애플리케이션을 종료한다.
