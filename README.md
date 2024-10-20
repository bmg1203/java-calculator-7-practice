# java-calculator-precourse

## 용어 정리

메소드, 변수 이름에서 혼동을 막기 위해 아래와 같은 용어를 사용한다.

### header, body

사용자의 입력으로 주어진 문자열을 헤더(header)와 바디(body)로 나눈다.

- 예시
```
Case #1

입력 문자열  //;\n1,2,3
header      //;\n   
body        1,2,3



Case #2

입력 문자열  1,2,3
header         
body        1,2,3
```

## 기능 목록

### ✅ 1. 사용자로부터 문자열을 입력받는다.
-[x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 함수를 사용해야 한다.

### ✅ 2. 문자열 중에서 커스텀 구분자를 찾는다.
-[x] 커스텀 구분자는 문자열의 맨 앞에 `//[커스텀 구분자]\n` 형태로 주어진다.
-[x] 커스텀 구분자는 최대 1개만 지정할 수 있다고 가정한다.
    -[x] 이외의 경우에는 `IllegalArgumentException`을 발생시킨다.
-[x] 커스텀 구분자는 숫자가 올 수 없다고 가정한다.
    -[x] 이외의 경우에는 `IllegalArgumentException`을 발생시킨다.
-[x] 커스텀 구분자는 1글자라고 가정한다.
    -[x] 이외의 경우에는 `IllegalArgumentException`을 발생시킨다.

### ✅ 3. 입력 문자열 중에서 헤더(커스텀 구분자 입력 부분)를 제외하고, 바디(값을 지정하는 부분)만을 남긴다.
-[x] 헤더가 존재하는 경우, 문자열에서 제외한다.
  -[x] 커스텀 구분자가 존재할 경우, `//[커스텀 구분자]\n` 부분을 제외한다.
  -[x] 커스텀 구분자가 존재하지 않을 경우, 그냥 원래 문자열을 출력한다.

### ✅ 4. 지정된 구분자로 문자열을 문자열 배열로 분리한다.
-[x] 기존 구분자(`,`, `:`)로 문자열을 분리한다.
-[x] 커스텀 구분자로 문자열을 분리한다.

### ✅ 5. 각 문자열을 숫자로 변환한다.
-[x] 문자열 배열의 각 항목을 숫자(`long`)로 변환한다.
-[x] 모든 숫자는 양의 정수라고 가정한다.
    -[x] 입력은 구분자와 양수로만 구성된 문자열임을 기억하자.
-[x] 숫자로 변환이 불가능할 경우, 오류를 반환한다.

### ✅ 6. 변환된 숫자의 합을 출력한다.
- [x] 프로그램의 결과를 출력한다.
- [x] 출력 형태는 `결과 : [숫자의 합]` 형태이다.



## 과제 진행 요구사항
- 기능 목록을 미리 정리한 뒤에 기능을 구현한다.
- 기능 단위로 commit 하는 방식으로 진행한다.