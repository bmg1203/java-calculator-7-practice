# java-calculator-precourse

## 기능 목록
- 입력 문자열에서 숫자 추출 및 합산
- 기본 구분자: 쉼표(,)와 콜론(:)
- 커스텀 구분자 지원
- 잘못된 입력에 대한 예외 처리

### 메인 메서드
`Application` : Calculator 인스턴스 생성 및 실행
### 계산기 기능
`Calculator`: 계산기 기능(입력, 검증, 구분자 처리, 계산 및 출력 기능 조합하여 실행)
### 입력 기능
`Input` : 사용자로부터 입력을 받는 기능
### 입력 검증 기능
`InputValidation` : 사용자 입력이 제대로 된 입력인지 검증
#### method1
구분자와 양수로만 이루어져있는지 확인
#### method2
커스텀 구분자의 입력 형식(`//`와 `\n` 사이에 커스텀 구분자)이 제대로 된 입력인지 확인
### 커스텀 구분자 확인하기
`CustomDelimiter` : 입력 문자열에서 커스텀 구분자를 추출하는 기능
### 구분자 기준 숫자 나누기
`Parser`: 입력 문자열에서 구분자를 처리하고, 숫자를 분리
### 나눈 숫자들의 합 더하기
`Adder` : 구분자 기준으로 분리된 정수들의 합을 연산하는 기능
### 결과 출력 하기
`Output` : 최종 연산 결과를 출력하는 기능