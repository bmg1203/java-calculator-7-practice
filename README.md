# java-calculator-precourse

## 프로그램 흐름 정리

1. ‘덧셈할 문자열을 입력해 주세요.’ 출력

2. 사용자는 덧셈을 위한 문자열을 입력한다.

3. 입력이 exit이라면 종료, 아니라면 계속한다.

4. 문자열이 유효한지 확인한다.

&emsp;&emsp; a. 커스텀 구분자를 입력했는가?

&emsp;&emsp;&emsp;&emsp;  i. Yes -> 구분자 = 커스텀 구분자 + 지정 구분자

&emsp;&emsp;&emsp;&emsp; ii. No -> 구분자 = 지정 구분자

&emsp;&emsp; b. 구분자와 숫자를 제외한 다른 입력이 있는가?
   
&emsp;&emsp;&emsp;&emsp; i. Yes -> 잘못된 입력, IllegalArgumentException

&emsp;&emsp;&emsp;&emsp; ii. No -> 올바른 입력, 5번 수행 

5. 덧셈 연산 수행

6. 결과 출력

7. 다시 처음으로


## 구현 기능 목록 정리 <1차>


🔸사용자에게 '덧셈할 문자열을 입력해 주세요.' 를 출력하는 promptUserForInput 메서드

🔸문자열을 입력 받는 getInput 메서드

🔸입력받은 문자열이 exit인지 확인하는 isExitCommand 메서드

🔸 입력받은 문자열에 커스텀 구분자가 있는지 확인하는 hasCustomDelimiter 메서드

🔸 hasCustomDelimiter 결과에 따라 구분자를 지정하는 determineDelimeter 메서드

🔸 문자열이 구분자와 숫자로만 이루어져 있는지 확인하는 isValidNumberString 메서드

🔸 덧셈을 수행하는 perfomAddition 메서드
 
