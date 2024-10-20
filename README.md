# java-calculator-precourse

***

## 1. 가산 기능

- ### ☑ 더하기 기능
    - 입력값 형식: ArrayList<Integer>
    - 반환값 형식: int
    - 설명: 정수 리스트를 입력 받으면 그 값들의 합을 정수로 반환한다.

- ### ☑ 숫자, 구분자 분리 기능
    - 입력값 형식: String
    - 반환값 형식: ArrayList<String>
    - 설명: 문자열을 구분자를 기준으로 파싱하여 ArrayList로 반환한다.

- ### ☑ 숫자 판별 기능
    - 입력값 형식: String
    - 반환값 형식: boolean
    - 설명: 문자열이 숫자 문자열인지 아닌지 판별한다.

- ### ☑ 구분자 문자열 판별 기능
    - 입력값 형식: String
    - 반환값 형식: boolean
    - 설명: 문자열이 구분자인지 아닌지 판별한다.

- ### ☑ 입력값 유효성 판별 기능
    - 입력값 형식: ArrayList<String>
    - 반환값 형식: boolen
    - 문자열을 숫자와 구분자로 분리한 ArrayList가 입력값에 위배되지 않는지, 계산이 가능한지 판별한다.

- ### ☑ 숫자 추출 기능
    - 입력값 형식: ArrayList<String>
    - 반환값 형식: ArrayList<Integer>
    - 설명: 숫자와 구분자가 들어있는 ArrayList를 정수만 들어있는 ArrayList로 추출하여 반환한다.

- ### ☑ 양수 판단 기능
    - 입력값 형식: ArrayList<Integer>
    - 반환값 형식: boolean
    - 설명: 정수 ArrayList가 모두 0 이상인 정수인지 판별한다.

- ### ☑ 계산 문자열 더하기 기능
    - 입력값 형식: String
    - 반환값 형식: int
    - 설명: 계산할 문자열을 입력 받으면 계산이 가능 한지 판단한 뒤, 계산 결과를 반환 한다.

***

## 2. 구분자 기능

- ### ☑ 커스텀 구분자 추출 기능
    - 입력값 형식: String
    - 반환값 형식: Character
    - 설명: 문자열에서 커스텀 구분자를 추출하여 반환한다.

- ### ☑ 커스텀 구분자 저장 기능
    - 입력값 형식: char
    - 반환값 형식: void
    - 설명: 커스텀 구분자를 구분자 목록에 추가한다.

- ### ☑ 커스텀 구분자 지정 문자열 판별 기능
    - 입력값 형식: String
    - 반환값 형식: boolean
    - 설명: 커스텀 구분자를 지정하는 문자열이 있는지 판별한다.

- ### ☑ 커스텀 구분자 지정 문자열 자르기 기능
    - 입력값 형식: String
    - 반환값 형식: String
    - 설명: 구분자 지정 구역 문자열과 계산 문자열을 나누어서 계산 문자열만 반환한다.

- ### ☑ 커스텀 구분자 추출 및 저장 기능
    - 입력값 형식: String
    - 반환값 형식: void
    - 설명: 문자열에서 커스텀 구분자를 추출한 뒤 구분자 목록에 저장한다.

***