# java-calculator-precourse

## 기능 요구사항

### 1. 입력 기능

* **사용자 입력**
  * 프로그램은 사용자로부터 문자열을 입력받는다.
  * 입력 방법:`Scanner`를 사용한다.
  * 입력 데이터: 숫자와 구분자로 구성된 문자열.

### 2. 구분자 처리

* **구분자 사용**
  * **기본 구분자**
    * 쉼표(`,`)와 콜론(`:`)을 사용하여 숫자를 분리한다.
  * **커스텀 구분자 지정**:
    * 입력 문자열이 **`"//"`로 시작하면** `"\n"` 이전까지의 문자열을 커스텀 구분자로 인식한다.

### 3. 숫자 추출 및 변환

* **숫자 분리**
  * 설정된 구분자를 사용하여 입력 문자열을 숫자 문자열로 분리한다.
* **숫자 변환**
  * 분리된 각 문자열을 정수로 변환한다.
  * 숫자로 변환할 수 없는 값이 포함된 경우 예외를 발생시킨다.

### 4. 합계 계산

* **숫자 합산**
  * 변환된 양의 정수들을 모두 합산한다.

### 5. 결과 출력

* **결과 출력**
  * 계산된 합계를 출력한다.

### 6. 예외 처리

* **예외 상황 발생 시**
  * 잘못된 입력이나 예외 상황이 발생하면 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
  * 예외 메시지를 사용자에게 출력한다.
* **예외 상황 목록**
  * 음수가 포함된 경우.
  * 숫자로 변환할 수 없는 값이 포함된 경우.
  * 잘못된 형식의 커스텀 구분자가 입력된 경우.
