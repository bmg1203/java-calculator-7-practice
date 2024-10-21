# java-calculator-precourse
<br/>
<br/>

# 📕 구현 기능 리스트
<br/>

### 1. 문자열 입력

---

- [x]  `덧셈할 문자열을 입력해주세요` 메세지 출력합니다.
- [x]  `camp.nextstep.edu.missionutils`라이브러리의 `Console` 클래스를 이용하여 문자열을 입력받습니다.

<br/>

### 2. 입력 문자열 유효성 검사

---

- [x]  커스텀 구분자 유효성 검사
    - [x]  커스텀 구분자 선언부가 여러번 반복되면 예외를 반환합니다.
    - [x]  커스텀 구분자가 숫자를 포함할 경우 예외를 반환합니다.
- [x]  잘못된 형식으로 입력에 대한 검사
    - [x]  1,2,3, 를 입력했을 때 예외를 반환합니다.
    - [x]  1,,2,3 를 입력했을 때 예외를 반환합니다.
    - [x]  사용자가 공백을 입력하면 예외를 반환합니다.
- [x]  등록된 구분자 외, 유효하지 않은 문자가 나온다면 예외를 반환합니다.
- [x]  유효성 검사에 실패하면 `IllegalArgumentException` 예외를 반환합니다.

<br/>

### 3. 문자열 포맷팅

---

- [x]  커스텀 구분자 선언부가 존재하는 경우, 해당 부분을 삭제하고 순수한 문자열만 남깁니다.

<br/>

### 4. 검증된 문자열에서 구분자 추출 및 등록

---

- [x]  기본 구분자 등록
    - [x]  문자열에 포함하고 있는 기본 구분자를 등록합니다.
- [x]  커스텀 구분자 등록
    - [x]  문자열 앞부분의 “//”와 “\n”가 존재하는 경우, 커스텀 구분자로 등록합니다.
    - [x]  공백 문자도 등록될 수 있게 합니다.
    - [x]  커스텀 구분자가 이스케이프 문자 또는 정규식에 포함된 문자인 경우에도, 인식할 수 있어야 합니다.

<br/>

### 5. 구분자를 기준으로 숫자 분리

---

- [x]  추출된 구분자를 기준으로 숫자를 분리합니다.

<br/>

### 6. 계산

---

- [x]  분리된 숫자를 더합니다.

<br/>

### 7. 결과 출력

---

- [x]  숫자 계산 후 결과를 출력합니다.
    - [x]  `결과 : {결과 값}`  형식으로 출력합니다.