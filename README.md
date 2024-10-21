# 프리코스 1주차 : 문자열에서 숫자를 추출하여 더하는 계산기

## 과제 진행 요구 사항

- [ ]  미션은 문자열 덧셈 계산기 저장소를 `포크하고 클론`하는 것으로 시작한다.
- [ ]  기능을 구현하기 전 README.md에 구현할 `기능 목록을 정리`해 추가한다.
- [ ]  Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 `추가`한다.
- [ ]  [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 `커밋 메시지를 작성`한다.
- [ ]  자세한 과제 진행 방법은 [프리코스 진행 가이드 문서](https://apply.techcourse.co.kr/assignment/14/mission/43)를 참고한다.

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- [ ]  **기능 1 :** 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    <details>
      <summary>예시</summary>
      "" => 0
      "1,2" => 3
      "1,2,3" => 6
      "1,2:3" => 6
    </details>

- [ ]  **기능 2 :** 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다. .
    <details>
      <summary>예시</summary>
      "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    </details>

        
- [ ]  **기능 3:** 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ⭐️ 구현 할 기능 목록

**기능 1, 2 (주기능)**

- [x]  기능 1 : 실행흐름을 담당할 main메서드 구현
- [x]  기능 2 : 구분자와 타깃 문자열을 추출하는 메서드 extractDelimiterAndTargetString 구현
- [ ]  기능 3 : 타깃 문자열에서 구분자로 구분되는 숫자들이 저장된 배열을 반환하는 splitTargetStringToNumArray 메서드 구현
- [ ]  기능 4 : 숫자 배열을 매개변수로 받아 전체 합을 반환하는 sum메서드 구현

**기능 3 (예외처리)**

- [ ]  기능 1 : 사용자가 커스텀한 구분자도 아니고, 기본 구분자(쉼표(,) 또는 콜론(:))도 아닌 경우 IllegalArgumentException을 발생

### 입출력 요구 사항

**입력**

- 구분자와 양수로 구성된 문자열

**출력**

- 덧셈 결과

```java
결과 : 6
```

**실행 결과 예시**

```java
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 프로그래밍 요구 사항

- [ ]  JDK 21 버전에서 실행 가능해야 한다.
- [ ]  프로그램 실행의 시작점은 Application의 main()이다.
- [ ]  build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ]  프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ]  기본적으로 [Java Style Guide](https://apply.techcourse.co.kr/assignment/14/mission/43)를 원칙으로 한다.

## 라이브러리

- [ ]  camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - [ ]  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

