##  미션 1주차 - 문자열 덧셈 계산기

입력한 문자열에서 **숫자를 추출**하여 더하는 `계산기`를 구현합니다.

###  패키지 목록

```markdown
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── calculator/
│   │   │   ├── ConsoleIO.java
│   │   │   ├── Application.java
│   │   │   ├── CustomDelimiterParser.java
│   │   │   ├── NumberValidator.java
│   │   │   └── StringAdditionCalculator.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── calculator/
│   │   │   └── ApplicationTest.java

```
###  🛠 기능 목록

- [x] 문자열 **입력**
  - [x] 커스텀 구분자 **존재 여부** 확인
    - [x] 존재 시 **구분자 추출 및 기존 구분자에 추가**
  - [x] 문자열 내 구분자(쉼표, 콜론) **분리**
    - [x] 각 분리된 문자열을 순회하며 유효성 체크 및**정수로 변환**
      - [x] 변환 즉시 **합산**
- [x] 계산 결과 출력

- [x] 예외 처리
- [x] 테스트 케이스 작성
- [x] 리팩토링

###  🔍 예외 처리
- [x] 문자열에 **커스텀 구분자만 존재**할 때
- [x] 커스텀 구분자 안이 **비어있을 때**
- [x] 숫자 **범위 초과** (문자 파싱)
- [x] 문자열 **공백**
- [x] 문자열 **맨 앞** "//" 는 존재하지만 "\n"가 존재하지 않을 때
- [x] 커스텀 구분자 없이 **잘못된 구분자**(예:"1.2.3") 사용

###  사용 예제

문자열 계산기는 다양한 구분자를 사용하여 숫자들의 합을 계산합니다. 아래는 다양한 입력 예시와 그에 따른 결과입니다.

```markdown
## 기본 사용법

1. **기본 구분자 사용 (쉼표, 콜론)**
   - 입력: `"1,2:3"`
   - 결과: `6`

2. **단일 숫자**
   - 입력: `"5"`
   - 결과: `5`

## 커스텀 구분자 사용

커스텀 구분자는 `//[구분자]\n` 형식으로 지정할 수 있습니다.

3. **ASCII 문자 구분자**
   - 입력: `"//;\n1;2;3"`
   - 결과: `6`

4. **유니코드 문자 구분자**
   - 입력: `"//가\n1가2가3"`
   - 결과: `6`

5. **이모지 구분자**
   - 입력: `"//🍎\n1🍎2🍎3"`
   - 결과: `6`

6. **혼합 사용 (기본 구분자 + 커스텀 구분자)**
   - 입력: `"//;\n1;2,3:4"`
   - 결과: `10`

## 대규모 입력

7. **많은 수의 숫자 입력**
   - 입력: `"1,2,3,4,5,6,7,8,9,10,11,12,13,14,15"`
   - 결과: `120`

## 예외 처리

계산기는 다음과 같은 경우에 예외를 발생시킵니다:

8. **음수 포함**
   - 입력: `"1,2,-3"`
   - 결과: `IllegalArgumentException ("음수는 허용되지 않습니다: -3")`

9. **숫자가 아닌 문자 포함**
    - 입력: `"1,2,a"`
    - 결과: `IllegalArgumentException ("잘못된 숫자 형식: a")`

10. **잘못된 커스텀 구분자 형식**
    - 입력: `"//\n1,2,3"`
    - 결과: `IllegalArgumentException ("커스텀 구분자는 정확히 하나의 유니코드 문자여야 합니다.")`

11. **커스텀 구분자 후 개행 문자 누락**
    - 입력: `"//;1;2;3"`
    - 결과: `IllegalArgumentException ("커스텀 구분자 지정 후 '\n'이 없습니다.")`

12. **공백만 있는 문자열 입력 시**
    - 입력: `"    "`
    - 결과: `IllegalArgumentException ("입력 문자열이 null이거나 비어 있습니다")`
```
