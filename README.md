# 우아한 테크 코스 1주차 - 문자열 덧셈 계산기

## 구현할 기능 정리

1. 문자열 입력받기
2. 문자열에서 숫자 추출하기
3. 계산하기
4. 예외 처리

#### StringCalculatorApp
> 프로그램의 뼈대 역할을 수행 한다.
- [ ] 문자열 입력 받기 ("덧셈할 문자열을 입력해 주세요.")
- [ ] Calculator 를 사용 하여 정답 계산
- [ ] 정답 출력후 프로그램 종료("결과 : 6")

#### Calculator(Abstract)
> 계산기 클래스의 추상 클래스 제공
- [ ] 더하기 추상 메소드 작성

#### StringCalculator
> 문자열을 바탕으로 사칙연산을 수행한다. Calculator를 상속받아 구체화한다.
- [ ] NumberExtractor를 사용 하여 숫자 배열 추출
- [ ] 더하기 메서드 구현
    - [ ] 숫자 배열의 모든 값 더한 후 결과 값 반환

##### NumberExtractor
> 문자열에서 숫자를 추출 한다.
- [x] 문자열에서 숫자 추출
    - [x] 커스텀 구분자 파악
    - [x] 구분자와, 커스텀 구분자로 문자열 분리해서 숫자 배열로 추출