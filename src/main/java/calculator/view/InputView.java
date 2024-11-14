package calculator.view;

import calculator.constants.InputPrompts;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        System.out.println(InputPrompts.INPUT_PROMPTS.getPrompt());
        return Console.readLine();
    }
}
