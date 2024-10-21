package calculator.model;

import calculator.utils.IntegerExtractor;
import calculator.utils.SumExpression;

public class CalculatorImpl implements Calculator{

    private final CalculatorValues calculatorValues;

    public CalculatorImpl() {
        this.calculatorValues = new CalculatorValues();
    }

    @Override
    public void insertValues(String input) {
        if (input.matches("^//.\\\\n.*")) {
            calculatorValues.setExpression(input.substring(5));
            calculatorValues.setDelimiter(String.valueOf(input.charAt(2)));
            return;
        }
        calculatorValues.setExpression(input);
        calculatorValues.setDelimiter("[,:]");
    }

    @Override
    public void extract() {
        IntegerExtractor.extractIntegerFromExpression(calculatorValues);
    }

    @Override
    public int sum() {
        return SumExpression.sum(calculatorValues);
    }
}