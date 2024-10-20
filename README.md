# java-calculator-precourse

입력한 문자열에서 숫자를 추출하여 더하는 계산기

## 기본 설계

### 클래스

- `Calculator` : 입력한 문자열에서 숫자를 추출하여 더하는 계산기의 메인 클래스
- `Parser` : 사용자 입력을 파싱하는 클래스
- `DelimiterManager` : 구분자를 관리하는 클래스

## 구현 기능

### Calculator

- `readInput()` : 입력 값을 받아 해석하고 처리합니다.
- `sum()` : 숫자형 문자의 값을 더합니다.
- `add()` : 지금까지 합산한 값에 인자로 들어온 값을 더합니다.
- `displayPrompt()` : 상수로 지정한 프롬프트 메시지를 출력합니다.
- `printSum()` : 지정한 형식으로 결과값을 출력합니다.

### Parser

- `parseString()` : 입력된 문자열이 유효한 문자열인지 검사히고 문자열을 재조립합니다.
- `removeDelimiterPrefix()` : 해당 문자열이 커스텀 구분자 정의 문자열로 시작하는지 확인하고 삭제합니다.
- `removeDelimiterSuffix()` : 해당 문자열이 커스텀 구분자 정의 문자열로 끝나는지 확인하고 삭제합니다.

### DelimeterManager

- `addDelimeter()` : 기존의 구분자(",", ":")에 커스텀 구분자를 더합니다.
- `isDelimiterLimitExceeded` : 구분자의 최대 개수를 초과하는지 확인합니다.
- `isDelimiterExists` : 이미 존재하는 구분자("," 또는 ":")인지 확인합니다.
- `isDelimiters` : 매개변수 c가 구분자인지 확인합니다.