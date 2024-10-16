# java-calculator-precourse

### 구현할 기능 목록
  - [ ] 구분자 처리
    - [ ] 커스텀 구분자가 존재할 때
      - [ ] 입력 문자열이 "//"로 시작하는 경우, "\n" 이전의 문자를 커스텀 구분자로 설정합니다.
      - [ ] 커스텀 구분자가 설정된 경우 해당 구분자를 포함하여 숫자를 분리합니다.

    - [ ] 커스텀 구분자가 존재하지 않을 때
      - [ ] 쉼표(,)와 콜론(:)을 기준으로 입력 숫자를 분리합니다.
  
  - [ ] 결과 도출
    - [ ] 구분된 숫자의 타입을 정수형으로 변환시킵니다.
    - [ ] 정수형으로 변환 된 숫자들의 합을 출력합니다.

  - [ ] 예외 처리
    - [ ] 입력 문자열이 빈 문자열일 경우, `IllegalArgumentException` 을 발생시킵니다.
    - [ ] 커스텀 구분자가 문자일 경우 
    - [ ] 구분자로 분리된 문자가 양수로 구성된 문자가 아닐 시 `IllegalArgumentException`을 발생시킵니다.

  - [ ] 테스트 코드 작성

### 학습할 목록
  - [ ] `Angular JS Git Commit Message Conventions` 정리
    - 링크: 
  - [ ] 예외 처리에 대한 학습
    - 링크: 
  - [ ] `Console 입력`에 대한 학습
    - 링크:
  - [ ] `String.split()` 메서드에 대한 인자와, 반환값 학습
    - 링크:

### 과제에 대한 고민
1. 커스텀 구분자는 "//"와 "\n" 사이에 위치한 문자이다. "//"와 "\n" 사이에 위치한 문자가 여러 개라면 해당 문자들을 모두 구분자 처리해야 할까?
2. 구분되는 숫자는 정수형이 아닌 양수로 구성이 된다. 만약 커스텀 구분자가 "." 이고 소수 (ex: 2.1)가 들어온다면 어떻게 처리 해야할까?