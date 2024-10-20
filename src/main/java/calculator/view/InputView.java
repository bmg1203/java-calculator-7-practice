package calculator.view;

import calculator.constants.InputMessages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {

    }

    public static void printInsertMessage() {
        System.out.println(InputMessages.INSERT_STRING);
    }

    public static String getUserInput() {
        return Console.readLine();
    }

}
