## 1. 입력 처리

- **기능**: 덧셈할 문자열을 입력 받기
    - **입력 형식**: "덧셈할 문자열을 입력해 주세요."
    - **유효성 검사**:
        - 음수가 아닌 양수로 구성된 문자열인지 확인
        - 2개 이상 양수 문자열이 있을 때, 각 양수 사이에 구분자가 존재하는지 확인
        - 구분자가 커스텀일 때 `//과 \n` 사이에 존재하는지 확인

## 2. 로직 구현

- **기능**: 각 숫자의 총 합
    - **알고리즘**:
        - 구분자를 통해 양수를 분리
        - 분리된 양수의 총 합 계산

## 3. 출력 처리

- **기능**: 총 합 결과 출력
    - **출력 형식**: "결과 : "

## 4. 예외 처리

- **기능**: 잘못된 입력 처리
    - **오류 메시지**: "유효하지 않은 입력입니다."

## 5. 테스트

- **기능**: 테스트 케이스 작성
    - **케이스 1**: ("") => 0
    - **케이스 2**: (1,2) => 3
    - **케이스 3**: (1:2) => 3
    - **케이스 4**: (1,2:3) => 6
    - **케이스 5**: (//;\n1;2;3) => 6
    - **케이스 6**: (//b\n1b2b3) => 6
    - **케이스 7**: (-1,2) => 오류 메시지 출력
    - **케이스 8**: (-1:2) => 오류 메시지 출력
    - **케이스 9**: (-1,2:3) => 오류 메시지 출력
    - **케이스 10**: (\\;\n-1;2;3) => 오류 메시지 출력
    - **케이스 11**: (a,b) => 오류 메시지 출력
    - **케이스 12**: (a:b) => 오류 메시지 출력
    - **케이스 13**: (a,b:c) => 오류 메시지 출력
    - **케이스 14**: (//;\na;b;c) => 오류 메시지 출력