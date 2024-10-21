package calculator;

import calculator.dto.InputString;
import calculator.dto.SplittedResult;
import calculator.io.InputHandler;
import calculator.io.OutputHandler;
import calculator.splitor.Splitor;
import calculator.util.SplitorExtractor;

public class Calculator {
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final SplitorExtractor splitorExtractor = new SplitorExtractor();
    public void run() {
        InputString inputString = inputHandler.getInputString();

        Splitor splitor = splitorExtractor.extractSplitor(inputString);
        SplittedResult splittedResult = splitor.split();
        int sum = splittedResult.sum();

        outputHandler.outputResult(sum);
    }
}
