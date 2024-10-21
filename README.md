# java-calculator-precourse

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현합니다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환합니다.
    - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있습니다.
    - 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 사용합니다.
    - 예: "//;\n1;2;3" => 6 (세미콜론(;)이 커스텀 구분자)
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료됩니다.

## 기능 정의

### Calculator.class

- [x] sum(int... numbers)
    - 배열에 저장된 값들을 순서대로 더합니다.
- [x] private 생성자

### StringCalculator.class

- [x] StringCalculator() 싱글톤
- [x] private parseNumber(String line)
    - line을 잘라 int 배열에 넣는다.
    - 정규화를 이용하여 separator에 대해 모두 자를 수 있게 준비한다.
- [X] private parseSeparator(String line)
    - line에 저장된 값을 순서대로 잘라 멤버변수(배열)로 가지고, 구분자를 추가합니다.
- [x] IllegalArgumentException 판단 메소드
    - 정의되지 않은 값 입력 시 예외를 발생시킵니다.
- [x] private getCustomSeparator(String line)
    - 커스텀 구분자를 가져옵니다. 없다면 null을 반환합니다.
- [x] sum(String line)
    - 코드중복을 줄이기 위하여 super.sum을 불러와서 구현한다.

### Application.class

- [x] getInput()
    - ReadLine으로 입력받을 메소드입니다.
- [x] print(Long number)
    - 최종 정답을 출력합니다.

## 입출력 요구 사항

```
입력
구분자와 양수로 구성된 문자열
```

### 출력

```
덧셈 결과
형식: "결과 : {계산결과}"
```

### 실행 결과 예시

```
- 덧셈할 문자열을 입력해 주세요.
- 1,2:3
- 결과 : 6
```
