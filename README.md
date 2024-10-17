# 문자열 덧셈 계산기

---

### 프로그램 소개

- 입력한 문자열에서 숫자를 추출하여 더하는 계산기이다. <br>

## 기능 목록

1. 사용자로부터 문자열을 입력받는다. [O] <br><br>

2. 프로그램은 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. <br>
   * 기본 구분자는 쉼표(,) 또는 콜론(:)을 가진다. [O]
   * 커스텀 구분자는 "//"와 "\n" 사이에 위치하는 문자이다. [O]
   * 빈 문자열은 숫자 0으로 취급된다. [O]
   * 소수점을 가지는 숫자를 입력하여도 된다. [ ] <br><br>

3. 사용자가 입력한 문자열에 대해 덧셈 결과를 출력한다. [ ] <br><br>

## 예외 상황 (IllegalArgumentException을 발생)
1. 커스텀 구분자 지정이 잘못된 경우
   * "//"와 "\n" 사이에 위치하는 문자가 아닌 경우 [O]
   * "//"와 "\n" 자체가 입력이 잘못된 경우 [O] <br><br>

2. 입력 값이 숫자 또는 구분자가 아닌 경우 [O] <br><br>


