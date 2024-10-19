# java-calculator-precourse

# java-calculator-precourse

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현할 기능 목록
- [x] 문자열 입력 받는 기능
    - [x] 문자열이 공백 또는 빈 문자열인지 확인
- [x] 구분자를 기준으로 분리하는 Splitor 추출하는 기능
- [x] 구분자를 기준으로 문자열을 분리하여 리스트에 저장하는 기능
- [x] 리스트에 저장된 문자열을 숫자로 변환하는 기능
- [x] 덧셈 기능
- [ ] 덧셈 결과 반환하는 기능

## 예외처리
### 문자열 관련
- [ ] 문자열에 숫자가 없고 문자만 있는 경우

### 구분자 관련
- [ ] 쉼표(,) 또는 콜론(:) 또는 커스텀 구분자가 아닌 다른 구분자가 문자열에 포함된 경우
- [ ] 구분자가 연속으로 나오는 경우
- [ ] 구분자 사이의 숫자가 양수가 아닌 경우

### 커스텀 구분자 관련
- [ ] 커스텀 구분자를 잘못 지정한 경우 ("//"와 "\n"를 사용하지 않은 경우)
- [ ] "//"와 "\n" 사이에 문자가 위치하지 않거나 공백이 위치하는 경우
- [ ] "//"와 "\n" 사이에 문자가 여러 개 위치하는 경우
- [ ] 커스텀 구분자가 쉼표(,) 또는 콜론(:)인 경우
- [ ] 커스텀 구분자가 숫자인 경우