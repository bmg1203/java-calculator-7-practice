# java-calculator-precourse

## 🚀 미션 설명

### 개요

- `입력한 문자열`에서 `구분자`를 통해 `숫자를 추출`하여
  `합해주는 계산기 프로그램`이다.
- `구분자`로는 `기본 구분자`,`커스텀 구분자`가 있으며, `구분자`에 대한 내용은
  밑에 서술 되어있다.

> 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.  
> 문자열을 전달 받아 `구분자`를 기준으로 분리한 `각 숫자의 합`을 반환한다.  
> `기본 구분자`는 `쉼표(,)` 또는 `콜론(:)` 이며 `커스텀 구분자`는 `문자열 앞부분`의
> `"//"와 "\n" 사이에 위치하는 문자`이다.
>> ex ) `"//;\n1;2;3"` : `커스텀 구분자`는 `세미콜론(;)`
---

## ✅ 기능 목록 정리

### **⚙️ Model**

**InputProcessor**

- [x]  인풋의 구분자 case를 구별하는 기능
    - [x]  기본 구분자 case 인지 구별한다.
    - [x]  커스텀 구분자 case 인지 구별한다.
- [ ]  잘못된 인풋이 들어왔는지 체크하는 기능
    - [ ]  입력 포맷에 맞지 않는 경우, 예외를 발생시킨다.
- [ ]  커스텀 구분자를 추출하는 기능
    - [ ]  커스텀 구분자를 추출하여 반환한다.
    - [ ]  커스텀 구분자로 문자가 들어왔을 경우, 구분자를 제외한 인풋에 해당 문자 외의 문자가 있다면 예외를 발생시킨다.
    - [ ]  커스텀 구분자로 숫자가 들어왔을 경우, 예외를 발생시킨다.
- [ ]  인풋을 대표 구분자로 통일 시킨 문자열로 변환하여 반환하는 기능
    - [ ]  기본 구분자 case일 경우, 인풋의 모든 구분자를 대표 구분자로 통일 시켜 반환한다.
    - [ ]  커스텀 구분자 case일 경우, 커스텀 구분자를 추출하고 인풋의 모든 구분자를 대표 구분자로 통일 시켜 반환한다.

**Calculator**

- [ ]  구분자를 통해 숫자를 추출하는 기능
    - [ ]  추출한 숫자가 음수일 경우, 예외를 발생시킨다.
- [ ]  추출된 숫자를 통해 결과 값을 반환하는 기능
    - [ ]  숫자들의 합을 반환한다.

---

### **💻 View**

**InputView**

- [x]  인풋(입력 문자열)을 전달 받는 기능
    - [x] 인풋을 전달 받아 반환한다.

**OutputView**

- [ ]  결과를 출력하는 기능

---

### **🕹️ Controller**

**Controller**

- [ ]  인풋을 전달하고 결과 값을 반환 받는 기능
- [ ]  결과 값을 전달하는 기능

---