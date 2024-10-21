# java-calculator-precourse

### 구현할 기능 목록
  - [x] 구분자 처리
    - [x] 커스텀 구분자가 존재할 때
      - [x] 입력 문자열이 "//"로 시작하는 경우, "\n" 이전의 문자를 커스텀 구분자로 설정합니다.
      - [x] 커스텀 구분자가 설정된 경우 해당 구분자를 포함하여 숫자를 분리합니다.

    - [x] 커스텀 구분자가 존재하지 않을 때
      - [x] 쉼표(,)와 콜론(:)을 기준으로 입력 숫자를 분리합니다.
  
  - [x] 결과 도출
    - [x] 구분된 숫자의 타입을 정수형으로 변환시킵니다.
    - [x] 정수형으로 변환 된 숫자들의 합을 출력합니다.

  - [x] 예외 처리
    - [x] 커스텀 구분자가 숫자일 경우 `IllegalArgumentException`을 발생시킵니다.
    - [x] 기본 구분자와 커스텀 구분자로 숫자가 분리되어 있지 않을 시 `IllegalArgumentException`을 발생시킵니다.
    - [x] 구분자로 숫자가 올바르게 분리 되어 있지 않을 시 `IllegalArgumentException`을 발생시킵니다.
    - [x] 구분자로 분리된 숫자가 양수가 아닐 시 `IllegalArgumentException`을 발생시킵니다.

  - [x] 테스트 코드 작성

### 학습할 목록
  - [x] `Angular JS Git Commit Message Conventions` 정리
    - 링크: https://jolly-restaurant-d2f.notion.site/Angular-JS-Git-Convention-121b51098aa0818da6cfd307aa725501?pvs=4
  - [x] 예외 처리에 대한 학습
    - 링크: https://jolly-restaurant-d2f.notion.site/Java-121b51098aa0805c8e2eeb4ba6992bfa?pvs=4
  - [x] `Console 입력`에 대한 학습
    - 링크: https://jolly-restaurant-d2f.notion.site/Console-122b51098aa080ccbdd3e4dad1c56d7c?pvs=4
  - [x] `문자열` 정규식 학습
    - 링크: https://jolly-restaurant-d2f.notion.site/String-122b51098aa08077a849dcc4daabe8bf?pvs=4

### 과제에 대한 고민
1. 커스텀 구분자는 "//"와 "\n" 사이에 위치한 문자이다. "//"와 "\n" 사이에 위치한 문자가 여러 개라면 해당 문자들을 모두 구분자 처리해야 할까?
    - "//"와 "\n"사이에 1개 이상의 문자가 들어온다면 모두 구분자 처리를 하는 것으로 규칙을 설정했다.
    - "//[-)=+;'\n" => '[','-',')','=','+',';',''' 가 구분자로 설정
2. 구분되는 숫자는 정수형이 아닌 양수로 구성이 된다. 만약 커스텀 구분자가 "." 이고 소수 (ex: 2.1)가 들어온다면 어떻게 처리 해야할까?
    - 구분자의 '.'이 들어올 경우 해당 구분자를 우선으로 적용하게 규칙을 설정했다.
    - 따라서 '.'이 구분자로 들어올 경우 소수는 입력할 수 없다.

### 과제 구현 과정
    - 링크: https://jolly-restaurant-d2f.notion.site/122b51098aa0803f98d9ee30619d38f8?pvs=4