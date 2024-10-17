# java-calculator-precourse

---

## 목차

[1. 프로젝트 소개](#프로젝트-소개)

[2. 구현 기능 목록](#구현-기능-목록)

[3. 버전 로그](#버전-로그)

---

## 프로젝트 소개

---

## 구현 기능 목록

### 입력

- [x] "덧셈할 문자열을 입력해 주세요." 를 출력
- [x] 사용자 데이터 입력 받기

### 연산

- [x] 커스텀 구분자가 포함된 문자열인지 확인하기
- [x] 커스텀 구분자 포함일 경우 포멧이 맞는지 확인
    - [x] 포멧이 정확하지 않을 경우 에러 처리
- [x] 구분자로 이루어진 배열 생성
- [x] 양수 추출 대상 배열 생성
- [x] 양수 추출 대상 배열 검증
    - [x] 양수와 구분자로만 이루어졌지 않을 경우 에러 처리
- [x] 구분자로 구분된 숫자 더하기

### 출력

- [x] "결과 : {합}" 형식으로 결과 출력

### 종료

- [x] 리소스 반환

### 에러 처리

- [x] 사용자가 잘못된 값을 입력할 경우 예외처리 후 애플리케이션 종료

---

## 버전 로그

### v 0.0.1

- 역할

```text
- Application class

    - 문자열 입력받는 역할
    - 기본 포맷인지 커스텀 포멧인지 구분하는 역할
    - 결과 출력하는 역할
    - 사용한 자원 반납하는 역할

- DataParser class

    - 입력받은 문자열을 검증하는 역할
    - 입력 받은 문자열을 구분자와 데이터로 파싱하는 역할

- Calculator class

    - 문자열을 정수형으로 바꾸는 역할
    - 바뀐 정수를 더하는 역할
    - 문자 배열을 문자열로 바꾸는 역할

- Data class

    - 구분자 배열과 피 연산 데이터 배열을 가진 DTO
```

- todo

```text
 [ ] Application, DataParser, Calculator class 가 단일 책임을 가지도록 리펙터링
 [ ] 또한 각 클래스별 테스트 코드를 작성
```