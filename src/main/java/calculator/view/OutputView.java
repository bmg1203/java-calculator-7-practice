package calculator.view;

import calculator.constants.OutputPrompts;

public class OutputView {

    public void outputPrint(int result) {
        System.out.printf(OutputPrompts.OUTPUT_PROMPTS.getPrompt(), result);
    }
}
