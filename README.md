# java-calculator-precourse


## 정보

해당 레포지토리는 우아한 테크코스 프리코스 1주차 과제에 대한 레포지토리입니다.
한가지 궁금한건 Public을 포크해서 public으로 남아있을텐데 괜찮은지 모르겠습니다.

## 과제

문자열 덧셈 계산기

```
# requirement 
- , 또는 :을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- 커스텀 기본자를 지정가능 문자열 앞부문 //와 \n 사이에 위치하는 문자를 커스텀 구분자로 사용한다
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
```
예시 1
"" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
예시 2
//;\n1;2;3 결과 -> 6
예시 3
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6

## 기능

- 사용자의 입력을 받아 값에 담고 출력한다. / 완료 
- 구분자를 담고 앞에서부터 구분자와 비교해서 더한다. / 진행 
- 커스텀 구분자를 추가한다.
- 예외사항발생시 exception을 던진다.

## 의도

입출력
기본기능
추가기능
예외처리


## 유의사항

- 구현할 기능을 미리 정리해서 Readme 파일에 추가한다
- 나눠진 기능에 따라 커밋단위를 나누고 추가한다
    - 이때 AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성
- 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.

## 체크리스트

- 기능을 올바르게 구현했더라도 요구 사항에 명시된 출력 형식을 따르지 않으면 0점을 받게 된다.
- 기능 구현을 완료한 후 아래 가이드에 따라 모든 테스트가 성공적으로 실행되는지 확인한다.
- 테스트가 실패하면 점수가 0점이 되므로 제출하기 전에 반드시 확인한다.

## 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 ![[https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java|Java Style Guide]]를 원칙으로 한다.

## 추가사항
- 제출방법과 양식 
- java 사용법 정리 

## 추가기능
TDD
Junit을 사용해서 문제가 생길만한 것 테스트하기 


