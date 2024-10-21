# java-calculator-precourse

## 구현 기능 목록

### 기능

1. 문자열 파싱 (StringSplitter)
    - 입력된 문자열을 구분자를 기준으로 분리
    - 기본 구분자(쉼표, 콜론) 처리
    - 커스텀 구분자 처리 ("//[구분자]\n[숫자들]" 형식)
2. 숫자 추출 및 변환 (StringCalculatorService)
    - 분리된 문자열에서 숫자 추출
    - 문자열을 정수로 변환
3. 덧셈 수행 (StringCalculatorService)
    - 추출된 숫자들의 합계 계산
4. 입력 검증 (InputValidator)
    - 입력값 유효성 검사
    - 음수 검사
    - 최대 입력 길이 검사
    - 커스텀 구분자 형식 검사
5. 결과 출력 (OutputView)
    - 계산된 결과를 형식에 맞게 출력

### 입력 (InputView)

1. 사용자로부터 문자열 입력 받기
    - `camp.nextstep.edu.missionutils.Console.readLine()` 사용
2. 입력 형식
    - 빈 문자열
    - 쉼표(,) 또는 콜론(:)으로 구분된 숫자
    - 커스텀 구분자를 포함한 문자열 ("//[구분자]\n[숫자들]" 형식)

### 출력 (OutputView)

1. 계산 결과 출력
    - 형식: "결과 : [계산된 합계]"
2. 예외 발생 시 에러 메시지 출력

### 예외

1. `IllegalArgumentException` 발생 조건
    - 음수가 입력된 경우
    - 잘못된 형식의 커스텀 구분자가 사용된 경우
    - 입력 문자열이 최대 길이를 초과한 경우
    - 숫자가 허용 범위를 벗어난 경우
    - 구분자가 여러가지 들어 가는 경우

2. 예외 처리
    - 예외 발생 시 에러 메시지 출력 후 프로그램 종료
    - `System.exit()` 사용 금지

### 주의사항

0. branch는 아이디로 새로 파기
1. Java 21 버전 사용
2. 외부 라이브러리 사용 금지 (제공된 라이브러리 제외)
3. 파일 및 패키지 구조 유지
4. Java 코드 컨벤션 준수
5. 기능 단위로 커밋 수행
6. README.md에 구현할 기능 목록 정리
7. AngularJS Git Commit Message Conventions 준수