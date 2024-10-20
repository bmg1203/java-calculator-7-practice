# 문자열 덧셈 계산기

## :computer: 프로그램 소개

사용자가 입력한 문자열에서 숫자를 추출하여 더한 뒤 결과를 출력하는 프로그램

## :pushpin: 기능 목록

* 구분자와 양수로 구성된 문자열 입력받기
    * 아무것도 입력하지 않은 경우 0 출력
    * 숫자가 포함되어 있지 않은 경우 예외 발생 후 종료
    * 0 이하의 숫자가 포함되어 있는 경우 예외 발생 후 종료
    * 기본 구분자나 커스텀 구분자가 아닌 다른 구분자가 포함되어 있는 경우 예외 발생 후 종료
* 기본 구분자가 있는 경우 기본 구분자를 기준으로 문자열 분리하기
* 커스텀 구분자가 있는 경우 커스텀 구분자를 기준으로 문자열 분리하기
* 분리한 문자열을 숫자로 변환하여 모두 더하기
* 결과 출력하기