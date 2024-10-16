# java-calculator-precourse

# 구현할 기능 목록

### 덧셈할 문자열 입력 요청 문구 출력 기능
- 덧셈할 문자열을 입력 요청하는 문구를 상수화하여 사용
- 입력 값 반환하는 메서드에서 문구 출력
    - camp.nextstep.edu.missionutils.Console 의 readLine() 사용

### 입력값 파싱 기능
- 입력값에 대해 파싱 기능을 담당하는 클래스 구현
    - 입력 받은 문자열을 통해 커스텀 구분자를 사용했는지 판단하는 메서드 구현
    - 커스텀 구분자를 추출하는 메서드 구현
    - 설정된 구분자로 파싱하는 메서드 구현
        - 파싱 불가능 시 잘못된 값을 입력한 경우에 대한 예외 발생
- 구분자로 구분된 문자열을 숫자 리스트로 담아 반환하는 메서드 구현
    - 정수 끼리의 덧셈인지 실수가 포함된 덧셈인지 구분하는 기능 포함

### 덧셈 수행 기능
- 덧셈을 수행하는 클래스 구현
    - 덧셈을 수행한 결과를 반환하는 메서드 구현
    - 사용자가 음수를 포함한 경우 예외 발생 후 종료

### 사용자의 입력을 받아 모델에 전달하는 컨트롤러 구현
- 사용자의 입력을 파싱한 후 모델에 전달하여 계산 결과값을 받는 메서드 구현
    - 계산된 결과값은 뷰에 전달한다

### 덧셈 결과 문구 출력 기능
- 결과 문구와 함께 덧셈 결과 출력
- 출력 후 프로그램 종료
