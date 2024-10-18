# 문자열 덧셈 계산기

- - - 
> 1주차는 간단한 미션인 만큼 기본기를 확실히 준비해야겠다고 생각했습니다.<br>
> Git, GitHub, IDE의 사용법, TDD 습관 들이기를 중심적으로 학습했으며, <br>
> 기능 단위의 커밋 하는 방식을 최대한 다양한 정보를 찾아보며 공부하였습니다.

<h3>🥇 1주차 미션 목표</h3>
- - - 

1. Git, GitHub, IDE 등 실제 개발을 위한 환경에 익숙해진다.
2. 교육 분야에 맞는 프로그래밍 언어를 사용하여 간단한 문제를 해결한다.

<h3>🧾 전체적인 플로우</h3>
- - - 

1. 프로그램 시작 시, 사용자가 문자열을 입력한다.
2. 커스텀 구분자의 존재를 확인한다. ("//"와 "\n" 사이에 있는 값)
3. 커스텀 구분자가 존재하는 경우 해당 문자열 이후의 값을 가져온다.
4. 각 숫자를 기본 구분자(, 또는 :)와 커스텀 구분자를 기준으로 나눠서 분류한다.
5. 분류된 값에 정수 이외의 값이 존재한다면 IllegalArgumentException을 발생시킨다.
6. 모든 값이 정수라면 "결과 : (값)"으로 출력하며 프로그램을 종료한다.

<h3>💬 구현할 기능 목록</h3>
- - -

- [x] 사용자 문자열 입력
    - 변수명은 "UserInput"으로 받음
    - 입력은 Console.readLine()을 사용한다.
        - 이는 'camp.nextstep.edu.missionutils.Console'를 import 받아 사용한다.
- [ ] 입력받은 문자열에 커스텀 구분자가 존재하는 지 확인
    - [ ] 존재한다면, 구분자를 기준으로 나누는 시작 위치 조정
- [ ] 구분자를 기준으로 문자열을 나눔
- [ ] 나눠진 문자열이 숫자로 된 정수인지 확인
    - [ ] 만약 숫자로만 되어있다면 값 합산
    - [ ] 만약 숫자가 아닌 다른 문자열이 있다면 오류 출력하고 종료
- [ ] 최종 위치까지 도달했다면 값 출력

<h3>🥊 예외사항</h3>

- [x] 빈 값을 입력받은 경우는 값 입력은 없지만, 오류가 없으므로 0을 반환한다.
- [ ] 커스텀 구분자가 존재하는데 빈 값인 경우도 오류가 없으므로 0을 반환한다.
- [ ] 커스텀 구분자는 앞 부분만 존재할 수 있다.