package calculator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력하세요.");
        return Console.readLine();
    }
}
