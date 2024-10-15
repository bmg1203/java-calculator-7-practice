# java-calculator-precourse
### 기능 요구사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 구현 기능
- 입출력
  - [ ] 입력 형식 지정 (덧셈할 문자열을 입력해 주세요.)
  - [ ] 출력 형식 지정 (결과 : 숫자)
- 입력 문자열 검증
  - [ ] null, 빈 분자열이면 0을 반환한다.
  - [ ] 잘못된 형식일 경우 IllegalArgumentException을 발생시미고 애플리케이션을 종료시킨다.
- 구분자 분리
  - [ ] 쉼표(,), 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한다.
  - [ ] `"//;\n1;2;3"` 와 같이 커스텀 구분자의 경우, 해당 구분자를 기준으로 분리한다.
- 숫자 추출해 덧셈
  - [ ] 분리된 문자열에서 숫자를 추출해 더한다.

### 테스트
- [ ] null, 빈 문자열 입력 테스트케이스
- [ ] 잘못된 형식 입력 테스트케이스
- [ ] 쉼표(,), 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 테스트케이스
- [ ] 커스텀 구분자가 있는 경우 테스트케이스

### 일정
- [ ] 1일차 : 기능 요구사항 분석 및 구현 기능 정의
- [ ] 2일차 ~ 3일차 : 기능 구현
- [ ] 4일차 : 테스트 코드 작성
- [ ] 5일차 : 피드백 반영, 리팩토링
- [ ] 6일차 : 테스트 코드 실행 후 리팩토링
- [ ] 7일차 : PR 보내기


