# java-calculator-precourse
## 구현할 기능 목록
- String getCommand(String)
  - \n을 기준으로 나눈 문자열을 순서대로 반환
  - 더이상 문자열이 없을 경우 null을 반환
- boolean isCommand(String)
  - 구분자 추가 줄과 덧셈할 줄 구분
  - 예외 처리
    - 슬래시 2회, 숫자, 구분자로 시작하지 않는 경우
- void addDelimiter(char) 
  - 구분자 추가
  - 예외 처리
    - 슬래시 2회 이후 줄바꿈이 나올때까지 한글자를 초과할 경우
    - 슬래시 2회 이후 기존에 존재하는 구분자가 나올 경우
- List<String> extract(String)
  - 구분자를 기준으로 숫자 분리
  - 예외 처리
    - 구분자 혹은 숫자를 제외한 글자가 나오는 경우
- String sum(List<String>)
  - 두 숫자를 더함