# java-calculator-precourse

## 학습 목표
* Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
* 교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.




## 기능 요구 사항
> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예: "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


### 입출력 요구 사항
#### 입력
- 구분자와 양수로 구성된 문자열
#### 출력
- 덧셈 결과:


#### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.  
1,2:3  
결과  
6
```


## 기능 목록
> #### 조건 : 커스텀 구분자 안에는 "//", "\n" 가 구분자로 활용될 수 없다고 가정한다.
 - 예: "//\n\n", "////\n" => 커스텀 구분자로 사용 불가능  


**1. camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 문자열 입력 받기**  


**2. 기본 구분자(, or :)를 구분자로 가지는 문자열에서 숫자 추출**  
 - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6  


**3. 기본 구분자 외에 커스텀 구분자를 가지는 문자열에서 숫자 추출**  
*문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용*  
 - 예: "//;\n1;2;3" => 커스텀 구분자는 세미콜론(;)으로, 6을 반환  


**4. 추출한 숫자 더하기**  


**5.예외처리**  
*사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료*
- 커스텀 구분자를 선언하지 않고 활용하는 경우
- 공백이 있는 경우
- 문자열이 숫자 or "//" or 구분자로 시작하지 않는 경우
  - 예: "," => 0, "1;2;3", "a", " " => 예외처리
