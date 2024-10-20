<div align="center">

<h1>java-calculator-precourse</h1>

<br />

</div>

<br />

## 학습 목표
```markdown
📝 Git, GitHub, IDE 등 개발 환경에 익숙해진다.
📝 간단한 문자열 덧셈 계산기 문제를 해결하는 과정을 통해 Java 프로그래밍 실력을 향상시킨다
📝 기능 목록 작성과 커밋 단위에 맞춰 진행하며 올바른 개발 습관을 기른다.
```

<br />

# 목차

### [0. 요구사항 분석](#요구사항-분석)

### [1. 구현](#구현)

### [2. 테스트](#테스트)

### [3. 실수 회고](#실수-회고)

<br />

# 요구사항 분석

## 과제 진행 요구사항
1. 미션은 GitHub 저장소를 포크하고 클론하는 것으로 시작
2. 기능 구현 전, README.md 파일에 기능 목록을 작성
3. 기능 단위로 커밋하며, AngularJS Git Commit Message Conventions을 참고해 커밋 메시지 작성


## 기능 요구사항
> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력받아 각 숫자의 합을 반환
    - 예시: `"1,2:3"` => `6`
- 커스텀 구분자를 지정할 수 있다
    - 예시: `"//;\n1;2;3"` => `6` (구분자: `;`)
- 잘못된 입력 시 IllegalArgumentException 발생 및 프로그램 종료
- 입력: 구분자와 양수로 구성된 문자열
  - 출력
    - ```console
        덧셈할 문자열을 입력해 주세요.
        1,2:3
        결과 : 6
      ```


## 프로그래밍 요구사항
- 프로그램은 JDK 21에서 실행 가능해야 하며, 시작점은 `Application`의 `main()` 메소드
- 외부 라이브러리는 사용하지 않으며, 제공된 라이브러리만 사용
  - 라이브러리: `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 활용하여 사용자 입력 처리
- 자바 코드 컨벤션을 지키며 프로그래밍

<br />

# 구현

## 구현해야 할 기능 목록

- **입출력 클래스**
  - [x] 사용자로부터 문자열 입력을 받는 기능
  - [x] 계산 결과를 출력하는 기능
  - [x] 에러 발생 시 오류 메시지를 출력하는 기능

<br />

- **입력된 문자열을 처리하여 계산 결과를 반환하는 클래스**
  - [x] 쉼표(,) 또는 콜론(:)을 구분자로 사용하는 기본 계산 기능
  - [x] 커스텀 구분자("//;\n" 등)을 처리하는 기능
  - [x] 음수 입력 시 예외 발생 기능
  - [x] 잘못된 입력 형식에 대한 예외 처리 기능

<br />

# 테스트
- **테스트 코드**
```java
@Test
    void 커스텀_구분자_사용() {
            assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
            });
            }

@Test
    void 예외_테스트() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class)
        );
        }

@Test
    void 마이너스_구분자_사용() {
            assertSimpleTest(() -> {
            run("//-\\n1,2:3-4");
            assertThat(output()).contains("결과 : 10");
            });
            }

@Test
    void 예외_테스트_마이너스_구분자와_음수_사용() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-\\n1,2:3--4"))
            .isInstanceOf(IllegalArgumentException.class)
        );
        }

@Test
    void 예외_테스트_잘못된_숫자_형식() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-\\n1,2:+"))
            .isInstanceOf(IllegalArgumentException.class)
        );
        }

@Test
    void 예외_테스트_잘못된_커스텀_형식() {
            assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\n1,2"))
            .isInstanceOf(IllegalArgumentException.class)
        );
        }
```


> 아래의 출력 결과처럼 테스트가 잘 됐음을 알 수 있다.

<img src="https://github.com/user-attachments/assets/87b71440-2017-457a-acb7-4e077ab7ee55" width="700;" alt="">

<br />

# 실수 회고

> 과제 수행 중 발생한 실수와 해결 방법에 대한 기록

- **실수 코드**
```java
if (input.startsWith("//")) {
    // 커스텀 구분자 추출
    Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
    if (!matcher.find()) throw new IllegalArgumentException("잘못된 입력 형식입니다.");
    delimiters += "|" + Pattern.quote(matcher.group(1));
    input = matcher.group(2); // 커스텀 구분자 이후의 숫자 추출
}
```

- **개선된 코드**
```java
if (input.startsWith("//") && input.contains("\\n")) {
    // 커스텀 구분자 추출
    delimiters += "|" + input.charAt(2);
    input = input.substring(5);
} else {
    // 형식 검증: "//" 이후에 커스텀 구분자가 오고, 그 뒤에 "\n"이 있는지 확인
    if (!input.matches("//.\\n.*")) {
        throw new IllegalArgumentException("잘못된 구분자 형식입니다. 올바른 형식은 //구분자\\n 입니다.");
    }
}
```

- **문제점**
    - 실수 코드에서는 정규 표현식을 통해 커스텀 구분자를 처리하고 있었는데, 이 과정에서 코드가 복잡해지고 개행문자 처리가 잘 되지 않는 문제가 있었다.

- **해결 방법**
    - 개선된 코드에서는 정규식을 사용하지 않고, 커스텀 구분자가 항상 //로 시작하고 1글자의 구분자 이후에 \n이 있는 단순한 패턴임을 고려해 문자열 처리 방식으로 해결했다. 이렇게 하여 코드가 간결해지고, 성능적으로도 더 효율적인 방식이 되었다.

<br />