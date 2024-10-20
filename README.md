# java-calculator-precourse

### 개요

입력한 문자열에서 숫자를 추출하여 더하는 계산히 구현

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달할 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 기본 구분자 외에 커스텀 구분자 지정 가능
    - 커스텀 구분자 : 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자
- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

### 기능 목록

- [X] `덧셈할 문자열을 입력해 주세요.` 라는 안내 문구 출력
- [X] 사용자로부터 입력 받기 : `1,2:3`
- [X] 커스텀 구분자 존재 여부 확인
    - [X] 커스텀 구분자가 여러 개일 경우 처리
    - [X] 사용자 입력 값에 공백(" ")이 포함되어 있을 경우 처리
- [X] 문자열을 구분자에 따라 분리
- [X] 숫자 합 계산
- [X] 결과 출력 : `결과 : 6`
- [X] 프로그램 종료

### 클래스 다이어그램

![Class Diagram.png](img%2FClass%20Diagram.png)