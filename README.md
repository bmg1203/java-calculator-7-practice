# java-calculator-precourse


## 🎯목표: 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현
## 미션 조건,이해
- 입력: 구분자와 양수로 구성된 문자열. int타입의 양수, 구분자 이렇게 2가지 타입만 처리하면 된다.
- 입력형식: 입력문자 갯수, "//커스텀 구분자 들\n int와 구분자 조합"
- 구분자: 기본 ','와 ':' 이 있고, 커스텀 여러개 추가 가능
    - 커스텀 구분자가 '문자' 라고 미션에 명시되어 있어 단일 문자로 여러개 처리하기
    - 커스텀 구분자를 ArrayList로 저장하고 사용하자.
- docs 폴더를 만들고 새로 README.md를 만들까 고민중.

## 🚀기능구현 목록
- [X] V. class 생성및 필드 선언
    - class Application -> Main
    - class IOManager -> input, output 처리
    - class Calculation -> 데이터 연산 처리
        - 필드로 ArrayList 타입의 숫자,구분자 만들기
- [X] A. IOManager의 함수 
    - [X] 1. 문자열 입력받기
    - [X] 2. 결과 출력하기
- [X] B. Calculation의 함수
    - ~~[ ] 0. getter, setter~~
    - [X] 1. 입력 받은 문자열 분석하고 필드에 저장하기
        - public void splitInputString(String input)
        - private void checkCustomSperator()
    - [X] 2. 필드 데이터 연산하고, 결과값 리턴하기
        - public int returnAddition()
- [X] C. Exception 처리하기: 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료(exit()함수 사용 불가) 
    - 1. 숫자도 구분자도 아닌 문자의 경우 에러 처리 
    - 2. 입력받은 문자열에 음수가 포함되는 경우(커스텀 구분자가 아닌 정수로 인식될 때)
    - 3. 숫자 범위는 Int로 제한 한다 -> sum의 결과값이 int범위를 넘어서는 경우.

## 환경설정
- Style 폴더를 만들고, Google과 우테코 스타일 파일을 넣었다. Google스타일 적용후 인덴트설정, 열제한(120줄)설정.




#### 아이콘: 📮✏️🎯
