# java-calculator-precourse

###  할 일 목록

1. **문자열 입출력 설정**
    - `null` 일 경우 처리
2. **구분자 파싱 기능 구현**
    - 문자열에서 기본 구분자(`,`, `:`) 처리
    - 커스텀 구분자(`//;\\n`) 처리 로직 추가
    - 구분자가 여러 개일 경우 예외 처리
3. **숫자 추출 및 덧셈 기능 구현**
    - 문자열에서 숫자 추출
    - 구분자에 의해 구분된 숫자들을 모두 더하는 기능 구현
    - 구분자가 없는 경우, 예외 발생 처리
4. **마지막 숫자 계산 처리**
    - 문자열의 마지막 문자가 숫자인 경우 계산 처리
    - 마지막이 구분자인 경우 예외 처리
5. **숫자 및 구분자 예외 처리**
    - 잘못된 형식의 숫자(`NumberFormatException`)에 대한 예외 처리
    - 구분자 앞뒤에 숫자가 없는 경우 예외 처리
    - 여러 개의 커스텀 구분자가 입력된 경우 예외 처리
6. **결과 출력 기능 구현**
    - 덧셈 결과를 문자열로 반환하는 기능 구현
    - `getResultString()` 메서드를 통해 결과 값 출력
7. **테스트 코드 작성**
    - 정상적인 입력 값에 대한 테스트 작성
    - 잘못된 입력에 대한 예외 테스트 작성
8. **구분자 오류 수정**
   - 입력 문자열에서 구분자 처리 로직을 개선하여 백슬래시(`\`)와 같은 특수 문자를 구분자로 사용할 수 있도록 수정
