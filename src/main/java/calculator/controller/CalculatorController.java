package calculator.controller;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.exception.InputStringException;
import calculator.service.CalculateService;
import calculator.util.OutputUtil;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final OutputUtil outputUtil = new OutputUtil();
    private final InputStringException inputStringException = new InputStringException();
    private final CalculateService calculateService = new CalculateService();
    public void startCalculating(){
        Numbers numbers = new Numbers();
        Delimiters delimiters = new Delimiters();

        outputUtil.printProgramStart();
        String inputString = Console.readLine();

        numbers = inputStringException.validateInputPattern(inputString, numbers, delimiters);
        outputUtil.printResultPhrase();
        outputUtil.printResult(calculateService.calculateSum(numbers));

    }
}
