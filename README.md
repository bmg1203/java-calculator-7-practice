# java-calculator-precourse 

## 문자열 덧셈 계산기

## 기능 목록

---

### 1. 문자열 입력
* 입력 : 구분자와 양수로 구성된 문자열

##

### 2. 쉼표 또는 콜론을 구분자로 갖는 문자열의 합 계산
쉼표(,)나 콜론(:)으로 구분된 숫자들을 더하여 합계를 반환한다. 
> 입력 값이 빈 문자열일 경우, 0을 반환한다.
> 
> "1,2,3" 입력 시 결과는 6이 되어야 한다.
> 
> "1,2:3" 입력 시 결과는 6이 되어야 한다.
##

### 3. 커스텀 구분자로 문자열의 합 계산
커스텀 구분자를 사용할 수 있으며, 이는 "//[구분자]\n[숫자 문자열]" 형식으로 제공된다.

> "//;\n1;2;3" 입력 시 구분자는 ;이고, 결과는 6이 되어야 한다.
##

### 4. 결과 출력
사용자가 입력한 문자열의 숫자 합계를 계산하여 출력한다.
* 출력 : 덧셈 결과
    > 결과 : 6
* 실행 결과 예시
    > 덧셈할 문자열을 입력해 주세요. 
    > 
    > 1,2:3
    > 
    > 결과 : 6
##

### 5. 사용자가 잘못된 값을 입력할 경우 예외 처리
IllegalArgumentException 예외를 발생시키고 프로그램을 종료한다.
> 숫자가 아닌 문자 또는 음수가 포함된 경우

#



