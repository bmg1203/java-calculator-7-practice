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

- [ ] 숫자외에 다른 입력값이 입력 되었을 경우.
- [ ] 숫자를 음수로 입력 받을 경우.
- [ ] 커스텀을 하지않았는데 기본 문자열 외에 문자열이 존재할경우

## 커스텀 구분자

```java
//;(커스텀구분자)\n1;2;3
```
- [ ] "//@(커스텀구분자)\n" 를 이용하여 커스텀 구분자를 입력 받을수 있다.


- 예외처리

```java
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 를 발생시키고 프로그램을 종료시킨다.
```

- [ ] 문자외에 다른 입력값이 입력 되었을 경우.

## 기능 요구사항

- [ ] 입력한 문자열에서 숫자를 추출한다.
- [ ] 구분자로 숫자를 구분해야한다.
- [ ] 기본 구분자 외에 커스텀 구분자를 지정할 수 있다.
  - [ ] 문자열 앞부분 "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- [ ] "" 은 0으로 계산해야한다.
- [ ] 추출한 숫자의 합을 계산한다.