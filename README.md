
# java-calculator-precourse

## 구현할 기능 목록
- [x] 문자열 입력 받기
- [x] 기본 구분자를 이용한 문자열 처리
- [ ] 커스텀 구분자 확인 및 예외 처리
- [x] 빈 문자열 또는 null 값 처리
- [ ] 음수가 들어올 경우 예외 처리
- [ ] 문자가 들어올 경우 예외 처리
- [x] 결과값 출력 하기

## 생각 해봐야 할 경우들
1. 커스텀 구분자가 여러 개 나와도 되는가?
2. 커스텀 구분자에는 문자 또는 공백이 들어가 있어도 되는가?
3. 기본 구문자 또는 커스텀 구분자만 들어올 경우
4. 숫자만 들어올 경우
5. 덧셈의 크기가 int 를 넘는 경우?


### 기능 요구 사항
1. 쉼표(,) 또는 클론(;)을 구분자로 가지는 문자열 전달 시, 구분자를 기준으로 분리한 각 숫자의 합 반환

    ex) 
    
    `input : ""` => `output : 0`

    `input : "1,2"` => `output : 3`
    
    `input : "1,2;3"` => `output : 6`


2. 쉼표(,)와 클론(;) 이외 커스텀 구분자 지정 가능.

    문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자 : 커스텀 문자열

    ex)

    `input : “//;\n1;2;3”` => `output : 6`


3. 사용자가 잘못된 값 입력 시, `IllegalArgumentException`발생 및 애플리케이션 종료
    
    - 발생하는 경우
      1. 음수가 들어오는 경우
      2. 커스텀 구분자 정의 형식을 만족하지 못하는 경우

### 입출력 요구 사항

입력 : 구분자와 양수로 구성된 문자열

출력 : 덧셈 결과

```
결과 : 6
```

### **실행 결과 예시**

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```
