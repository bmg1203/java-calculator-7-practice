# 프로그래밍 요구 사항

- [x] java -version 을 실행하여 Java 버전이 21인지 확인한다.
- [x] 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] ./gradlew clean test 명령을 실행하고 BUILD SUCCESSFUL in 0s 터미널 창이 뜨는지 확인한다.


## 기능 요구사항
- [x] 기본 구분자 외에 커스텀 구분자를 지정할 수 있다.
  - [x] 문자열 앞부분 "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [x] 입력한 문자열에서 숫자를 추출한다.
  - [x] 구분를 하기위한 값를 구한다.
  - [x] 기본 구분자로만 숫자를 추출한다.
  - [x] 커스텀 구분자와 기본구분자를 사용해 숫자를 추출한다.
- [x] "" 은 0으로 계산해야한다.
- [x] 추출한 숫자의 합을 계산한다.
  - [x] 커스텀 구분자를 사용한 경우에 대한 합을 구한다.
  - [X] 커스텀 구분자를 사용하지않고 기본 구분자를 사용한 경우에 대한 합을 구한다.

# 개발 구현 목록

## 입력

- [x] 문자열를 포함한 숫자 입력
  - [x] 구분자를 함께 숫자를 입력받는다. ( , 와 :은 기본 구분자이다)
  
```java
"" => 0,
"1,2" => 3
"1,2,3" => 6
"1,2:3" => 6
```

- 예외처리 

```java
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고 프로그램을 종료시킨다.
```
- [x] 빈칸을 입력한 경우.
- [x] 숫자외에 다른 입력값이 입력 되었을 경우.
- [x] 숫자를 음수로 입력 받을 경우.
- [x] 커스텀을 하지않았는데 기본 문자열 외에 문자열이 존재할경우
- [x] 커스텀 구분자의 구분자가 아닌 다른 값이 있을경우.

## 커스텀 구분자

```java
//;(커스텀구분자)\n1;2;3
```
- [✓] "//@(커스텀구분자)\n" 를 이용하여 커스텀 구분자를 입력 받을수 있다.
  - [✓] 커스텀 구분자를 사용하는지 체크한다.
  

- 예외처리

```java
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고 프로그램을 종료시킨다.
```
- [x] 커스텀 구분자에 숫자가 들어가는 경우.
- [x] 커스텀 구분자에 빈칸이 들어가는 경우.
- [] 커스텀 구분자의 시작이 //이 아닌경우.
- [] 커스텀 구분자의 끝이 \n 이 아닌경우.

## 구분자 결과

- [x] 사용자가 사용하는 구분자를 생성한다.


## 문자열과 숫자가 합쳐진 공식

- [x] 사용자의 입력값에 구분자 및 커스텀 구분자가 있는지 확인한다.
  - [x] 커스텀 구분자가 존재하는지 확인한다.
  - [x] 기본 구분자가 있는지 확인한다.

- 예외처리

```java
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고 프로그램을 종료시킨다.
```
- [x] 커스텀 구분자 및 기본 구분자가 사용되지 않을경우

## 사용자의 입력값

- [x] 사용자는 공식에 알맞게 입력해야한다.
  - [x] 공백만 입력하였는지 확인한다.
  - [x] 공백으로 시작하는지 확인한다.


- 예외처리

```java
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고 프로그램을 종료시킨다.
```
- [x] 입력값이 공백으로 시작하는 경우.
- [x] 입력값이 공백일 경우.