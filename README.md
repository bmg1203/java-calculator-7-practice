# java-calculator-precourse <br>

---

## 기능 요구 사항

### 1. 입력 기능
+ 입력값 자료형: 문자열
+ 숫자 및 문자가 함께 포함된 문자열을 한번 입력 받을 수 있어야 함

### 2. 핵심 기능
1. 입력 받은 문자열에서 구분자를 찾아내는 기능
    - 쉼표(,), 콜론(:)만을 구분자로 가지는 경우
    - 커스텀 구분자와 쉼표(,), 콜론(:)이 같이 사용되는 경우<br/>
2. 인식한 구분자로 입력받은 문자열에서 숫자들을 추출하는 기능<br/>
3. 추출된 숫자들을 더하는 기능

### 3. 출력 기능
+ 출력 형식에 맞추어 계산 결과를 출력
  + ex) 결과 : 6

### 4. 예외 처리
+ 사용자가 잘못된 값을 입력한 경우 -> (IllegalArgumentException)
  1. 입력 문자열에 숫자가 없이 구분자만 있는 경우
  2. 입력 문자열에 쉼표(,), 콜론(:), 커스텀 구분자가 아닌, 생뚱맞은 구분자로 구분되어 있는 경우
  3. 입력 문자열에 양수가 아닌 수가 있는 경우
  4. 공백을 입력한 경우





