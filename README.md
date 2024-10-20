# java-calculator-precourse

- 문자열 덧셈 계산기

## 미션 목표

주어진 문자열에서 숫자를 추출하고 덧셈을 수행하는 프로그램을 구현합니다. 기본 구분자와 커스텀 구분자를 처리할 수 있도록 하고, 잘못된 입력에 대한 예외 처리를 수행합니다.

---

## 구현할 기능 목록

### 1. 기본 구분자를 이용한 문자열 덧셈 기능

- **설명**: 입력된 문자열에서 쉼표(,)와 콜론(:)을 구분자로 사용하여 숫자를 분리하고, 분리된 숫자들의 합을 계산합니다.
- **구분자**: 쉼표(,) 또는 콜론(:)
- **예시**:
    - 입력: `""` → 출력: `0` (빈 문자열은 0으로 처리)
    - 입력: `"1,2,3"` → 출력: `6`
    - 입력: `"1,2:3"` → 출력: `6`
- **처리 방법**:
    - 쉼표(,)와 콜론(:)을 기준으로 문자열을 분리.
    - 분리된 값이 모두 양의 정수일 경우에만 합산.
    - 빈 문자열이 입력되면 0을 반환.

---

### 2. 커스텀 구분자를 지원하는 문자열 덧셈 기능

- **설명**: 문자열의 첫 번째 부분에 커스텀 구분자를 지정할 수 있으며, 지정된 구분자를 사용하여 숫자를 분리하고 덧셈을 수행합니다.
- **구분자 형식**: 구분자는 `"//[구분자]\n"` 형식으로 입력됩니다.
- **예시**:
    - 입력: `"//;\n1;2;3"` → 출력: `6` (커스텀 구분자는 세미콜론)
    - 입력: `"//|\n2|3|4"` → 출력: `9` (커스텀 구분자는 파이프(|))
- **처리 방법**:
    - 문자열이 `"//"`로 시작하는지 확인.
    - `"//"`와 `"\n"` 사이에 위치한 구분자를 추출하여 사용.
    - 구분자를 기준으로 숫자를 분리하고 덧셈을 수행.

---

### 3. 잘못된 입력에 대한 예외 처리

- **설명**: 입력된 값이 올바르지 않거나, 음수가 포함된 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료합니다.
- **예시**:
    - 입력: `"1,-2,3"` → 출력: `"음수는 입력할 수 없습니다: -2"` (예외 발생)
    - 입력: `"1,,2"` → 출력: `"잘못된 입력 형식입니다. 구분자 사이에 빈 값이 들어가 있습니다."` (예외 발생)
- **처리 방법**:
    - 음수 값이 입력되면 `IllegalArgumentException` 발생.
    - 숫자로 변환할 수 없는 값이 입력되면 예외 발생.
    - 빈 값이나 잘못된 구분자 사용 시 예외 발생.

---

### 4. 빈 문자열 또는 null 입력 처리

- **설명**: 빈 문자열이나 `null`이 입력되면 숫자가 없다는 의미로 간주하고, 0을 반환합니다.
- **예시**:
    - 입력: `""` → 출력: `0`
    - 입력: `null` → 출력: `0`
- **처리 방법**:
    - 입력 값이 `null`이거나 빈 문자열일 경우 0을 반환.

---

### 5. 여러 개의 구분자가 연속으로 사용된 경우 처리

- **설명**: 쉼표나 콜론, 커스텀 구분자가 여러 번 연속으로 사용된 경우에도 예외 처리를 수행합니다.
- **예시**:
    - 입력: `"1,,2,3"` → 출력: `"잘못된 입력 형식입니다. 구분자 사이에 빈 값이 들어가 있습니다."` (예외 발생)
    - 입력: `"//;\n1;;2;3"` → 출력: `"잘못된 입력 형식입니다. 구분자 사이에 빈 값이 들어가 있습니다."` (예외 발생)
- **처리 방법**:
    - 구분자 사이에 빈 값이 있는지 확인.
    - 빈 값이 있으면 예외 발생.

---

### 6. 너무 큰 숫자에 대한 처리 (선택적 요구 사항)

- **설명**: 너무 큰 숫자가 입력될 경우 프로그램에서 처리하지 않거나 제한을 둘 수 있습니다. 예를 들어, 10000 이상의 숫자는 더하지 않고 무시할 수 있습니다.
- **예시**:
    - 입력: `"2,10001,3"` → 출력: `5` (10001은 더하지 않음)
- **처리 방법**:
    - 숫자가 10000 이상일 경우 무시하고 합산하지 않음.
    - 필요 시 이 기준을 조정할 수 있음.

---

## 프로그래밍 요구 사항

1. **프로그래밍 언어**: Java 21 버전에서 실행 가능해야 합니다.
2. **프로그램 시작점**: 프로그램은 `Application` 클래스의 `main()` 메서드에서 시작됩니다.
3. **라이브러리 사용 제한**: `build.gradle` 파일은 수정할 수 없으며, 추가적인 외부 라이브러리는 사용할 수 없습니다.
4. **입력 및 출력**: `camp.nextstep.edu.missionutils.Console` API를 사용하여 입력을 받고, 출력합니다.
5. **테스트**: 모든 기능은 `JUnit`을 사용하여 테스트해야 하며, 모든 테스트가 성공적으로 통과해야 합니다.
6. **예외 처리**: 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, 프로그램은 정상 종료되어야 합니다.

---

## 예외 사항

1. **프로그램 종료 시 `System.exit()` 사용 금지**: 프로그램은 예외가 발생했을 때 정상적으로 종료되어야 하며, `System.exit()`를 사용하지 않습니다.
2. **파일 및 패키지 이름 수정 금지**: 기본 제공된 파일 및 패키지 이름을 임의로 변경하거나 이동할 수 없습니다.
3. **코딩 컨벤션**: 자바 코딩 컨벤션을 따르며, 코드의 가독성과 유지보수성을 고려해 작성해야 합니다.

---

## 테스트 실행 방법

1. **Java 21 확인**: 터미널에서 `java -version`을 실행하여 Java 21 버전이 설치되어 있는지 확인합니다.
2. **테스트 실행**:
    - Mac 또는 Linux 사용자는 터미널에서 `./gradlew clean test` 명령을 실행하여 모든 테스트를 확인합니다.
    - Windows 사용자는 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행하여 테스트를 확인합니다.
3. **테스트 결과**: 모든 테스트가 성공적으로 실행되는지 확인합니다. 모든 테스트가 통과하면 다음과 같은 메시지가 출력됩니다:

```
BUILD SUCCESSFUL in 0s
```
