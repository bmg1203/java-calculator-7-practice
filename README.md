# java-calculator-precourse

## 📌 프로그램 순서에 따른 구현할 기능 목록

---

### ✅ 입력

- [X] 구분자와 양수로 구성된 문자열 (수식) 을 입력받기

### ✅ 구분자 등록

- [X] 커스텀 구분자 사용 여부 확인하는 함수 구현
- [X] 커스텀 구분자 사용 시, 이를 사용할 구분자로 등록하는 함수 구현

### ✅ 구분자로 문자열 자르기

- [X] 입력받은 문자열을 등록된 구분자로 자르기

### ✅ 추출된 숫자들의 합 구하기

- [X] 추출된 숫자가 양수인지 확인하고, 양수가 아닐 경우 `IllegalArgumentException` 발생시키는 함수 구현
- [X] 추출된 숫자들을 모두 더하기

### ✅ 출력

- [X] "결과 : 6" 의 형태로 계산기에서 더한 값을 출력

## 📌 클래스 별 구현할 기능 목록

---

### 📝 Model

#### ✅ [Expression] - 입력받은 문자열 관리

- [X] 입력받은 문자열 저장
- [X] 커스텀 구분자 사용하는지 확인
- [X] 커스텀 구분자를 지정한 부분 ("//" ~ "\n") 반환
- [X] 문자열에서 구분자 지정 부분을 제외한 실제 수식 부분 반환
- [X] 입력받은 문자열 반환

#### ✅ [Delimiter] - 구분자 관리

- [X] 구분자 생성하여 기본 구분자로 초기화
- [X] 커스텀 구분자 지정 부분을 입력받아 커스텀 구분자 등록
- [X] 등록된 구분자 반환

#### ✅ [PositiveNumber] - 실제 숫자(양수) 관리

- [X] 객체 생성 시 결괏값 초기화
- [X] 결괏값에 추출된 숫자를 int로 parsing하며 더하는 기능
    - [X] 구분자로 추출한 결과가 빈 문자열 ""일 경우, 더하지 않음
    - [X] 구분자로 추출한 결과가 숫자가 아닌 문자를 포함할 경우, `IllegalArgumentException` 발생시키며 종료
    - [X] 구분자로 추출한 결과가 양수가 아닐 경우, `IllegalArgumentException` 발생시키며 종료
- [X] 결괏값 반환

### 📝 Service

#### ✅ [Calculator] - 숫자 추출 및 계산

- [X] 실제 수식 부분 저장
- [X] 수식에서 구분자로 숫자 추출하여 배열로 저장
- [X] 결괏값을 0으로 초기화
- [X] 추출된 문자를 결괏값에 더하는 기능
- [X] 결괏값 반환

### 📝 View

#### ✅ [InputView] - 사용자 입력 처리

- [X] 구분자와 양수로 구성된 문자열 입력받는 기능

#### ✅ [OutputView] - 출력 처리

- [X] 결괏값 출력

출력 예시

```
결과 : 6
```

### 📝 Controller

#### ✅ [CalculatorController] - 계산기 실행 흐름 처리

- [X] 사용할 모델, 뷰 객체 초기화
- [X] 주어진 수식으로 계산
- [X] 결괏값 출력