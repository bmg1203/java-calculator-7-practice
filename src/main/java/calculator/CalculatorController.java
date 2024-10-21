package calculator;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void runProgram() {
        String userInput = calculatorView.getUserInput();
        long result = calculatorModel.calculateSum(userInput);
        calculatorView.showResult(result);


    }
}
