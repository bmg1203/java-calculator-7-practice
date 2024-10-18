package calculator;

public class CalculatorParser {
    private static final int CUSTOM_DELIMITER_LENGTH = 1;
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    private String customDelimiter = "";
    private final String expression;

    public CalculatorParser(String line) {
        int expressionStartIdx = 0;

        if (line.startsWith(CUSTOM_START)) {
            parseCustomDelimiter(line);
            checkEndsWithCustomEnd(line);
            expressionStartIdx = CUSTOM_START.length() + CUSTOM_DELIMITER_LENGTH + CUSTOM_END.length();
        }

        this.expression = line.substring(expressionStartIdx);
    }

    private void parseCustomDelimiter(String line) {
        // 커스텀 구분자가 없다면
        if (line.length() == CUSTOM_START.length()) {
            throw new IllegalArgumentException();
        }

        this.customDelimiter = line.charAt(CUSTOM_START.length()) + "";
    }

    private static void checkEndsWithCustomEnd(String line) {
        int customEndStart = CUSTOM_START.length() + CUSTOM_DELIMITER_LENGTH;

        // CUSTOM_END로 끝나지 않는다면
        if (!line.startsWith(CUSTOM_END, customEndStart)) {
            throw new IllegalArgumentException();
        }
    }

    public String getCustomDelimiter() {
        return this.customDelimiter;
    }

    public String getExpression() {
        return this.expression;
    }
}
