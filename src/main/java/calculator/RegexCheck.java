package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexCheck {
    private final String INPUT;
    private String[] stringNumbers = new String[0];
    private Matcher matcher;


    RegexCheck(String input) {
        this.INPUT = input;
    }

    private String setRegex(String delimiter) {
        return "([" + delimiter + "]*[-]?[0-9]+([" + delimiter + "]*[-]?[0-9]*)*)?";
    }

    public String[] getStringNumbers() {
        return stringNumbers;
    }

    public void inputValidator() {
        final String INPUT_REGEX = "(//([^0-9])\\\\n)?((?![^0-9]+$).*)";

        matcher = Pattern.compile(INPUT_REGEX).matcher(INPUT);

        if (INPUT.isEmpty()) return;

        if (matcher.matches()) {
            inputMatchesAndInsert();
        } else {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private void inputMatchesAndInsert() {
        String delimiter = matcher.group(2) != null ? matcher.group(2) : "[,:]";
        String numericString = matcher.group(3) != null ? matcher.group(3) : "";

        if (numericString.isEmpty()) return;

        stringNumbers = matchDelimiter(delimiter, numericString);
    }

    protected String[] matchDelimiter(String delimiter, String numericString) throws IllegalArgumentException {

        Matcher matcher = Pattern.compile(setRegex(delimiter)).matcher(numericString);

        if (matcher.matches()) {
            return numericString.split(delimiter);
        }

        throw new IllegalArgumentException("구분자가 잘못되었습니다.");
    }
}

