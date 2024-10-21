package calculator;

import calculator.extract.ExtractService;
import calculator.number.Calculator;
import calculator.separator.SeparatorService;
import calculator.view.Input;
import calculator.view.Output;

public class Controller {
    private final SeparatorService separatorService;
    private final ExtractService extractService;
    private final Calculator<?> calculator;

    public Controller(SeparatorService separatorService, ExtractService extractService, Calculator<?> calculator) {
        this.separatorService = separatorService;
        this.extractService = extractService;
        this.calculator = calculator;
    }

    public void run() {
        String inputText = Input.start();
        searchInputText(inputText);
        Output.end(calculator.getTotal());
    }

    private void searchInputText(String inputText) {
        for (int index = 0; index < inputText.length(); index++) {
            char currentChar = inputText.charAt(index);

            if (Character.isDigit(currentChar)) {
                calculator.temporarySave(currentChar);
                continue;
            } else {
                calculator.save();
            }

            if (separatorService.isAllowedSeparator(currentChar)) {
                continue;
            }

            getAndSaveCustomSeparator(inputText, index);
            index = passRemainSeparator(index);
        }
    }

    private void getAndSaveCustomSeparator(String inputText, int index) {
        Character customSeparator = extractService.getCustomSeparator(inputText, index);
        separatorService.saveCustomSeparator(customSeparator);
    }

    private int passRemainSeparator(int index) {
        index += extractService.getSeparatorLength();
        return index;
    }
}
