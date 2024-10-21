![image](https://github.com/user-attachments/assets/f37f95a7-7a5f-43ef-b3c8-cd8d76e1b618)
> 7기 프리코스 1주차 미션 - 문자열 덧셈 계산기
> ====================== 
> java-calculator-precourse

<br>
<br>

# 🤛 학습 목표

- `Git`, `GitHub`, `IDE` 등 실제 개발을 위한 환경에 익숙해진다.
- 교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.

# ✍ 요구사항 분석

## 🔊 기능 요구 사항

입력한 `문자열`에서 `숫자`를 추출하여 더하는 계산기를 구현한다.
> 문자열에서 숫자를 추출하는 과정이 필수적.

<br>

- `쉼표(,)` 또는 `콜론(:)`을 구분자로 가지는 문자열을 전달하는 경우 `구분자`를 기준으로 `분리`한 각 숫자의 합을 반환한다.
  > - 예:  `""` → `0`, `"1,2"` → `3`, `"1,2,3"` → `6`, `"1,2:3"` → `6`
  > - 아무런 입력을 하지 않았을 때는 `0`이 출력됨. **기본 합**은 **`0`**.
  > - 구분자를 **기준**으로 나눈 뒤, 각 숫자들을 더해줌.
  > - 여러 구분자의 **혼용**은 허용
  > - 만약 **구분자만** 입력된다면? → **기본 합**을 출력.
      >
  - 아무런 입력을 하지 않음 = **추출할 숫자가 없음** == 구분자만 입력됨 = **추출할 숫자가 없음**
  > - **숫자만** 입력된다면? → 그대로 **최종적인 합**이 됨.
      >
  - 하지만 입력된 문자열이 정확히 `0`인 경우는  `IllegalArgumentException`, 이유는 **입력 요구사항** 참고

- 앞의 기본 구분자(쉼표, 콜론) 외에 **커스텀 구분자**를 지정할 수 있다. **커스텀 구분자**는 문자열 앞부분의 `//`와 `\n` 사이에 위치하는 문자를 **커스텀 구분자**로 사용한다.
  > - 예를 들어 `"//;\n1;2;3"`과 같이 값을 입력할 경우 **커스텀 구분자**는 `세미콜론(;)`이며, 결과 값은 `6`이 반환되어야 한다.
  > - **커스텀 구분자**는 `//`와 `\n` 사이에 위치하는 **문자**를 **커스텀 구분자**로 사용하며 구분자는 **하나의 문자**임.
      >
  - **커스텀 구분자**를 지정하는 문자들이 없으면, **일반 문자**에 속함.
    >
  - **구분자가 아닌 문자열**을 입력시에는 `IllegalArgumentException`
  >   - **커스텀 구분자**를 지정하는 문자들이 **이스케이프 문자**이기 때문에 처리할 필요가 있음.
  >   - **커스텀 구분자**가 **숫자**일 수도 있음.
  > - **구분자** 라는 측면에서, **기본 구분자**와 **커스텀 구분자**와의 **혼용**이 가능함.

- 사용자가 `잘못된 값`을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
  > - `잘못된 값`은 **음수**와 **0**이 해당됨.
      >
  - 입력 요구사항을 보면, 구분자와 양수로 구성된 문자열이라고 명시되어 있음.
  > - `잘못된 값`은 **구분자가 아닌 문자**가 해당됨.
      >
  - 마찬가지로 입력 요구사항을 참고

## 📬 입출력 요구사항

### 입력

- 구분자와 양수로 구성된 문자열
  > - 문자열에는 구분자와 양수만 들어갈 수 있음.
      >
  - **구분자**는 일반 구분자와 커스텀 구분자로 나누어지고 그 외의 문자는 구분자가 아니기 때문에 `잘못된 값`으로 정의.
  >    - **양수**로만 이루어져야 하기 때문에, **양수가 아닌 정수(0, 음수)**는 `잘못된 값`으로 정의.
         >
  - **양수** 중에서도 양의 **정수**만 입력 가능. 실수를 표현하기 위한 **.** 은 구분자가 아닌 문자열로 분류되기 때문.

### 출력

- 덧셈의 결과

# 📃 기능 명세서

| **기능**  | **작업**       | **클래스**                     | **구조**     | **설명**                |
|---------|--------------|-----------------------------|------------|-----------------------|
| **입력**  | 문자열 입력 받기    | `InputReader`               | Service    | 문자열 입력 받기             |
| **처리**  | 문자열 객체 전달    | `StringProcessorController` | Controller | 문자열 처리 컨트롤러           |
| **처리**  | 문자열 처리 객체    | `StringCalculatorDTO`       | DTO        | 문자열 관련 변수 객체 (DTO 역할) |
| **처리**  | 구분자 추출하기     | `DelimiterExtractor`        | Service    | 기본 구분자 추출             |
| **처리**  | 커스텀 구분자 추출하기 | `CustomDelimiterExtractor`  | Service    | 커스텀 구분자 추출            |
| **처리**  | 숫자의 합 계산하기   | `SumCalculator`             | Service    | 추출된 숫자들의 합 계산         |
| **출력**  | 숫자의 총합 출력하기  | `StringCalculatorView`      | View       | 숫자 합산 결과를 보여주는 뷰      |
| **테스트** | 테스트 코드       | -                           | Test       | 각종 테스트 코드             |

---

## 구성 설명

### 1. Controller

- `StringProcessorController`: 입력된 문자열을 처리하고 각 객체의 작업을 조율하는 역할을 하는 클래스

### 2. DTO

- `StringCalculatorDTO`: 입력된 문자열을 보관하고, 서비스 간 데이터를 전달하는 객체

### 3. Service

- **`InputReader`**: 문자열을 입력받는 클래스
- **`DelimiterExtractor`**: 기본 구분자를 추출하는 클래스
- **`CustomDelimiterExtractor`**: 커스텀 구분자를 추출하는 클래스
- **`SumCalculator`**: 추출된 숫자들의 합을 계산하는 클래스

### 4. View

- **`StringCalculatorView`**: 계산된 합계를 출력하는 클래스

### 5. Test

- **테스트 코드**: 다양한 기능을 검증하기 위한 테스트 코드

---

## 주어진 라이브러리

`camp.nextstep.edu.missionutils`에서 제공하는 `Console.java` API를 사용하여 구현해야 함

- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

```java
package camp.nextstep.edu.missionutils;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    private Console() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
```




