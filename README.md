# 🐣문자열 덧셈 계산기
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ✅ 기능 목록
**사용자에게 문자열 입력**
  - [X] 가이드 문구 출력한다.
  - [X] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용

**구분자로 숫자 추출 후 계산**   
  - [X] 기본 구분자(쉼표`,` , 콜론`:`)으로 분리한다.
  - [X] "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - [X] 구분자를 사용해 문자열을 나눈다.
  - [X] 나눈 문자열을 숫자로 변환 후 합을 출력한다.

**입력 예외처리 (`IllegalArgumentException`)**
  - [X] 입력한 숫자가 음수를 포함할 때 예외로 처리한다.
  - [X] 구분자가 두 개 연속으로 나오면 예외로 처리한다.
  - [X] 구분자가 숫자면 예외로 처리한다.