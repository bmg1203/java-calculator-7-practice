package calculator.model;

import calculator.constants.ErrorMessages;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public Double getSum() {
        return numbers.stream()
                .mapToDouble(Number::getNumber)
                .sum();
    }

    private void validateNumbers(List<Number> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBERS_EMPTY_MESSAGE.getErrorMessage());
        }
    }
}
