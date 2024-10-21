# java-calculator-precourse

## 기능 요구 사항

- 입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현
- 기본 구분자: 쉼표(,), 콜론(:)
    - 기본 구분자로 가지는 문자열을 전달할 때 구분자를 기준으로 분리한 각 숫자의 합을 반환
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 커스텀 구분자: 문자열 앞 부분의 "//"와  "\n" 사이에 위치하는 "문자"
    - 문자라 함은 문자열과 다르게 1글자임
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 잘못된 값 입력시: IllegalArgumentException 발생

## 생각해볼 예외상황

### 공통

- 기본, 커스텀 구분자에 포함되지 않은 문자가 들어온 경우
    - 예외처리
- 숫자 값이 없는 경우
    - 구분자로만 이루어져있다면 0 반환

### 커스텀 구분자

- 커스텀 구분자가 1자리 초과인 경우
    - 예외처리
- "//"과 "\n" 사이에 아무 값도 없는 경우
    - 커스텀 구분자 없이 기본 구분자로 계산
- 커스텀 구분자가 기본 구분자 중 하나인 경우
    - 기본 구분자로만 계산
- 커스텀 구분자가 숫자인 경우
    - 해당 숫자를 구분자로? 예외처리?
- 커스텀 구분자가 " "(공백)인 경우
    - 공백을 구분자로 사용

## 1차 구현 기능 (요구사항을 담백하게 구현)

- [x] 테스트코드 작성 (기능 요구 사항 기반)
    -  [x] 기본 구분자만 가진 문자열
    -  [x] 커스텀 구분자를 가진 문자열
    -  [x] 공백 문자열
    -  [x] 잘못된 값이 들어온 경우
- [x] 문자열 입력 기능 구현
- [x] 커스텀 구분자 추출 기능 구현
- [x] 구분자로 숫자를 추출하는 기능 구현
- [x] 추출된 숫자를 더하는 기능 구현
- [x] 결과값 출력 기능 구현

## 2차 구현 기능 (예외사항 처리)

- [x] 빈 문자열 테스트 통과
- [x] 커스텀 구분자 사용 테스트 에러 해결
- [x] 음수 예외처리 테스트 통과

## 3차 구현 (코드 리팩토링)
- [x] 함수 분리
- [x] 주석 추가
- [x] 위험 함수 사용 수정