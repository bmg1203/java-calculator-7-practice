package calculator.service;

import calculator.service.command.Command;
import calculator.service.command.CommandExtractor;
import calculator.service.expression.Expression;
import calculator.service.separator.Separators;
import calculator.util.Constants;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    private final CommandExtractor commandExtractor;
    private final Separators separators;

    public CalculatorService() {
        commandExtractor = CommandExtractor.init();
        separators = Separators.init();
    }

    public Number calculate(String input) {
        Command command = commandExtractor.extract(input);
        if (command.hasCustomSeparator()) {
            separators.add(command.customSeparator());
        }
        Expression expression = command.expression();
        return getExpressionResult(expression);
    }

    private Number getExpressionResult(Expression expression) {
        List<Double> values = splitExpressionToPositiveNumber(expression);
        double result = sum(values);
        return transformResultType(result);
    }

    private List<Double> splitExpressionToPositiveNumber(Expression expression) {
        String[] separatedValues = expression.split(separators);
        validateOperandsAndSeparatorsCount(expression);
        return convertToPositiveNumber(separatedValues);
    }

    private void validateOperandsAndSeparatorsCount(Expression expression) {
        long operandsCount = expression.getOperandCount(separators);
        long separatorsCount = expression.getSeparatorCount(separators);
        if (operandsCount != separatorsCount + 1) {
            throw new IllegalArgumentException("구분자와 숫자의 개수가 맞지 않습니다. 입력값을 확인해주세요.");
        }
    }

    private List<Double> convertToPositiveNumber(String[] separatedValues) {
        return Arrays.stream(separatedValues)
                .map(this::convertToPositiveDouble)
                .toList();
    }

    private Double convertToPositiveDouble(String value) {
        validatePositiveNumber(value);
        return Double.parseDouble(value);
    }

    private void validatePositiveNumber(String value) {
        if (value.isEmpty() || !value.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("양수만 계산할 수 있어요. 입력하신 식을 확인해주세요.");
        }
    }

    private double sum(List<Double> values) {
        return values.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private Number transformResultType(double result) {
        if (isWholeNumber(result)) {
            checkLongRange(result);
            return (long) result;
        }
        checkDoubleRange(result);
        return result;
    }

    private boolean isWholeNumber(double result) {
        return result % 1 == 0;
    }

    private void checkLongRange(double result) {
        if (result > Long.MAX_VALUE) {
            throw new IllegalArgumentException("계산 결과가 너무 커서 처리할 수 없습니다. 다른 숫자를 시도해 보세요.");
        }
    }

    private void checkDoubleRange(double result) {
        if (result > Double.MAX_VALUE) {
            throw new IllegalArgumentException("계산 결과가 너무 커서 처리할 수 없습니다. 다른 숫자를 시도해 보세요.");
        }
    }
}
