# java-calculator-precourse
입력한 문자열에서 숫자를 추출하여 더하는 계산기

## 📌 구현할 기능 목록
- [x] "덧셈할 문자열을 입력해 주세요." 문자를 출력한다. 
- [x] 문자열을 입력받는다.
- [x] 커스텀 구분자가 있는 경우 커스텀 구분자를 추출한다.
- [x] 입력받은 문자열을 기본구분자(쉼표, 콜론)와 커스텀 구분자 기준으로 분리한다.
- [x] 잘못된 문자열을 입력한 경우 예외 처리를 한다.
    - [x] 기본구분자, 커스텀 구분자 지정, 숫자 외에 다른 문자열이 입력된 경우
- [x] 구분자를 기준으로 분리한 각 숫자의 합을 계산한다.
- [x] 결과를 출력한다.


## 📂 프로젝트 구조 설계
```plaintext
calculator/
 ├── Application.java           # 애플리케이션 시작
 ├── calculator/                
 │    ├── Calculator.java       # 계산기 로직 처리
 │    ├── Input.java            # 입력값과 구분자 처리
 │    └── StringParsing.java    # 문자열 파싱 기능
 ├── io/ 
 │    ├── InputString.java      # 사용자 입력 기능
 │    └── OutputResult.java     # 결과 출력 기능
 └── exception/                
      └── ValidateInput.java    # 입력값 검증 및 예외 처리
```
