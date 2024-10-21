# :1234: 문자열 덧셈 계산기
**java-calculator-precourse**  

우아한테크코스 7기 프리코스 양성호 (SyingSHY)

## 과제 진행 요구 사항
- [X] 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- [X] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [X] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- [X] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- [X] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.  

### 구현할 기능 목록
| No. | 기능 | 구현 여부| 기능 상세 내용 |
| --- | ---- | :-----: | ------------- |
| **1** | **입력** | **O** | **사용자에게 입력에 대해 안내하고 문자열을 입력받는다** |
| 1-1 | 입력 안내 메시지 출력 | O | 사용자에게 입력에 관한 안내 메시지를 출력한다 |
| 1-2 | 입력 받아오기 | O | 사용자로부터 문자열을 입력받는다 |
| 1-3 | 입력 유효성 검증 | O | 입력 문자열이 유효한 값인지 검증한다 |
| 1-4 | 입력 내 숫자 추출 | O | 입력 문자열 내 계산 대상 숫자 문자들을 추출한다 |
| **2** | **커스텀 구분자** | **O** | **커스텀 구분자 사용 여부를 검증하고 사용 시 해당 로직을 준비한다** |
| 2-1 | 커스텀 구분자 검증 | O | 커스텀 구분자를 사용하기 위한 문자열이 입력되었는지 검증한다 |
| 2-2 | 커스텀 구분자 추출 | O | 문자열에서 커스텀 구분자로 활용할 문자를 추출한다 |
| **3** | **덧셈 계산기** | **O** | **추출된 숫자들과 커스텀 구분자를 바탕으로 덧셈을 진행한다** |
| 3-1 | 덧셈 계산기 | O | 추출된 숫자 문자들을 숫자 값으로 변환하여 계산한다 |
| **4** | **출력** | **O** | **계산된 덧셈 결과를 사용자에게 출력한다** |
| 4-1 | 출력 안내 메시지 출력 | O | 사용자에게 출력 결과를 안내하는 메시지를 출력한다 |
| 4-2 | 계산 결과 출력 | O | 사용자에게 계산 결과를 출력한다 |
| **5** | **테스트 코드** | **O** | **위 기능들을 검증하는 테스트 코드** |
| 5-1 | 입력 테스트 | O | 입력 처리 과정 테스트 |
| 5-2 | 커스텀 구분자 테스트 | O | 커스텀 구분자 처리 과정 테스트 |
| 5-3 | 덧셈 계산기 테스트 | O | 덧셈 계산기 처리 과정 테스트 |
| 5-4 | 출력 테스트 | O | 출력 처리 과정 테스트 |

### 예외 처리
**예상되는 예외 입력**
- [X] 입력에서 커스텀 구분자를 예상하였으나 비어있는 경우 (`//\n333`) &rarr; `IllegalArgumentException`
- [X] 입력에 범위 밖 숫자가 존재하는 경우 (`0 / -1 / ...`) &rarr; `IllegalArgumentException`
- [X] 입력에 숫자가 아닌 문자가 존재하는 경우 (`A / - / ?! / ...`) &rarr; `IllegalArgumentException`
- [X] 입력 내 구분자 사이에 숫자가 존재하지 않는 경우 (`:: / ,,`) &rarr; `IllegalArgumentException`

**예측하지 못한 예외 입력**
- [X] 확인되지 않음

## 프로그래밍 요구 사항
- [X] JDK 21 버전에서 실행 가능해야 한다.
- [X] 프로그램 실행의 시작점은 Application의 main()이다.
- [X] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [X] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [X] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [X] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [X] 기본적으로 Java Style Guide를 원칙으로 한다.