# 1. 프로젝트 개요
### 1.1 프로젝트 이름
- 문자열 **덧셈** 계산기
  
### 1.2 프로젝트 설명
- 입력한 문자열에서 숫자를 **추출**하여 더하는 계산기

---

# 2. 구현할 기능
### 2.1 입력 문구 출력 기능
- 사용자에게 덧셈할 문자열을 입력하라는 안내 문구를 출력합니다.
  - 예시 : "덧셈할 문자열을 입력해 주세요."

### 2.2 사용자 입력 기능
- camp.nextstep.edu.missionutils.Console 클래스를 사용하여 사용자로부터 숫자를 **입력** 받습니다.
- 입력한 문자열을 **반환**

### 2.3 입력값 유효성 검사 기능
- 기본 구분자 : 쉼표(,) 또는 콜론(:)
- 커스텀 구분자 형식 : //**문자**\n (예 : **//**;**\n** -> 이때 구분자는 ;)
- 예외 발생 조건
  - 기본 구분자 입력 예외 : 쉼표(,) 또는 콜론(:)외의 문자 사용 시 예외 발생
  - 커스텀 구분자 형식 예외 : 형식이 잘못된 경우 (예 : **/**;**\n**) 예외 발생
  - 숫자가 아닌 값 입력 : 입력값이 숫자가 아닐 경우 예외 발생
  - 음수 입력 오류 : 입력한 숫자가 **양수**가 아닌 경우 (예 : -1,2,3)
- 반환 : 구분자를 기준으로 분리된 입력 숫자들의 **리스트**를 반환

### 2.4 덧셈 결과 계산 기능
- 구분자를 기준으로 분리된 입력 숫자들의 리스트를 기반으로 **덧셈 결과**를 계산하는 기능
- 반환 : 계산된 총합을 **문자열** 형태로 반환

### 2.5. 결과 출력 기능
- 사용자에게 입력한 숫자들의 덧셈 결과를 보여주는 문구를 출력합니다.
  - 예시 : "결과 : 6"
---

