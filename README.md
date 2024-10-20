# java-calculator-precourse

### 1. 입력을 정제하는 기능
    1.1 기본 구분자만 입력된 경우
        - 기본 구분자를 제외하고 숫자만 추출한다 -> 완료

    1.2 커스텀 구분자를 포함하여 입력된 경우
        - 기본 구분자 + 커스텀 구분자를 제외하고 숫자만 추출한다 -> 완료

### 2. 덧셈을 하는 기능
    2.1 1.에서 추출한 숫자들을 모두 더하여 반환한다 -> 완료

### 3. 예외 상황
    3.1 input이 비어있는 경우 -> 완료
    3.2 커스텀 구분자 지정 없이 기본 구분자 이외의 구분자를 입력하는 경우 -> 완료
    3.3 구분자가 두 개 이상 연속된 경우 -> 완료
    3.4 커스텀 구분자가 여러 개인 경우 -> 완료
    3.5 구분자'만' 입력된 경우 -> 완료
    3.6 커스텀 구분자로 \ 을 추가하고 싶은 경우 -> 완료
    3.7 구분자로 문자열 입력이 끝난 경우 -> 딱히 문제될 게 없다고 생각
    3.8 명세의 입력은 `구분자와 양수로 구성된 문자열` 이라고 했지만 음수가 입력된 테스트가
        있으므로 이를 위한 예외상황 생각 -> 완료
    3.9 입력에 공백이 포함된 경우 -> 완료