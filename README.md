# 1주차 java-calculator-precourse

## 과제 진행 요구 사항
- 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 🎯 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 🎯 입출력 요구 사항
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

## 🎯 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.
 
## 🎯 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Console API`를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 🎯 기능 목록
1️⃣ 사용자로부터 문자열을 입력받는 기능
- 사용자로부터 문자열을 입력받는다.
  - 만약 빈 문자열을 입력받는다면, 0을 출력한다. (ex: "")
  - 문자열 맨 앞이  `//` 또는 숫자(0이 아닌 양수)로 시작하지 않는다면 예외 처리를 한다. (ex: "?3,4")
  - 문자열 길이에는 제한을 두지 않는다.

2️⃣ 커스텀 구분자를 지정하는 기능 
- 커스텀 구분자는 `//`와 `\n` 사이에 위치해야 한다.
  - 커스텀 구분자 지정 형식이 잘못된 경우 예외 처리를 한다. (ex: "//;//3,4")
  - 커스텀 구분자가 기존 구분자와 같은 경우 예외 처리를 한다. (ex: "//,\\n1,7")
  - 커스텀 구분자가 공백일 경우 예외 처리를 한다. (ex: "// \\n1,8:7")
  - 커스텀 구분자가 비어있을 경우 예외 처리를 한다. (ex: "//\n3,5,7")
  - 커스텀 구분자가 메타 기호일 경우 예외 처리를 한다. (ex: "//?\\n1?2?3")
  - 커스텀 구분자 길이에는 제한을 두지 않는다.

3️⃣ 커스텀 구분자를 포함한 문자열인지 아닌지 확인하는 기능
- 커스텀 구분자가 포함된 문자열이라면 커스텀 구분자와 기본 구분자를 하나의 배열로 묶는다.

4️⃣ 쉼표(,) 또는 콜론(:) 또는 커스텀 구분자를 기준으로 숫자를 분리하는 기능
- 기본 구분자(, 또는 :)와 커스텀 구분자를 하나의 구분자 배열에 저장한다.
- 사용자에게 입력받은 문자열을 구분자 기준으로 구분하여 숫자 배열에 저장한다.
  - 기본 구분자 또는 커스텀 구분자가 아닌 경우 예외 처리를 한다. (ex: "3?4")
  - 숫자가 0 또는 음수일 경우 예외 처리를 한다. (ex: "4:-3", "4:0")
  - 구분된 숫자가 숫자가 아닌 유효하지 않은 문자일 경우 예외 처리를 한다. (ex: "4:2,abc")
  - 구분된 숫자가 분리할 수 없는 문자일 경우 예외 처리를 한다. (ex: "4:3, ,")
  - 구분된 숫자가 int 범위를 벗어났을 경우 예외 처리를 한다. (ex: "2147483648:4,5")
  - 구분된 숫자가 정수가 아닐 경우 에외 처리를 한다. (ex: 1.5:3,4)

4️⃣ 분리한 각 숫자의 합을 구하는 기능
- 숫자 배열에 저장된 숫자의 합을 구한다.
- 숫자 배열이 비어있을 경우 0을 반환한다.

5️⃣ 분리한 각 숫자의 합을 반환하는 기능
- 구한 합을 출력한다.
