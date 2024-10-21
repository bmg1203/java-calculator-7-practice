# java-calculator-precourse


## 구현할 기능 목록

- **사용자 입력 처리**:  
  사용자가 입력한 문자열을 구분자를 기준으로 나눠 문자열 배열에 저장합니다.  
  기본 구분자는 `","`, `":"`이며, 커스텀 구분자는 문자열의 앞부분 `"//"`와 `"\n"` 사이에 위치한 문자입니다.

- **문자열 배열 변환**:  
  문자열 배열을 정수형 배열로 변환하며, 공백은 `0`으로 처리됩니다.

- **음수 처리**:  
  음수를 입력할 경우 `IllegalArgumentException`을 발생시키며 프로그램을 종료합니다.

