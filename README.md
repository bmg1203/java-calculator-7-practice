# java-calculator-precourse

## 기능 목록
1. 문자열 덧셈 구하는 기능
   1. 유효성 검증 기능 
      1. 구분자 외 다른 값이 입력 된 경우(커스텀 구분자 포함)
      2. 숫자가 아닌 다른 값이 문자열에 입력된 경우
   2. 문자열 추출 기능
   3. 문자열 더하는 기능


## 기준 정하기

1. 구분자 기준 세우기
- 요구사항에는 `"//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.`라고 적혀있다. 이때 다음과 같은 애매한 부분이 있다. 
  - 구분자를 몇글자까지 허용할지 
  - 구분자에 특수문자를 허용할지
- 제시되는 기준이 없으니 나만의 기준을 세워야 한다 판단 하였다. 기준은 다음과 같다
  - 구분자 글자 제한 없음
  - 특수 문자 허용 X