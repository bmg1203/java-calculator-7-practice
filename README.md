# java-calculator-precourse

< 구현할 기능 목록 >

[ View ]

- [x] 문자열을 입력받는 기능 -> InputView.java
- [x] 결과를 출력하는 기능 -> OutputView.java

[ Domain ]

- [x] 문자열에서 숫자를 추출하는 기능 -> Extractor.java
    - [x] 문자열에 음수가 포함된 경우 예외처리
    - [x] 숫자가 아닌 문자가 포함된 경우 예외처리
    - [x] 커스텀 구분자를 형식에 맞게 입력하지 않은 경우 예외처리
- [x] 추출된 숫자의 합을 구하는 기능 -> Calculator.java

[ Tool ]

- [x] 구분자를 따로 관리 하는 기능 (유지보수 및 확장성 고려) -> Delimiters.java

[ Test ]

- [x] test case 추가

[ Message ]

- [x] 입,출력 메시지 클래스로 분리 -> ViewMessage.java
- [x] 에러 메시지 클래스로 분리 -> ErrorMessage.java
