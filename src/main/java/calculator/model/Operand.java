package calculator.model;

public class Operand {
    private final int[] numbers;

    private Operand(String delimiter, String expression) {
        if (expression.isEmpty()) {
            this.numbers = new int[] {0};
            return;
        }

        String[] numbers = expression.split(delimiter);
        this.numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i] = Integer.parseInt(numbers[i]);
        }
    }

    public static Operand create(String delimiter, String expression) {
        return new Operand(delimiter, expression);
    }

    public int[] getNumbers() {
        return numbers;
    }
}
