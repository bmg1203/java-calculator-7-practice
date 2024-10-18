## 기능 요구 사항
- [x] 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

---

## 계산기 흐름 관리

계산기 흐름 관리 기능은 문자열 덧셈 계산기의 전체 흐름을 제어하는 역할을 수행한다.

### 기능 요구사항

#### 입력 처리
- [x] 사용자로부터 입력을 받는 과정을 관리한다.
  - [x] **입력 처리**: 입력 기능을 호출하여 입력 메시지를 출력하고, 사용자의 입력을 받는다.
  - [ ] **테스트 케이스**: 입력 처리 테스트

#### 계산 처리
- [x] 입력된 값으로부터 계산 결과를 도출하는 기능을 제공한다.
  - [x] **구분자 처리**: 구분자를 등록하고 처리하는 기능을 호출한다.
  - [ ] **테스트 케이스**: 구분자 처리 테스트
  - [x] **문자 처리**: 입력된 문자열을 순차적으로 처리하여 각 문자를 판단하고 처리한다.
  - [ ] **테스트 케이스**: 문자 처리 테스트
  - [x] **숫자 처리**: 판단된 숫자를 합산 처리하여 결과를 도출한다.
  - [ ] **테스트 케이스**: 숫자 처리 테스트

#### 결과 출력
- [x] 계산된 결과를 사용자에게 보여준다.
  - [x] **결과 출력**: 출력 기능을 호출하여 결과를 출력 형식과 함께 반환한다.
  - [ ] **테스트 케이스**: 결과 출력 테스트

---

## 문자 판단 관리

문자 판단 관리 기능은 입력된 문자열을 순차적으로 처리하여 각 문자를 분석하고, 해당 문자가 숫자, 구분자, 또는 기타 값인지 판별하는 역할을 수행한다.

### 기능 요구사항

- [x] **문자 추출**
  - [x] 문자열의 시작부터 끝까지 순차적으로 진행하며, 각 문자를 하나씩 반환하는 기능을 제공한다.
  - [ ] **테스트 케이스**: 문자 추출 테스트

- [x] **숫자 판별**
  - [x] **양수 판별**: 입력된 문자가 양수인지 확인하는 기능을 제공한다.
  - [x] 연속된 숫자를 처리하는 기능을 호출한다.
  - [x] **음수 및 기타 숫자 판별**: 양수가 아닌 숫자를 처리하는 기능을 제공한다.
  - [ ] **테스트 케이스**: 숫자 판별 테스트

- [x] **구분자 판별**
  - [x] 입력된 문자가 구분자인지 확인하는 기능을 제공한다.
  - [ ] **테스트 케이스**: 구분자 판별 테스트

- [x] **잘못된 값 판정**
  - [x] 입력된 값이 특정 조건(`//`)을 만족하면, 관련 기능을 호출하여 처리한다.
  - [x] 입력이 숫자, 구분자, 또는 해당 조건을 만족하지 않으면 예외를 발생시키고 애플리케이션을 종료한다.
  - [ ] **테스트 케이스**: 잘못된 값 판정 테스트

---

## 구분자 관리

구분자 관리 기능은 구분자를 등록하고, 등록된 구분자인지 여부를 판별하는 역할을 수행한다.

### 기능 요구사항

- [x] **구분자 등록**
  - [x] 시스템에 사용할 구분자를 등록하는 기능을 제공한다.
    - [x] **기본 구분자**: 미리 정의된 구분자를 등록하는 기능
    - [x] **커스텀 구분자**: 사용자가 직접 정의한 구분자를 등록하는 기능
  - [ ] **테스트 케이스**: 구분자 등록 테스트

- [x] **구분자 판별**
  - [x] 등록된 구분자인지 확인하는 기능을 제공한다.
    - [x] 등록된 구분자인 경우: `True`를 반환
    - [x] 등록되지 않은 구분자인 경우: `False`를 반환
  - [ ] **테스트 케이스**: 구분자 판별 테스트

---

## 커스텀 구분자

커스텀 구분자 기능은 사용자가 정의한 구분자가 조건을 만족하는지 검증하고, 등록 여부를 결정하는 역할을 수행한다.

### 기능 요구사항

- [x] **커스텀 구분자 조건을 만족하는 경우 처리**
  - [x] 기본 구분자에 커스텀 구분자를 추가 등록하는 기능을 제공한다.
  - [ ] **테스트 케이스**: 커스텀 구분자 처리 테스트

- [x] **조건을 만족하지 않는 경우 처리**
  - [x] 조건을 만족하지 않으면 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
  - [ ] **테스트 케이스**: 조건 불만족 처리 테스트

---

## 숫자 생성

숫자 생성 기능은 입력된 문자를 분석하여 연속된 숫자를 확인하고, 해당 숫자를 처리하는 역할을 수행한다.

### 기능 요구사항

- [x] **연속된 숫자인지 판단**
  - [x] 다음 문자가 숫자가 아닌 경우, 현재까지 쌓인 숫자를 반환하여 처리한다.
  - [x] 다음 문자가 숫자인 경우, 연속된 숫자를 만들어 계속 처리한다.
  - [ ] **테스트 케이스**: 숫자 생성 테스트

---

## 합산

합산 기능은 전달받은 숫자들을 모두 더하는 역할을 수행한다.

### 기능 요구사항

- [x] **전달받은 숫자를 합산**
  - [x] 입력된 숫자들을 합산하여 최종 결과를 계산한다.
  - [ ] **테스트 케이스**: 합산 테스트

---

## 입력

입력 기능은 사용자로부터 데이터를 입력받고, 입력 형식을 출력하는 역할을 수행한다.

### 기능 요구사항

- [x] **입력 형식을 출력**
  - [x] 입력 형식을 화면에 출력한다.
  - [ ] **테스트 케이스**: 입력 형식 출력 테스트

- [x] **입력 받기**
  - [x] 사용자의 입력을 받는다.
  - [ ] **테스트 케이스**: 입력 받기 테스트

---

## 출력

출력 기능은 계산된 결과를 전달받아 특정 형식으로 출력하는 역할을 수행한다.

### 기능 요구사항

- [x] **결과 전달받기**
  - [x] 계산된 결과를 전달받는다.
  - [ ] **테스트 케이스**: 결과 전달 테스트

- [x] **결과 출력**
  - [x] 출력 형식과 함께 결과를 화면에 출력한다.
  - [ ] **테스트 케이스**: 결과 출력 테스트
