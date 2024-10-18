package calculator;

import calculator.parser.InputStringParser;
import calculator.validator.ListValidator;

import java.util.List;

public class Calculator {

    private final InputStringParser parser;
    private final ListCalculator calculator;

    public Calculator(InputStringParser parser, ListCalculator calculator) {
        this.parser = parser;
        this.calculator = calculator;
    }

    public long calculate(String input) throws IllegalArgumentException {
        try{
            List<Long> list = parser.parse(input);
            ListValidator.validateIsPosList(list);
            return calculator.calculate(list);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
}
