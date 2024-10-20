# java-calculator-precourse

## 🌈 기능 목록
### 입력
- [x] 프롬프트 메시지 띄우기
- [x] 문자열 입력 받기

### 계산기
- [x] 커스텀 구분자 추가하기
- [x] 구분자 기분으로 숫자 분리하기
- [x] 문자열 -> 숫자
  - [x] 잘못된 숫자면 `IllegalArgumentException` 발생시키기
  - [x] 양수인지 확인하기
  - [x] 공백 문자 확인하기
- [x] 숫자 계산

### 출력
- [x] 계산기의 결과 출력

---

## 😅 애매해서 생각해 본 내용
### 입력
`구분자와 양수로 구성된 문자열`
- [x] 양수는 실수까지 포함하는 걸까? (Double을 사용해야 할까?)<br>
  -> 양의 정수라는 말이 없으니, 실수까지 포함하는 게 맞는 거 같다.
- [x] 실수일 때, 구분자가 `.`이면? 구분자가 숫자면?<br>
  -> 사용자의 의도에 따라, 구분자로 판단하는 게 맞는 거 같다.<br>
- [x] 공백 문자가 포함되어 있다면, 예외로 처리해야 할까?<br>
  -> 구분자와 양수로만 구성되어야 하므로, 예외로 처리해야 할 거 같다.<br>
      `Integer.parseInt`는 오로지 정수만 파싱하는 반면, `Double.parseDouble`은 `String.trim`의 동작과 비슷하게 공백문자를 그냥 무시하고 파싱한다.<br>
      그렇게, 공백 문자를 처리해야 한다는 결론에 이르렀다...
- [x] ""을 입력으로 주면, `Console.readLine()`에서 `NoSuchElementException`예외가 발생하는데 `IllegalArgumentException`예외를 발생시켜야 할까?<br>
  -> 한 줄을 읽어야 하는데 없어서 그렇다. 터미널에서는 Ctrl+D로 EOF를 줄 경우와 같은 거 같다.<br>
      구글 계산기처럼 아무 값을 입력하지 않으면, 0을 보여주는 게 맞는 거 같다.<br>

### Reference
- https://stackoverflow.com/questions/48669698/difference-in-behaviour-between-double-parsedouble-and-integer-parseint
