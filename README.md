# java-calculator-precourse

## 기능 목록

* 전달된 문자열이 비어있는지 확인
* 문자열 앞부분에 "//"와 "\n" 사이에 위치하는 문자가 있는지 확인(커스텀 구분자)
* 커스텀 구분자가 있다면 커스텀 구분자를 기준으로 각 문자 split
* 커스텀 구분자가 없다면 쉼표(,) 또는 콜론(:)을 기준으로 각 문자 split
* 구분자를 기준으로 split한 문자가 양의 정수인지 확인
* 각 숫자의 합 반환