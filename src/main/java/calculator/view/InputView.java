package calculator.view;

import calculator.constants.InputPrompts;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    public String inputString() {
        System.out.println(InputPrompts.INPUT_PROMPTS.getPrompt());

        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
