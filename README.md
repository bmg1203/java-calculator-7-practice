# java-calculator-precourse

## 기능 요구 사항

입력한 **문자열**에서 **숫자를 추출**하여 **더하는** 게산기를 구현한다.

* 기본 구분자는 , 과 : 이다.
* 커스텀 구분자 가능. // \n 사이에 있는 문자가 커스텀 구분자이다.
* 잘못된 값 입력 시에 IllegalArgumentException 발생 후 종료.

## 기능 목록
[x] 1. 입력 (InputView)

[x] 2. 계산 실행 (CalculateApplication)

[x] 2-1.커스텀 연산자 찾기 (CustomSeparator)

[x] 2-2. 입력 문자열 파싱 (InputDivider)

[x] 2-3. 파싱된 숫자 덧셈 (InputCalculator)

[x] 3. 계산 결과 출력 (OutputView)

## 예외 사항
* 잘못된 값 입력 시에 IllegalArgumentException 발생 후 종료한다.
### 잘못된 입력의 경우(IllegalArgumentException)
* **음수가 입력된 경우** : 기능 2-2까지 진행 후 음수가 남아있다면 예외가 발생한다.
* **파싱 이후 문자가 남아있는 경우**
* **정수가 입력되지 않은 경우** : 소수가 입력되었을 시 예외가 발생한다.

  ex) "1,2.3:4" => IllegalArgumentException

  ex) "//.\n1.2,3:4" 의 경우에는 .이 커스텀구분자이므로 *정수 입력으로 판단*, 10으로 결과값이 출력된다.

### 잘못된 입력이 아닌 경우
* **//\n으로 커스텀 구분자가 없는 경우** : IllegalArgumentException이 아닌 커스텀 구분자가 없는 경우로 로직을 진행한다.즉, 커스텀문자는 비어있을 수 있다.

  ex) "//\n"의 결과값 == 0, "//\n1:2"의 결과값 == 3
* **빈 문자열이 입력된 경우** : 결과값이 0이다
* **커스텀 문자열만 입력된 경우** : "//\n", "//;\n"과 같이 커스텀 문자열만 입력된 경우에도 커스텀 구분자는 비어있을 수 있으므로 결과값은 0 이다.