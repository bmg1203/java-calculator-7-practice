package calculator.numbercalculator.number;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers empty() {
        return new Numbers(List.of());
    }

    public static Numbers of(List<String> strings) {
        List<Number> numbers = toNumbers(strings);
        return new Numbers(numbers);
    }

    private static List<Number> toNumbers(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(Number::of)
                .toList();
    }

    public int calculateTotalValue() {
        return numbers.stream()
                .mapToInt(Number::value)
                .sum();
    }
}
