# java-calculator-precourse

---

## 구현 기능 목록

    1. `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 사용자의 값을 입력받는다.
        a. "덧셈할 문자열을 입력해 주세요.\n"을 출력한다.

    2. 입력된 값을 검증한다.
        a. 입력이 가능한 값은 `양수`, `구분자`뿐이다.
        b. 구분자는 기본적으로 ","(쉼표)와 ":"(콜론)을 갖는다.
        c. 입력값의 시작이 "//"일 경우 "\n" 사이의 문자는 커스텀 구분자가 된다.
        d. 사용자가 잘못된 값을 입력하면 `IllegalArgumentException`을 발생시키고 앱을 종료시킨다.

    3. 덧셈을 진행한다.
        a. 결과값을 위한 변수를 생성한다.
        b. 구분자가 나오기 전까지의 숫자는 문자열로 생각하고 합쳐서 진행한다.
        c. 구분자가 나온다면 지금까지의 숫자를 결과값에 더한다.
        d. 마지막이 숫자인 경우 구분자가 없으므로 따로 덧셈을 진행한다.

    4. 결과값을 반환한다.
        a. "결과 : n"의 형식으로 반환한다.