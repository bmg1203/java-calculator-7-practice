# java-calculator-precourse

# 🚀 미션 간단 설명

---
쉼표나 콜론 또는, 커스텀 구분자를 지정해 문자열을 전달 받고, 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현하는 미션입니다.

## 🔒 제약사항

---
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Java Style Guide를 원칙으로 한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Git Commit Message Conventions]()을 참고해 커밋 메시지를 작성한다.

<hr style="height: 4px; border: none;"/>

# 🛠 구현할 기능 목록

---

- 문자열 덧셈 계산기 시작 함수 생성
- 사용자로부터 입력받는 함수 생성
- 커스텀 구분자("//"와 "\n" 사이에 위치하는 문자)를 지정하는 함수
- 입력한 값이 잘못된 값인지 체크하는 함수 생성(잘못된 값을 입력시 **IllegalArgumentException** 발생)
    - 구분자(쉼표 or 콜론)를 올바르게 사용했는지 확인하는 함수
    - 커스텀 구분자(기존 구분자 제외)를 사용했는지 확인하는 함수
    - 지정한 커스텀 구분자의 형식이 일치하는지 확인하는 함수
    - 구분자를 제외하고 입력받은 문자열이 숫자인지 확인하는 함수
    - 입력받은 숫자가 양수인지 확인하는 함수
    - 빈 문자열인지 확인하는 함수
    - 입력에 공백이 있는지 확인하는 함수
    - 숫자로 끝나는지 확인하는 함수
- 덧셈 결과를 출력하는 함수

<hr style="height: 4px; border: none;"/>

## 📋 구현 체크
***

- [x] 문자열 덧셈 계산기 시작 함수 생성
- [x] 사용자로부터 입력받는 함수 생성
- [x] 커스텀 구분자("//"와 "\n" 사이에 위치하는 문자)를 지정하는 함수
- [x] 입력한 값이 잘못된 값인지 체크하는 함수 생성(잘못된 값을 입력시 **IllegalArgumentException** 발생
    - [x] 숫자 사이에 하나의 구분자만 있는지 확인하는 함수
    - [x] 첫 입력이 숫자인지 확인하는 함수
    - [x] 구분자 외에 다른 문자가 존재하는지 확인하는 함수
    - [x] 문자열 개수로 구분자 외에 다른 문자가 있는지 확인하는 함수
    - [x] 빈 문자열인지 확인하는 함수
    - [x] 입력에 공백이 있는지 확인하는 함수
    - [x] 숫자로 끝나는지 확인하는 함수
- [x] 덧셈 결과를 출력하는 함수


- [x] 모든 테스트 케이스가 성공하는지?
- [x] 자바 코드 컨벤션([Java Style Guide]())을 지켰는지?
---

Resources
Readme
License
MIT license
Activity
Stars
0 stars
Watchers
0 watching
Forks
0 forks
Report repository
Releases
No releases published
Packages
No packages published
Languages
Java
100.0%
Footer
