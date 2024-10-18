# java-calculator-precourse
## 기능 목록

### Delimiter (구분자)
* **Delimiter 인터페이스**
  * [x] 구분자를 처리하는 공통 메서드를 정의.

### DefaultDelimiter (기본 구분자)
* **기본 구분자**
  * [x] `Delimiter` 인터페이스를 구현한 클래스.
  * [x] 기본 구분자를 지정할 수 있다.

### CustomDelimiter (커스텀 구분자)
* **커스텀 구분자 처리**
  * [x] `Delimiter` 인터페이스를 구현한 클래스.
  * [x] 문자열의 앞부분에서 `"//{구분자}\n"` 형식으로 커스텀 구분자를 지정할 수 있다.
  * [x] 커스텀 구분자는 여러 개 올 수 있다.
    * 예: `//;\n//[\n1;2[3` 입력 시 커스텀 구분자에 `;`, `[`가 구분자로 등록 되어야 된다.

### DefaultDelimiterType (기본 구분자 형식)
* **기본 구분자 enum 클래스**
  * [x] 쉼표(`,`) 또는 콜론(`:`)을 필드로 가지며 기본 구분자 형식을 정의한다.

### Delimiters (구분자들)
* **구분자를 관리하는 일급 컬렉션**
  * [x] `DefaultDelimiterType`으로부터 값을 가져와 기본 구분자를 등록한다.
  * [x] `CustomDelimiter`로부터 커스텀 구분자를 등록할 수 있다.

### InputManager
* **입력된 문자열을 관리**
  * [x] `Delimiters`에 있는 구분자들을 문자열에서 제거한다.
  * [x] 문자를 숫자로 변환하여 리스트로 반환할 수 있다.
    * [x] 변환 과정에서 유효하지 않은 문자가 포함되면 `IllegalArgumentException`을 발생시킨다.

### Calculator
* **계산 로직**
  * [x] `InputManager`에서 준 리스트를 덧셈한다.

### InputView
* **입력**
  * [x] 입력받기 전 안내 메시지를 출력한다.
  * [x] 문자열을 입력받는다.

### OutputView
* **출력**
  * [x] 실행 결과를 출력한다.
