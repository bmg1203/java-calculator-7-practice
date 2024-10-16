# java-calculator-precourse

# 기능
- [ ] Calculator Class
  - [ ] 전체적인 계산기 로직을 가지고 있는 코드.
  - [ ] 전체적인 로직 흐름만 감당한다.
- [X] CalculatorParam Class
  - [X] 계산기에 필요한 파라미터를 들고 있는 객체
- [ ] InputParameter Class
  - [ ] '//', '\n'을 확인하는 메서드
    - [ ] 확인이 된다면 구분자를 저장
      - [ ] 해당하는 테스트 코드 작성
    - [ ] 확인이 안된다면 default 구분자(':', ',')로 코드 진행
      - [ ] 해당하는 테스트 코드 작성
    - [ ] 이때, 'exit' 문자열이 들어오면 프로그램 종료
      - [ ] 해당하는 테스트 코드 작성
  - [ ] 구분자를 통해서 숫자로 변환하는 코드
    - [ ] 숫자를 변환한 것을 리스트에 저장
      - [ ] 해당하는 테스트 코드 작성
- [ ] Addition Class
  - [ ] 리스트를 전달 받은 후, 덧셈 진행
    - [ ] 해당하는 테스트 코드 작성
  - [ ] 그 후 값을 리턴
    - [ ] 해당하는 테스트 코드 작성
  - [ ] 다시 InputParameter에 입력 메서드 실행
    - [ ] 해당하는 테스트 코드 작성
- [ ] Validator Class
  - [X] '//', '\n' 사이에 문자열이 존재하는지 확인, 없다면 재시도 요청
    - [ ] 해당하는 테스트 코드 작성
  - [X] 숫자인지 확인하고, 안되면 런타임 에러 리턴 후 재시도 요청
    - [ ] 해당하는 테스트 코드 작성