# 🔴 Mission: 문자열 덧셈 더하기
***

## 🟠 프리코스 진행 방식

### 🟡 과제 제출 전 체크 리스트
- 터미널에서 **`java -version`을 실행하여 Java 버전이 21인지 확인**한다. Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 21로 실행되는지 확인한다.
- 터미널에서 **Mac 또는 Linux 사용자의 경우 ./gradlew clean test 명령을 실행**하고, **Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행**할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
```
BUILD SUCCESSFUL in 0s
```

***

## 🟠과제 진행 요구 사항
- 미션은 문자열 [덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 포크하고 클론하는 것으로 시작
- 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가
  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고
***

## 🟠 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 각 숫자의 합을 반환
  - ex) "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정
  - 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
  
### 🟡 기능 목록
1. 빈 문자열 입력 처리
  : 빈 문자열을 입력받을 경우 0을 반환한다.
2. 기본 구분자를 이용한 숫자 합산
  : 쉼표(,) 또는 콜론(:)을 구분자로 사용하는 문자열을 입력받아 숫자들의 합을 계산한다.
3. 커스텀 구분자를 이용한 숫자 합산
  : "//"와 "\n" 사이에 위치한 커스텀 구분자를 사용해 문자열을 구분하고, 각 숫자의 합을 반환한다.
4. 잘못된 입력 처리
  : 입력이 잘못된 경우 `IllegalArgumentException`을 발생시킨다.

***

## 🟠 입출력 요구 사항

### 🟡 입력
- 구분자와 양수로 구성된 문자

### 🟡 출력
- 덧셈 결과
```
결과: 6
```

### 🟡 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과: 6
```
***

## 🟠 프로그래밍 요구 사항
- **JDK 21 버전**에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 **Application**의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.
***

### 🟡 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
