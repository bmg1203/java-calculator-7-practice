# java-calculator-precourse
구현 기능 목록 by. hmlssghm
***
>1. 입출력 
>2. 계산 기능

## 1. 입출력
### 1.1. 입력 💋
- 예외처리
  - 기존 구분자 & 커스텀 구분자 외의 구분자가 입력될 경우
  - 커스텀 구분자를 문자열 맨 앞에 안 쓸 경우
### 1.2. 출력 💬
- `덧셈할 문자열을 입력해 주세요.`
- `결과 : `

## 2. 계산 기능 🧮
- 전처리
  - 숫자로 시작할 경우: 숫자/구분자(숫자 외 모든것)로 분리
  - `/`로 시작할 경우: 커스텀 구분자 저장 후 `\n` 이후의 문자열 숫자/구분자로 분리
  - 분리할 때 "숫자 - 숫자 외 모든것" 바뀌는 지점 기준으로 분리.
- 구분자를 기준으로 숫자 저장
- 저장한 숫자를 모두 더하기
- 결괏값을 반환

***
### 🤔기능요구 사항을 읽으며 생긴 의문들..
**Q1. 커스텀 구분자는 일회성인지? 다회성인지?**   
A. DB도 없고, 한번의 실행마다 종료되므로 일회성이다.   

**Q2. 잘못된 값 입력은 어떤 식으로, 어떤 형태로 입력될까?**   
A. <1.1. 예외처리> 참고   

**Q3. 아무것도 입력 안하면 응답은?**   
A. 0   

**Q4. 매 실행마다 프로그램 종료하면 되나? 방법은?**   
A.   

**Q5. 커스텀 구분자는 단일한 문자로 이뤄져야만 하나?**    
A.   

**Q6. 커스텀 구분자는 문자라고 하였으니, 영어+한글+특수문자 라고 생각해야하나?   
특수문자는 어느 범위까지?(키보드에 있는 것만?)**   
A.