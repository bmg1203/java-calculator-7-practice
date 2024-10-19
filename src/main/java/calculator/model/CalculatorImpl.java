package calculator.model;

import calculator.util.ValidatorUtil;

public class CalculatorImpl implements Calculator {

    private final ExtractNumber extractNumber;

    public CalculatorImpl(ExtractNumber extractNumber) {
        this.extractNumber = extractNumber;
    }

    @Override
    public int calculate(String input) {

        if (ValidatorUtil.isEmptyInput(input)) {
            return 0;
        }

        String[] numbers = extractNumber.extractNumberFromInput(input);

        return sum(numbers);
    }

    private int sum(String[] numbers) {

        int total = 0;

        for (String number : numbers) {
            try {

                int num = Integer.parseInt(number);

                if (ValidatorUtil.isNegativeNumber(num)) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }

                total += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }
        }

        return total;
    }
}
