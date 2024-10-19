package calculator;

public class ParsingString {
    private static final int BASIC_DELIMITER_SIZE = 3;
    private static int findStartIndex;
    private static String parseString;

    public static String parsingString(String input, String delimiter) {
        findStartString(input, delimiter);
        isNumeric(parseString, delimiter);
        return parseString;
    }

    public static void findStartString(String input, String delimiter) {
        if (delimiter.length() != BASIC_DELIMITER_SIZE) {
            findStartIndex = 5;
            if (delimiter.length() == 4) {
                findStartIndex = 4;
            }
        }
        parseString = input.substring(findStartIndex);
    }

    public static void isNumeric(String startString, String delimiter) {
        String[] list = startString.split(delimiter);

        for (String digit : list) {
            if (digit.isEmpty()) {
                continue;
            }
            if (!digit.matches("\\d+")) {
                throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
            }
        }
    }
}
