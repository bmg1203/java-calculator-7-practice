# java-calculator-precourse

---

### 기능 구현 목록

- business
  - separate  
    - 입력받은 문자열에 커스텀 구분자가 있는지 확인한다.
    - 입력 문자열에서 기본 구분자로 문자열을 분리한다.
    - 기본 구분자로 분리한 문자열이 숫자인지 확인한다.
      - 숫자가 아니라면 예외가 발생한다.
      - 숫자가 맞다면 숫자로 변환한다.
  - add
    - 추출한 숫자를 더한다.
  - custom
    - 커스텀 구분자를 지정한다. 
  - service
    - 클라이언트 요청을 처리한다.
- presentation
  - ui
    - 사용자에게 입/출력 ui를 제공한다.