# 🚀 프리코스 1주차 미션 - 문자열 덧셈 계산기

---

우아한 테크코스 프리코스 1주차 미션 문자열 덧셈 계산기를 구현한 저장소입니다.

<br>

## 💡 목차

---

- [시작하기](#-시작하기)
- [Commit convention](#-commit-message)
- [Flow](#-flow)
    - [실행 결과 예시](#실행-결과-예시)
- [용어 정의](#-용어-정의)
    - [Model](#model)
    - [View](#view)
    - [Controller](#controller)
    - [Service](#service)
    - [Exception](#exception)
- [구현 리스트](#-구현-리스트)
    - [기능 구현 리스트](#기능-구현-리스트)
    - [입출력 구현 리스트](#입출력-구현-리스트)
    - [예외 처리 구현 리스트](#예외-처리-구현-리스트)

<br>

## 🚀 시작하기

---

레포지토리를 Clone한 뒤 IDE에서 어플리케이션을 실행합니다.

```
git clone https://github.com/woowacourse-precourse/java-calculator-7.git
```

브런치를 생성한 뒤 구현을 시작합니다.

```
git branch -b {branch name}
```

기능 구현 후 add, commit 명령을 사용해 로컬 저장소에 변경된 부분을 반영합니다.

```
git status // 변경된 파일 확인
git add -A(또는 .) // 변경된 전체 파일을 한번에 반영
git commit -m "message" // 작업한 내용을 메시지에 기록
```

모든 기능 구현을 마친 후, 원격 저장소에 commit을 반영하기 위해 branch를 push합니다.

```
git push origin {branch name}
```

<br>

## 📡 Commit Convention

```
<type> : <subject> 

<body> 

<footer>
```

```
git commit -m "<type> : <subject>" -m "" -m "<body>" -m "" -m "<footer>"
```

- ### Type
    - feat(feature) : 새로운 기능 추가
    - fix(bug fix) : 버그 수정
    - docs(documentation) : 문서 수정
    - style(formatting) : 코드 스타일 변경
    - refactor : 코드 리팩토링(기능 변경 X)
    - test(when adding missing tests) : 테스트 코드 추가, 수정
    - chore(maintain) : 빌드 관련 작업, 설정 수정
- ### Subject : 한 줄 요약
    - 명령형
    - 현재 시제 사용
    - 첫 글자 대문자 금지
    - 문장 끝에 마침표(.) 금지
- ### Message Body(선택 사항) : 변경 사항에 대한 상세 설명
    - 현재 시제 사용
    - 변경 이유 포함
    - 이전 동작과 대조
- ### Message footer(선택 사항)
    - Breaking changes
        - 변경 사항, 주의해야할 부분, 관련 이슈에 대한 설명과 함께 모든 변경 사항을 하단에 언급
    - Referencing issues
        - 이슈가 닫힌 경우(버그 해결) 사용
        - `Closed #keyword`
        - keyword : issue number

### Commit Message Example

```
feat: 사용자 로그인 기능 추가

사용자가 이메일과 비밀번호로 로그인할 수 있는 기능을 추가했습니다.
JWT 토큰을 사용하여 인증 절차를 구현하였으며, 로그인 실패 시의 오류 처리를 강화했습니다.

BREAKING CHANGE: 기존의 인증 방식이 JWT로 변경되었습니다.
Related to: #123
```

More : [Commit Message convention](https://gist.github.com/9941e89d80e2bc58a153.git)

<br>

## ⏳ Flow

---

- (1) 사용자 입력 문구가 출력된다.
-  (2) 컴퓨터가 사용자로부터 문자열을 입력받는다.
    - 문자열은 구분자와 양수로 구성된다.
- (3) 컴퓨터가 입력받은 문자열을 구분자를 기준으로 수를 분리한다.
    - 구분자 종류
        - 기본 구분자 : `쉼표 ",", 콜론 ":"`
        - 커스텀 구분자 : `"//{구분자}\n"`
- (4) 컴퓨터가 분리된 수를 리스트로 구성한다.
- (5) 컴퓨터가 계산기를 호출한다.
- (6) 호출된 계산기가 분리된 수들의 합을 구한다.
- (7) 컴퓨터가 덧셈 결과를 출력한다.

### 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

<br>

## 🏷️ 용어 정의

---

- **계산(Calculate)** : 애플리케이션이 시작되어 사용자 입력을 받고 수를 분리해 수들의 합을 구할 때까지를 의미한다.
- **분리(Split)** : 문자열에서 구분자를 기준으로 수를 분리하는 것을 의미한다.
- **덧셈(Sum)** : 문자열에서 분리된 수들의 합을 구하는 것을 의미한다.

### Model

- Number
    - `숫자 생성` 기능
    - `숫자 검증` 기능

- Numbers
    - `숫자 리스트 생성` 기능
    - `덧셈` 기능

### View

- InputView
    - `사용자 입력` 기능
        - `String` -> `구분자` 기준으로 분리 -> `공백` 제거 -> `HashSet<Integer>`로 변환
    - `입력 문구 출력` 기능

- OutputView
    - `덧셈 결과 출력` 기능

### Controller

- CalculatorController
    - `계산 시작` 기능 : 사용자에게 문자열 입력을 받아 숫자 리스트 생성
    - `계산` 기능 : 숫자 리스트의 총 합을 계산
    - `계산 종료` 기능 : 계산된 덧셈 결과를 반환

### Service

- Calculate
    - `계산기 생성` 기능
    - `덧셈 결과 생성` 기능
- CalculateResult
    - `덧셈 결과 처리` 기능

### Exception

- `예외 메시지` 제공
- `예외 처리` 기능

<br>

## 📃 구현 리스트

---

### 기능 구현 리스트

- 컴퓨터
    - [x] 계산기를 호출한다.
    - [ ] 계산기에서 덧셈 결과를 받는다.
    - [ ] 받은 덧셈 결과를 화면에 출력한다.
- 계산기
    - [x] 구분자로 문자열에서 수와 구분자를 분리한다.
      - 기본 구분자(`콜론 ":", 쉼표 ","`)일 경우
        - [x] 콜론 판단
        - [x] 콜론으로 문자열 분리
        - [x] 쉼표 판단
        - [x] 쉼표로 문자열 분리
        - [x] 콜론과 쉼표 모두일 경우 판단
        - [x] 콜론과 쉼표 모두 사용해 문자열 분리
      - 커스텀 구분자(`"//{구분자}\n"`)일 경우
        - [x] 커스텀 구분자 판단
        - [x] 커스텀 구분자 분리
        - [x] 커스텀 구분자를 사용해 문자열 분리
    - [x] 분리한 숫자들로 리스트를 구성한다.
      - [x] `""` 일 경우 `0`으로 처리
    - [ ] 숫자 리스트의 합을 구한다.
    - [ ] 구한 덧셈 결과를 컴퓨터에게 반환한다.

### 입출력 구현 리스트

- 입력
    - 사용자
        - [x] 문자열을 입력한다.
- 출력
    - 컴퓨터
        - [x] 사용자 입력 전 `"덧셈할 문자열을 입력해 주세요."` 문구 출력
        - [ ] 덧셈 결과 `"결과 : {덧셈 결과}"` 문구 출력

### 예외 처리 구현 리스트

- 사용자 입력 문자열
    - [ ] 분리된 문자열이 숫자가 아닐 경우 예외 처리 `"[ERROR] 문자열은 구분자와 숫자만 입력되어야 합니다."`
    - [ ] 분리된 문자열이 양수가 아닐 경우 예외 처리 `"[ERROR] 문자열은 구분자와 양수만 입력되어야 합니다."`
    - [ ] 커스텀 구분자 구성이 잘못되었을 경우 예외 처리 `"[ERROR] 커스텀 구분자는 '//'와 '\n'로 구성되어야 합니다."`
    - [ ] 기본 구분자나 커스텀 구분자가 아닌 다른 입력을 사용했을 경우 예외 처리 `"[ERROR] 기본 구분자(콜론 ':', 쉼표 ',') 또는 커스텀 구분자('//구분자\n')를 사용해야 합니다."`