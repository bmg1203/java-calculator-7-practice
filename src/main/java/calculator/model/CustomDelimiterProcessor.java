package calculator.model;

public class CustomDelimiterProcessor {
    public static boolean usesCustomDelimiter(String inputString) {
        char firstChar = inputString.charAt(0);
        return firstChar == '/';
    }

    public void correctCustomDelimiterFormatOrThrow(String inputString) {
        if (!checkCustomDelimiterFormatLength(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterFirstFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
        if (isCustomDelimiterLastFormatCorrect(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkCustomDelimiterFormatLength(String inputString) {
        return inputString.length() >= 5;
    }

    public boolean isCustomDelimiterFirstFormatCorrect(String inputString) {
        String firstFormat = inputString.substring(0, 1);
        return firstFormat.equals("//");
    }

    public boolean isCustomDelimiterLastFormatCorrect(String inputString) {
        String lastFormat = inputString.substring(3, 4);
        return lastFormat.equals("\n");
    }
}
