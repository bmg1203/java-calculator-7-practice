# java-calculator-precourse



# 문자열 계산기

---



>## 기능 요구사항 정리



1. **빈 문자열 입력시**

   - 입력값이 빈문자열이면 결과는 '0'을 반환합니다.
   - 예시: 
     - "" => 0


<br> 


2. **기본 구분자**
   - 쉽표(`,`)와 콜론(`:`)을 기본 구분자로 사용합니다. 이 두 구분자를 함께 사용할 수 있습니다.
   - 예시:
     - "1,2" => 3
     - "1,2:3" => 6

<br> 

3.  **커스텀 구분자 사용**
   - 문자열 앞부분에 `"//"` 와 `"\n"` 사이에 커스텀 구분자를 지정 할 수 있습니다.
   - 커스텀 구분자를 지정하면 기본 구분자(쉼표, 콜론)는 사용하지 않습니다.
   - 커스텀 구분자는 특정 형식에 제한이 없는 걸로 판단하고 숫자, 문자, 특수 문자 등을 사용할 수 있습니다.
   - 예시:
     - "//+\n1+2+3" => 6
     - "//+\n1+2,3" =>  커스텀 구분자를 "+"로 지정하였으므로 기본 구분자인 쉼표(",")는 허용되지 않습니다.
     - "//3\n333"  => 빈문자열이기 때문에 0
     - "//3\n43331" => 4 + 1 = 5
     - "//o\n1o2o3" => 6

<br> 

4. **입출력 요구사항**
   - 구분자와 양수로 구성된 문자열
     - `2.기본 구분자`: 기본구분자인 쉼표(`,`)와 콜론(`:`)인 경우와 숫자 조합의 경우만 유효합니다.
     - `3. 커스텀 구분자 사용`:   `"//"` 와 `"\n"` 사이에 커스텀 구분자와 숫자 조합의 경우만 유효합니다.
     - 위 사항 이외의 문자열 입력은 올바르지 않은 형식으로 판단하여 `IllegalArgumentException`를 발생시킵니다.

<br> 

5. **실행 결과 예시**
```bash
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6

```

