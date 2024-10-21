package calculator.extractor;


import static calculator.exception.ExceptionMessage.EMPTY_DELIMITER;
import static calculator.exception.ExceptionMessage.INVALID_DELIMITER_FORMAT;

public class StringSplitterImpl implements StringSplitter {

    @Override
    public String[] split(String input) {
        if (input == null || input.isEmpty() || input.equals("\"\"")) {
            return new String[]{""};
        }
        if (input.startsWith("//")) {
            return customDelimiter(input);
        }
        return defaultDelimiter(input);
    }

    private String[] defaultDelimiter(String input) {
        validateDelimiter(input);

        String[] result = input.split("[,:]");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null || result[i].isEmpty()) {
                result[i] = "";
            }
        }
        return result;
    }

    private String[] customDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException(INVALID_DELIMITER_FORMAT.getMessage());
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_DELIMITER.getMessage());
        }
        return input.substring(delimiterEndIndex + 2).split(customDelimiter);
    }

    private void validateDelimiter(String input) {
        boolean containsInvalidDelimiter =
                input.matches(".*[\\|\\\\\\n\\t\\r\\f\\s].*") || input.matches(".*[^0-9a-zA-Z,:-].*");

        if (containsInvalidDelimiter) {
            throw new IllegalArgumentException(INVALID_DELIMITER_FORMAT.getMessage());
        }
    }
}
