package calculator.model;

import java.util.List;

public class Numbers {
    private final List<String> numbers;

    private Numbers(final List<String> numbers) {
        this.numbers = numbers;
    }

    public static Numbers createNumbers(final List<String> numbers) {
        return new Numbers(numbers);
    }

    public double add() {
        double sum = 0;
        for (String number : numbers) {
            sum += Double.parseDouble(number);
        }
        return sum;
    }
}
