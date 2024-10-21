# java-calculator-precourse

---

# 구현기능목록

## [Class] 구분자 추출기

구분자는 기본 구분자와 커스텀 구분자 두 가지로 구성된다. 구분자 추출기는 문자열이 어떤 구분자를 사용했는지 확인하는 데 사용된다.

- [ ]  [Method] extractDelimiter()
    - 구분자가 무엇인지 찾는 역할
        - 커스텀 구분자를 사용하지 않았다면 기본 구분자로 리턴

## [Class] 숫자 추출기

숫자 추출기는 구분자를 기준으로 문자열에서 숫자들을 추출한다.

- [ ]  [Method] isCustomDelimiterUsed()
    - 커스텀 구분자를 사용했는지 확인

- [ ]  [Method] trimInputString()
    - 커스텀 구분자를 사용했다면 커스텀 구분자를 정의하는 문자열을 잘라주기 위하는 용도로 사용

- [ ]  [Method] extractNumbers()
    - 입력받은 문자열에서 구분자를 기준으로 숫자들을 추출하는 역할

## [Class] 문자열 파싱기

문자열 파싱기는 `구분자 추출기`와 `숫자 추출기`를 통해서 입력받은 문자열을 처리하는 역할을 한다.

- [ ]  [Method] parseString()
    - 입력 받은 문자열에서 숫자들을 추출하는 역할

## [Class] 덧셈 계산기

덧셈 계산기는 `문자열 파싱기`를 통해서 숫자들을 추출하고 추출한 숫자들을 더하는 용도로 사용된다.

- [ ]  [Method] sum()
    - 입력받은 문자열에서 숫자들을 추출 후 숫자들을 더하는 용도로 사용된다.

## [Class] 화면

입력받은 문자열과 실행결과를 출력하기 위한 용도로 사용된다.

- [ ]  [Method] displayInput()
    - 덧셈을 할 문자열을 입력받는 역할

- [ ]  [Method] displayInputResult()
    - 입력한 문자열을 출력해주는 역할

- [ ]  [Method] displayOutputResult()
    - 결과를 출력해주는 역할