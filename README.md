# java-calculator-precourse

# 문자열 덧셈 계산기

## 기능 요구 사항
 - 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
   - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
 - 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
   - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
 - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 입출력 요구 사항

입력
- 구분자의 양수로 구성된 문자열
출력
- 덧셈 결과

~~~
결과 : 6
~~~

실행결과 예시
~~~
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
~~~

## 기능 구현 목록

 - [x] 사용자 입력 기능 구현
   - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
 - [x] 커스텀 구분자 유무 검증 기능 구현
   - 입력된 문자열에 커스텀 구분자가 있는지 확인한다.
   - 커스텀 구분자가 올바른 형식으로 입력되었는지 확인한다.
 - [x] 문자열 파싱
   - 구분자 단위로 숫자 분리
 - [ ] 파싱된 문자 검증
   - 커스텀 구분자, (,), (:) 이 외의 문자가 있는지 확인
   - 숫자가 양수인지 확인 음수인 숫자가 들어오면 안된다.
   - 숫자 범위 검증 int 자료형의 범위를 벗어나면 안된다.
 - [ ] 계산기 기능 구현
   - 숫자 합 계산
 - [ ] 출력

## 나만의 체크 포인트

### 입력되는 숫자와 숫자 합의 범위는 int 자료형의 최대 범위로 제한한다.
 - 이유 : 숫자에 대한 범위를 두지 않는다면 숫자가 무한정 입력되는 경우에 예상치 못한 에러가 발생할 수 있다.
### 커스텀 구분자는 숫자는 들어올 수 없다.
 - 이유 : 구분자는 숫자를 구분하기 위한 문자이다. 따라서 숫자와 헷갈려 사용자가 불편할 만한 사항은 만들지 않는다.
 - 예시 : "//1\n1111111" => 불가능 사용자가 의도한 1+1+111 과 다른 결과가 나올 수 있다.
### 커스텀 구분자의 길이는 1로 제한 한다.
 - 이유 : 
   - 기능 요구사항을 살펴보면 ("//"와 "\n" 사이에 위치하는 <span style="color: red;">문자</span> 를 커스텀 구분자로 사용한다.)
   - 문자열이 아닌 문자(Character) 는 하나의 글자를 나타내는 것이기에 길이를 1로 제한 두기로 하였다.
   - 또한 구분자 길이가 길어 사용자가 자신이 입력한 값을 잘 파악 하지 못하면 안된다. 따라서 길이는 1로 제한 한다.
 - 예시 : "//()\n1()2()3" => 불가능

### 고민한점
사용자가 문자열 입력시에 숫자 앞에 +, -부호를 붙이는 것을 허용하는 것을 고민하였다.
~~~
 예시 : "+1,-3,5"
 "+1", "-3" 을 Integer.parseInt() 사용하여 변환하여도 문제 없이 잘 동작한다. 
 그러나 구분자로 +, -가 들어오면 어떨까? 그럼 또다시 구분자 +, - 와 부호 +, - 를 혼용하게 된다.
 
 결론 : 사용자가 문자열 입력시에 부호를 붙일 수 있다. 다만 커스텀 문자열을 생성할때 +, -를 사용하지 못하게 제한한다. 
 그 이유로는 커스텀 구분자에 숫자를 사용할 수 없도록 한 것과 동일하다.
~~~