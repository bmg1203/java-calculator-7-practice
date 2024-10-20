# java-calculator-precourse

# 💫 미션 요약

---
#### 1주차 미션은 문자열 계산기를 만드는 것입니다. 기본 구분자와 사용자 정의 구분자에 따라 계산된 결과값을 출력하는 것입니다.

# 📑 필요 기능 목록

---
- 사용자로부터 입력 받는 함수 생성
- 입력 값이 잘못된 값인지 체크하는 함수 생성 (잘못된 값을 입력할 경우 IllegalArgumentException 발생)
  - 쉼표, 콜론, 사용자 지정 구분자 외의 구분자 있는지 검사
  - // 와 \n 사이에 숫자가 입력된 경우
  - // 와 \n 사이에 문자가 아닌 문자열이 존재하는 경우
  - long 범위를 초과하는 경우
  - 숫자로 끝나지 않는 경우
  - 공백이 있는 경우
- 계산하는 함수 생성 

# ✅ 구현 체크

---
- [x] 사용자로부터 입력 받는 함수 생성
  - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [ ] 입력값 유효성 검사 함수 생성
  - [ ] 기본 구분자, 지정 구분자 외의 입력값이 존재하는지 검사하는 함수
  - [ ] 지정구분자를 사용하는지 검사하는 함수
  - [ ] // 와 \n 사이에 숫자가 입력됐는지 검사하는 함수
  - [ ] // 와 \n 사이에 문자가 아닌 문자열이 존재하는지 검사하는 함수
  - [ ] long 범위를 초과하는지 검사하는 함수
  - [ ] 숫자로 끝나지 않는 경우를 검사하는 함수
  - [x] 공백이 있는지 검사하는 함수
- [ ] 계산하는 함수 생성
  - [ ] 입력값이 빈 문자열이라면 0을 리턴하는 함수
  - [ ] 구분자로 구분하여 숫자만 남기는 함수
  - [ ] 모든 숫자를 더하는 함수
  - [ ] 결과값 리턴

- [ ] 모든 테스트케이스가 성공하는가?

# 🔐 제약사항

---

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 `Java Style Guide`를 원칙으로 한다.