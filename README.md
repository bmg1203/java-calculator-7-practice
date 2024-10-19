# java-calculator-precourse

### 구현할 기능 목록

1. 입력
2. 문자열 정제
3. 덧셈

## 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

#### 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

- 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
  앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
- 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- 입출력 요구 사항
    - 입력 : 구분자와 양수로 구성된 문자열
    - 출력 : 덧셈 결과
        - 실행 결과 예시
          ```
          덧셈할 문자열을 입력해 주세요.
          1,2:3
          결과 : 6
          ```

<br><br>

## 기능 구현

#### 1. 입력

- 입력의 경우 요구하는 라이브러리의 console 로 받기

#### 2. 문자열 정제

1) 커스텀 구분자 정규식으로 찾기
2) 기본 구분자로 split
   나의 경우에는, 커스텀 구분자를 설정한 경우 기본 구분자는 무시하기로 하였다 - 진행해보고

#### 3. 덧셈

- 구분된 입력 값을 숫자로 변환, 구분자로 구분된 경우에 한해서(parseInt 된경우) 덧셈
- 사실 위에 안된 경우면 인자 잘못 입력한거이므로 IllegalArgumentException 일으키면 될듯

#### 4. 다른 테케 살펴보기

- 아마 잘못 입력 인자 더 있을것

## 직접 기능 구현 후 추가로 고려한 것

1. 기본 구분자 보유 문자열인지 여부
2. isPositive 여부 -> 예외처리는 IllegalArgumentException 로

<br>

### 여전히 추가로 고려해야 할 부분

- 기본 구분자와 커스텀 구분자의 양립 여부 
