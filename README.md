# java-calculator-precourse

# 문자열 덧셈 계산기
> 이 프로젝트는 주어진 문자열에서 숫자를 추출하고, 구분자를 기준으로 더하는 계산기를 구현한 것 입니다.             
   
&nbsp;

## 기능 요구 사항
1. 기본 구분자 쉼표(,) 또는 콜론(:)을 이용한 문자열 덧셈
- 쉼표(,) 또는 콜론(:) 을 구분자로 가지는 문자열을 입력하면 구분자를 기준으로 숫자를 분리하고 합계를 반환합니다.
  - ex) "1,2:3" 입력 시 결과는 6
- 입력 값이 비어 있거나 null인 경우 0을 반환합니다.
  - ex) "" 입력시 결과는 0
    
&nbsp;

2. 커스텀 구분자 지정 기능
- 문자열 앞부분에 "//" 와 "\n" 사이에 있는 문자를 **커스텀 구분자**로 지정할 수 있습니다.
  - ex) "//;\n1;2;3" 입력시 세미콜론(;)을 구분자로 사용하여 결과는 6

&nbsp;

3. 잘못된 입력에 대한 예외 처리
- 음수를 포함한 문자열이 입력될 경우 IllegalArgumentException을 발생시킵니다.
  - ex) "-1,2,3" 입력시 예외 발생
- 구분자가 없거나 잘못된 형식으로 입력된 경우 IllegalArgumentException을 발생시킵니다.
  - ex) "123" 입력 시 예외 발생

&nbsp;
&nbsp;


## 입출력 요구 사항
- 입력: 구분자와 양수로 구성된 문자열
- 출력: 덧셈 결과 값

&nbsp;

<실행 결과 예시>
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
