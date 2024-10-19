package calculator.model;

public class Number {
    private String[] numString;
    private int[] numbers;
    private int sum;

    public Number(String[] numString) {
        this.numString = numString;
        this.sum = 0;
    }

    private boolean isNullString() {
        if (numString == null || numString.length == 0) {
            return true;
        }
        return false;
    }

    public void stringToInt() {
        if (isNullString()) {
            return;
        }

        numbers = new int[numString.length];
        for (int i = 0; i < numString.length; ++i) {
            try {
                numbers[i] = Integer.parseInt(numString[i]);

                if (numbers[i] < 1) {
                    throw new IllegalArgumentException("양수만 입력 가능합니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 이외에 숫자만 입력가능합니다.");
            }
        }
    }

    public int addCalculator() {
        stringToInt(); // addCalculator() 메서드가 먼저 호출되면 numbers 에 아무 문자열이 없으므로 내부에 선언

        if (isNullString()) {
            return sum;
        }

        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public int[] getNumbers() {
        return numbers;
    }
}
