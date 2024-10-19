# java-calculator-precourse

## 기능 목록 정리

- [x]  **문자열 입출력 처리:** 사용자로부터 콘솔을 통해 문자열을 입력받고 출력한다.
- [x]  **구분자 처리:** 입력받은 문자열에서 구분자를 식별하고 처리한다.
    - **기본 구분자:** 쉼표(`,`)와 콜론(`:`)을 기본 구분자로 사용한다.
    - **커스텀 구분자:** 문자열에서 "`//`"와 "`\n`" 사이의 문자를 찾아 커스텀 구분자로 사용한다.
- [x]  **숫자 추출 및 덧셈 연산 처리:** 문자열을 구분자에 따라 분리하고 추출한 숫자들을 모두 더하여 합산한다.
- [x]  **최종 결과 출력:** 모든 숫자를 더한 결과를 출력한다.
- [ ]  **예외 처리:** 잘못된 사용자 입력에 대한 예외를 처리하고, 애플리케이션을 종료한다.
    - **커스텀 구분자 형식 오류:** 잘못된 형식의 커스텀 구분자 입력을 처리한다.
    - **잘못된 입력 값:** 숫자가 아닌 값 또는 음수를 입력할 경우 예외를 처리한다.
