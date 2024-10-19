package calculator.domain;

public class NumberGenerator {
    private final SumCalculator sumCalculator;
    private String consecutiveNumbers = "";

    public NumberGenerator(SumCalculator sumCalculator) {
        this.sumCalculator = sumCalculator;
    }

    public void appendNumber(char number) {
        consecutiveNumbers += number;
    }

    public void handleDelimiter(boolean flag) {
        if (flag && !consecutiveNumbers.isEmpty()) {
            flushConsecutiveNumbers();
        }
    }

    public void flushConsecutiveNumbers() {
        if (!consecutiveNumbers.isEmpty()) {
            int parsedNumber = parsingToInteger(consecutiveNumbers);
            sumCalculator.add(parsedNumber);
            consecutiveNumbers = "";
        }
    }

    private int parsingToInteger(String number) {
        return Integer.parseInt(number);
    }
}
