package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        return readLine();
    }

    public void print(int s) {
        System.out.println("결과 : " + s);
    }

}
