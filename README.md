# java-calculator-precourse
# 구현목록

---
### UI 기능
- [X] 입력 안내 출력 기능
  - "덧셈할 문자열을 입력해 주세요."
- [X] 사용자 입력 받는 기능 
- [X] 출력 기능
  - "결과 : {}"
---
### 주요 기능
- [X] Default 구분자("**,**", "**:**")를 통한 숫자 파싱 기능
  - {숫자},{숫자}:{숫자}
- [X] Custom 구분자 파싱 기능
  - //{구분 문자열}\n{숫자}{구분 문자열}{숫자}
- [X] 입력에서 숫자 문자열 추출 기능
- [X] 구분자가 연속될때 숫자를 0으로 처리하는 기능
  - ex) {구분자1}**ᵛ**{구분자2}{숫자}{구분자3}
- [ ] 숫자간 덧셈 기능
---
### 추가 기능
- [X] **Default 문자 + Custom 구분자 모두**를 통한 숫자 파싱 기능
- [X] **커스텀 구분자로 문자열** 가능 하도록 구현
- [ ] **단일 숫자의 크기**에 제한이 없도록 구현
- [ ] **결과 크기에 제한**이 없도록 구현
---
### 예외처리
- [ ] 입력 문자열이 Default, Custom 형식에 맞지 않는 예외
- [X] 입력 숫자가 음수인 예외
- [X] 구분 문자가 지정된 <구분 문자열>에 없는 예외
---