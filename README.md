# java-calculator-precourse

### 구현할 기능 목록 정리

0. 문자열을 입력받는 기능
   : - 문자열은 구분자와 양수로 구성되어 있다.<br>
   - 캐리지 리턴이나, 줄바꿈, 탭 등 특수문자에 대해 주의가 필요하다.
   #어떤 문자가 와도 온전히 그 문자를 입력받아야 한다.<br>
   - 공백 입력에 대해서도 처리해야 한다.

1. 구분자를 결정하는 함수(기능)
   : - 기본적으로 쉽표와 세미콜론은 구분자로서 역할을 해야 한다.<br>
   - "//" 와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.<br>
   #'문자'라는 표현은 하나를 의미하므로, 여러 개의 문자가 구분자로 사용되는
   경우는 생각하지 않는다. 또한, 해당 문자들은 문자열 앞부분에 위치해있다.<br>
   - 구분자로 1,2 같은 숫자가 오는 경우도 생각해야 한다.<br>
   - 커스텀 구분자와 기본 구분자가 혼용되는 경우도 생각해야 한다.

2. 특정 문자(구분자)를 통해 문자열을 나누는 함수(기능)
   : - 1번에서 결정한 구분자를 통해 문자열을 나누어야 한다.<br>
   - \n 문자 뒤에 숫자가 나타날 수도 있고 구분자가 나타날수도 있다.<br>
   - 구분자가 중복되서 나타날 수도 있다.<br><br>
   만약 "//1\n1111122213333" 이런 입력은 1에서 뭐가 구분자인지 숫자인지
   구별이 안 간다.<br> (222+3333 인지, 1+222+3333인지 11+222+3333 인지 ....)<br>
   - 구분자란, 데이터를 구분하기 위해 사용되는 것이다.<br>
   예를 들어, 우아한,,테크,프리코스 는 '우아한', '', '테크', '프리코스' 총 4가지로
   구분되어야 한다.<br><br>
   "//1\n1111122213333" 이거는 먼저 구분자로서 역할을 한 다음에,
   이후 계산을 하는 순서가 맞는 것 같다.<br> 따라서 1을 순차적으로 구분하면
   ( ,를 통해 명시적으로 표현)<br><br>
   1 ,111122213333<br>
   2 ,,11122213333<br>
   3 ,,,1122213333<br>
   4 ,,,,122213333<br>
   5 ,,,,,22213333<br>
   6 ,,,,,222,3333<br><br>
   으로 된다.<br> 따라서 이 경우에 결과는 222 + 3333 이 된다.<br>
   (이런 입력 자체가 잘못된 것 같긴 하다.)

3. 사용자가 입력한 값이 잘못된 값인지 판단하는 함수(기능)
   : - 잘못된 입력이란 무엇인지가 중요한 쟁점이다.<br>
   - 첫 번째로, 구분자는 단일 문자를 의미하는데, 커스텀 구분자 입력 시
   '문자열'이 들어오게 되면 이는 잘못된 입력이다.<br>
   - 두 번째로, 2번에서 "//1\n1111122213333" 를 잘못된 입력이라고 생각은 하지만
   (여러 가지 답이 나올 수 있으므로), 논리적으로는 문제가 없다고 생각한다.
   ~~이외에는, 생각이 나지 않는다.~~

4. 잘못된 값이면 예외를 발생시키는 함수(기능)
   : 예외 처리를 통해 IllegalArgumentException를 발생시키면 될 거 같다.

5. 문자 또는 문자열을 '숫자'로 바꾸는 함수(기능)
   : Integer.parseInt 쓰면 될 것 같다. (JDK 내장 라이브러리)

6. 입력한 숫자들을 더하는 함수(기능)
   : + 연산을 사용하면 될 것 같다.

7. 결과를 출력하는 함수(기능)
   : System.out.print 를 사용하면 될 것 같다.