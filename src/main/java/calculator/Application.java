package calculator;

import static calculator.InputView.inputString;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = inputString(ResultView::printInputString);
    }
}
