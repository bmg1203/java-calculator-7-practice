package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startCalculate(){
        Calculator calculator = new Calculator(inputView.input());
        String selectSplitString = calculator.selectSplitString();
        List<String> stringList = calculator.splitList(selectSplitString);
        List<Integer> integerList = calculator.parseIntegerList(stringList);
        int result = calculator.addNumber(integerList);
        outputView.printResult(result);
    }

}
