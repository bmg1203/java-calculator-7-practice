<p>
    <img src="https://github.com/user-attachments/assets/c811c2be-923e-4134-a7d4-56bd12198910" alt="우아한테크코스" width="300px">
</p>

# free-course 1주차 과제
## 문자열 덧셈 계산기

---

# 기능 목록

1. 사용자 입력 받는 기능
  - 선 출력 문구 : "덧셈할 문자열을 입력해 주세요."

2. 사용자 입력을 구분자 파트와 문자열 파트로 나누는 기능
  - 구분자 파트, 문자열 파트가 각각 공백일 수도 있다.
  - 구분자 파트가 없다면 구분자는 기본 구분자만 존재한다.
  - 문자열 파트가 없다면 0을 출력해야 한다.

3. 구분자를 통해 숫자를 구분하는 기능
  - 기본 구분자 쉼표(,), 콜론(:) 두 가지가 있다.
  - 사용자가 지정하는 특정 구분자도 있을 수 있다.
  - 특정 구분자는 "//"와 "\n" 사이에 위치하는 문자이다.

4. 구분된 숫자를 더하는 기능
  - 구분된 숫자는 양수여야만 한다.

5. 문자열 배열을 정수 리스트로 변환하는 메서드
  - 문자열 배열을 숫자로 변환하는 메서드 호출
  - 숫자로 변환된 리스트를 받아 양수인지 검증하는 메서드 호출

6. 문자열 배열을 숫자로 변환하는 메서드

7. 숫자 리스트를 받아 양수인지 검증하는 메서드

8. 덧셈 결과를 출력하는 기능
  - 문자열 파트가 공백으로 주어질 경우 출력 문구 : "결과 : 0"
  - 출력 문구 : 예) "결과 : 6"
  

# 예외 사항
`사용자가 잘못된 값을 입력할 경우 
IllegalArgumentException을 발생시킨 후 
애플리케이션은 종료되어야 한다.`
1. 구분자 파트에서 형식("//", "\n""관련 형식을) 지키지 않은 경우
2. 문자열 파트에서 올바른 구분자로 이루어지지 않은 경우
3. 문자열 파트에서 분리된 숫자가 양수가 아닌 경우


## 과제 진행 요구 사항
- 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.

    - AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.

- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

  - 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력
- 구분자와 양수로 구성된 문자열

### 출력
- 덧셈 결과

```
결과 : 6
```

### 실행 결과 예시

```
덧셈할 문자열을 입력해주세요
1, 2, 3
결과 : 6
```

## 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 Java Style Guide를 원칙으로 한다.

## 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.