package calculator;

public class StringCalculator {

    public  int add(String text) {
        if (text.isEmpty() || text == null) {
            return 0;
        }

        String delimiter = ",|:";

        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterIndex);
            text = text.substring(delimiterIndex + 1);
        }

        String[] tokens = splitNumbers(text, delimiter);
        return sumNumbers(tokens);
    }

    private String[] splitNumbers(String text, String delimiter) {
        for (char ch : delimiter.toCharArray()) {
            text = text.replace(ch, ',');
        }
        return text.split(",");
    }

    private int sumNumbers(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = changeNumber(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
            sum += number;
        }
        return sum;
    }

    private int changeNumber(String token) {
        if (token.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(token);
    }
}
