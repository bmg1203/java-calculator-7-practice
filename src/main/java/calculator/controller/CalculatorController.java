package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {
    private final CalculatorView calculatorView;
    private final CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        calculatorView = view;
        calculatorModel = model;
    }

    public void calculate() {
        String input = calculatorView.getInput();
        calculatorModel.setInput(input);
        List<Integer> operands = calculatorModel.parser();
        int result = calculatorModel.add(operands);
        calculatorView.printResult(result);
    }
}
