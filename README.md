# 🧮 문자열 덧셈 계산기

# ⛳️ 학습 목표

- Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
- JAVA를 사용하여 간단한 문제를 해결한다.

# 💡 기능 요구 사항

- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- 쉼표(`,`) 또는 콜론(`:`)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- 앞의 기본 구분자(`,`, `:`) 외에 커스텀 구분자를 지정할 수 있음
    - 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

# **📝** 기능 목록

## 구분자 목록 생성

- [ ]  구분자 목록을 생성한다.
- [ ]  기본 구분자(`,`, `:`)를 구분자 목록에 추가한다.

## 안내 메시지 출력

- [ ]  "`덧셈할 문자열을 입력해 주세요.`"  출력

## 문자열 입력

- [ ]  사용자로부터 문자열을 입력 받는다.
- [ ]  입력된 문자열이 `null`인지 확인한다.
- [ ]  입력된 문자열의 앞 뒤 공백을 제거한다.
- [ ]  입력된 문자열이 빈 문자열(`""`)인지 확인한다.
    - [ ]  빈 문자열인 경우 결과로 `0`을 출력하고 애플리케이션을 종료한다.

## 커스텀 구분자 처리

- [ ]  입력 문자열에서 `"//"`와 `"\\n"`의 위치를 찾아, 커스텀 구분자가 있는지 확인한다.

### 커스텀 구분자가 존재하는 경우

- [ ]  `"//"`와 `"\\n"` 사이의 문자열을 커스텀 구분자로 추출한다.
- [ ]  커스텀 구분자를 구분자 목록에 추가한다.
- [ ]  `"//"`와 `"\\n"` 및 그 사이의 구분자를 제외한 나머지 부분을 연산할 문자열로 설정한다.

### 커스텀 구분자가 존재하지 않는 경우

- [ ]  전체 입력 문자열을 연산할 문자열로 설정한다.

## 문자열을 구분자로 나눈 후, 각 부분을 숫자로 변환하면서 유효값 검증

- [ ]  구분자 목록을 사용하여 연산할 문자열을 분리하여 숫자 문자열 배열을 생성한다.
- [ ]  숫자 문자열 배열을 순회하며 각 요소를 정수로 변환하면서 양수인지 검증한다.
    - [ ]  문자열이 비었으면 0으로 반환한다.
- [ ]  커스텀 문자열이 `-`일 경우, `2-1`은 `[2, 1]`로, `2--1`을 `[2, -1]`로 처리한다.

## 합계 계산

- [ ]  변환된 정수들의 합계를 계산한다.

## 계산 결과 출력

- [ ]  계산 결과를 "`결과 : (합계)`" 방식으로 출력한다.

# ⚡ 예외처리 사항

- [ ]  입력된 문자열이 `null`인 경우 `IllegalArgumentException`을 발생시키고 **"**`입력이 없습니다.`**"** 라는 오류 메시지를 출력한 후 애플리케이션을 종료한다.
- [ ]  커스텀 구분자가 비어 있는 경우 `"//"`가 `"\\n"`를 일반 문자로 간주한다.
  따라서 `IllegalArgumentException`을 발생시키고 "`숫자가 아닌 값이 포함되어 있습니다.`" 라는 오류 메시지와 오류가 발생한 값을 출력한 후 애플리케이션을 종료한다.
- [ ]  커스텀 구분자가 숫자인 경우 `IllegalArgumentException`을 발생시키고 "`커스텀 구분자는 숫자가 될 수 없습니다.`" 라는 오류 메시지를 출력한 후 애플리케이션을 종료한다.
- [ ]  커스텀 구분자가 여러 개인 경우 `IllegalArgumentException`을 발생시키고 "`커스텀 구분자는 한 개 이어야 합니다.`" 라는 오류 메시지를 출력한 후 애플리케이션을 종료한다.
- [ ]  `"//"`와 `"\\n"` 중 하나만 존재하는 경우 `IllegalArgumentException`을 발생시키고 "`'//'와 '\\n'이 모두 존재해야 합니다.`" 라는 오류 메시지를 출력한 후
  애플리케이션을 종료한다.
- [ ]  `"//"`가 `"\\n"`보다 뒤에 위치하는 경우 `IllegalArgumentException`을 발생시키고 "`'//'는 '\\n'보다 앞에 위치해야 합니다.`" 라는 오류 메시지를 출력한 후
  애플리케이션을 종료한다.
- [ ]  숫자 문자열 배열에 숫자가 아닌 값이 포함되어 있는 경우 `IllegalArgumentException`을 발생시키고 **"**`숫자가 아닌 값이 포함되어 있습니다.`**"** 라는 오류 메시지와 오류가
  발생한 값을 출력한 후 애플리케이션을 종료한다.
- [ ]  숫자 문자열 배열에 숫자 문자열이 `long`으로 표현할 수 없는 숫자일 경우 `IllegalArgumentException`을 발생시키고 **"**`숫자가 너무 큽니다.`**"** 라는 오류 메시지와
  오류가 발생한 값을 출력한 후 애플리케이션을 종료한다.
- [ ]  문자열에 음수 값이 포함된 경우 `IllegalArgumentException`을 발생시키고 **"**`음수는 허용되지 않습니다.`**"** 라는 오류 메시지와 오류가 발생한 값을 출력한 후
  애플리케이션을 종료한다.

# ✅ 과제 진행 요구 사항

- [ ]  [java-calculator-7](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 Fork & Clone
- [ ]  `README.md`에 구현할 기능 목록을 정리해 추가
- [ ]  완료 후 Pull Request
- [ ]  우아한테크코스 지원 플랫폼에 소감 작성 후 제출
- [ ]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

# ✅ 프로그래밍 요구 사항

- [ ]  JDK 21 버전에서 실행 가능해야 한다.
- [ ]  애플리케이션 실행의 시작점은`Application`의`main()`이다.
- [ ]  `build.gradle`파일은 변경할 수 없으며,**제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- [ ]  애플리케이션 종료 시`System.exit()`를 호출하지 않는다.
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ]  [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 프로그래밍

## 라이브러리 요구 사항

- [ ]  `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
- [ ]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

# ⭐️ 1주차 목표

- [ ]  MVC 패턴 적용
- [ ]  TDD 개발 방법론 준수
- [ ]  자바의 Streams API 연습 및 활용
- [ ]  람다 표현식을 효과적으로 코드에 적용
- [ ]  SOLID 원칙 준수
