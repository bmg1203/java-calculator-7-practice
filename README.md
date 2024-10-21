# 문자열 덧셈 계산기

---

## 기능 목록

### 🛠️ Model (비즈니스 로직)

#### `Calculator`

1. **입력 검증 기능**
   - 🔍 **빈 문자열 또는 `null` 처리**
      - 입력 값이 `null`이거나 빈 문자열이면, 결과로 `0`을 반환합니다.
   - 🚨 **음수 값 검사**
      - 음수 값이 포함된 경우, `IllegalArgumentException` 예외를 발생시킵니다.
   - ❌ **숫자가 아닌 값 검사**
      - 숫자가 아닌 값이 포함된 경우, `IllegalArgumentException` 예외를 발생시킵니다.

2. **덧셈 기능**
   - ➕ **숫자 리스트 합산**
      - 변환된 숫자 리스트의 모든 값을 더해 총합을 반환합니다.

3. **오류 리스트 확인 후 예외 발생**
   - 📝 **오류 리스트 확인**
      - 오류 리스트에 저장된 메시지가 있으면, 모든 오류 메시지를 합쳐 `IllegalArgumentException` 예외를 발생시킵니다.

---

### ⚙️ Utils (유틸리티)

#### `StringParser`

1. **문자열 파싱 기능**
   - 📌 **구분자에 따른 문자열 분리**
      - 기본 구분자(쉼표`,` 및 콜론`:`) 또는 커스텀 구분자로 분리하여 숫자 문자열 배열로 반환합니다.
   - ✂️ **커스텀 구분자 처리**
      - `"//"`로 시작하고 `"\n"`이 포함된 문자열에서 커스텀 구분자를 추출합니다.
   - ✨ **잘못된 형식의 입력 검증**
      - 입력 형식이 올바르지 않은 경우, `"잘못된 입력 형식입니다."` 예외를 발생시킵니다.

---

### 👁️ View (입출력)

#### `InputView`

1. **사용자 입력 받기**
   - 📝 **콘솔 입력**
      - 사용자로부터 덧셈할 문자열을 콘솔에서 입력받습니다.

#### `OutputView`

2. **결과 출력**
   - 📢 **덧셈 결과 출력**
      - 덧셈 결과를 `"결과 : [값]"` 형식으로 출력합니다.

3. **오류 메시지 출력**
   - ⚠️ **예외 발생 시 오류 메시지 출력**
      - 유효하지 않은 입력이나 예외 발생 시, 적절한 오류 메시지를 출력합니다.
      - 예시:
         - `"음수는 허용되지 않습니다: [값]"`
         - `"숫자가 아닌 값이 포함되어 있습니다: [값]"`
         - `"잘못된 입력 형식입니다. (예: //;\n1;2;3)"`

---

### 🔄 Controller (입력 흐름 제어)

#### `CalculatorController`

1. **프로그램 흐름 관리**
   - 📥 **사용자 입력 처리**
      - `InputView`에서 사용자의 입력을 받아옵니다.
   - 🔍 **입력 검증과 처리**
      - `Calculator`를 호출해 입력의 유효성을 확인하고, 문자열을 숫자 리스트로 변환합니다.
   - ➕ **덧셈 연산**
      - `Calculator`를 호출해 숫자 리스트의 합을 계산합니다.

2. **결과와 예외 처리**
   - ✅ **결과 출력**
      - 계산된 결과를 `OutputView`를 통해 사용자에게 보여줍니다.
   - 🚨 **예외 처리**
      - 예외가 발생하면 `OutputView`를 통해 오류 메시지를 출력한 후 애플리케이션이 종료됩니다.

---
