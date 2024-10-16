# java-calculator-precourse

## 💪 프로젝트 개요

입력한 문자열에서 숫자를 출력하여 더하는 계산기 구현

- 쉼표 또는 콜론을 구분자로 가지는 문자열 일 경우 구분자를 기준으로 합을 구함
- 기본 구분자 외에 커스텀 구분자 사용 가능
    - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
    - 예) "//;\n" -> 커스텀 구분자는 :
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 시킨후 애플리케이션 종료

## 🖌️구현할 기능 목록

### 계산기 문구 출력 기능

- [X] 계산기 시작 문구 상수화
- [X] 계산기 결과 문구 상수화
- [X] 시작 문구 출력
- [X] 결과 문구 출력

### 계산기 입력 기능

- [X] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 숫자를 입력받고 문자열을 반환하는 메서드 구현

### 계산 기능

- [ ] Vector<Integer>에 있는 값을 모두 더함
- [ ] 비어 있을 경우 모든 합은 0

### 문자열 파싱 기능

- [X] 기본 구분자 상수화

- [X] 커스텀 구분자 기준 문자열 상수화

- [X] 문자열 파싱 후 숫자로 전환
    - 기능
        - [X] 파싱할 문자열을 기준으로 입력한 문자열을 파싱
        - [X] 파싱한 문자열을 Integer로 변환
        - [X] 각 문자열을 List<Integer>에 담아 리턴
        - [X] 문자열 중 구분자가 기존에 설정한 구분자 중에 있는지 확인하는 메서드
    - 예외
        - [X] 모든 수는 양수(구분자가 -가 아닌 이상 - 붙으면 예외 발생)
        - [X] 커스텀한 구분자가 아닌 다른 구분자를 사용할 경우 예외 발생


- [X] 입력된 문자에서 구분자를 파싱
    - 기능
        - [X] 커스텀 구분자를 List<Character>에 담아 리턴


- [X] 사용자가 입력한 문자열에 커스텀 구분자가 있는지 확인하는 메서드
    - 커스텀 구분자가 있는 경우
        - [X] 커스텀 구분자를 사용할 경우 "//" 와 "\n" 가 있어야함 -> 하나만 있는 경우 예외 발생
        - [X] "//" 와 "\n" 둘 다 없는 경우 false
        - [X] "//" 와 "\n" 둘 다 있는 경우 true
        - [X] "//"의 위치가 문자열 앞부분이 아닌 경우 예외 발생, 위치는 무조건 0

- [X] 커스텀 구분자가 있을 시에 커스텀 구분자를 설정한 문자열을 제외하고 순수 문자열을 추출하는 메서드