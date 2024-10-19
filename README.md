# java-calculator-precourse

# 프리코스 1주차 과제 : 🖩 문자열 덧셈 계산기

> 우아한테크코스 7기 1주차 미션, 문자열 덧셈 계산기를 구현한 저장소입니다.

# 목차

- [시작하기](#시작하기)
- [기능 목록](#기능-목록)
    - [계산기 시작](#계산기-시작)
    - [계산하기](#계산하기)
    - [예외처리](#예외처리)
    - [계산기 종료](#계산기-종료)

## 시작하기

레포지토리를 Clone 하고 IDE에서 애플리케이션을 실행합니다.

```git
git clone -b as --single-branch https://github.com/ruudska6/java-calculator-7
```

## 기능 목록
---

## 계산기 시작
- [ ] **사용자에게 입력을 지시하는 메세지 출력**
    -  `덧셈할 문자열을 입력해 주세요.` 가 콘솔에 출력됨.
- [ ] **사용자가 문자열을 입력한다.**
    - 사용자로부터 덧셈할 문자열을 콘솔을 통해 입력받는다.
    - 예시: 1,2:3
## 계산하기
- [ ] **입력한 문자열에서 숫자형 문자열을 추출한다.**
    - 쉼표(`,`) 또는 콜론(`:`)을 구분자로 사용하여 배열에 넣는다.
    - 예시: `"1,2:3"` => [1,2,3]
- [ ] **커스텀 구분자 기능**
    - "//[구분자]\n" 형식으로 커스텀 구분자를 지정할 수 있으며, 해당 구분자를 사용해 숫자를 분리한다.
    - 예시: `"//;\n1;2;3"` => 6
- [ ] **문자형을 숫자형으로 바꾼다.**

- [ ] **바꾼 숫자들을 전부 더해 합을 구한다.**
    - 예시: `"1,2:3"` => 6

## 예외처리
- [ ] **잘못된 값 입력 시 예외 처리**
    - 구분자 외에 숫자가 아닌 값이 포함되거나 양수가 아닌 숫자가 입력되면 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
    - 예시: `"a,1"` 또는 `"1,-1"` 입력 시 예외 처리.
- [ ] **인자에 공백을 입력 시 0으로 예외 처리**
    - 공백을 0으로 정함.
    - 예시: `"1"` 입력시 `결과 : 1`  `공백` 입력 시 `결과 : 0` 

## 계산기 종료
- [ ] **사용자가 입력한 문자열을 더한 결과를 보여준다.**
    -  `"1,2:3"` 었다면 콘솔에 `결과 : 6` 를 출력하고 계산기를 마친다.