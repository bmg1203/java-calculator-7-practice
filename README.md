# java-calculator-precourse
## 기능 목록
- [x] 사용자 입력을 받는다
- [x] 사용자 입력을 검증한다
  - 공백만 입력했나?
- [x] 기본 구분자인지 판단한다
  - 빈 문자열, 숫자만 존재해도 기본 구분자이다 
  - 기본 구분자는 쉼표(`,`) 또는 콜론(`:`)을 사용해 문자를 구분한다
  - 기본 구분자는 혼합 사용 가능하다: `1,2:3` -> [1, 2, 3]
- [x] 커스텀 구분자인지 판단한다
  - `//`와 `\n` 사이에 한 개 이상의 문자가 존재해야 한다
  - 빈 문자열은 커스텀 구분자가 아니다
    - `"//\n123"` -> `IllegalArgumentException`
- [x] 입력을 구분자로 분리한다
  - 분리할 수 없는 입력은 `IllegalArgumentException`
- [x] 문자가 양수인지 검증한다
  - 음수인지 확인한다
  - 숫자 외 문자가 존재하는지 확인한다
  - 길이(1자리 ~ 15자리)를 확인한다
  - 기본값인지 확인한다(0, 빈문자열)
- [x] 양수들로 변환한다
  - 기본값 0은 포함하지 않는다
- [x] 덧셈을 계산한다
  - 덧셈 결과를 검증한다
- [x] 덧셈 결과를 출력한다
  - 편의성을 위해 포맷팅을 적용한다(`1,000`, `1,000,000`)
- [x] 문자열 덧셈 계산기를 실행한다
