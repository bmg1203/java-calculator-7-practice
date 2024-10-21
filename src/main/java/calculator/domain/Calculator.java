package calculator.domain;

import calculator.processor.CustomInputProcessor;
import calculator.processor.DefaultInputProcessor;
import calculator.processor.InputProcessor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final Input input;
    private final Separator separator;
    private final InputView inputView;
    private final OutputView outputView;

    private Numbers number;

    public Calculator(Input input, Separator separator, InputView inputView,
        OutputView outputView) {
        this.input = input;
        this.separator = separator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        startProcess();
        InputProcessor inputProcessor =
            input.isDefaultInput() ? new DefaultInputProcessor() : new CustomInputProcessor();

        try {
            String[] parts = inputProcessor.processInput(input.getFirstInput(), separator);
            number = new Numbers(parts);
            showResultProcess();
            input.scClose();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void showResultProcess() {
        outputView.showResult(number.calculate());
    }

    private void startProcess() {
        inputView.showStartMessage();
        input.readFirstInput();
    }
}
