package calculator.domain;

import java.util.regex.Pattern;

import static calculator.constants.DelimiterConstants.COLON;
import static calculator.constants.DelimiterConstants.COMMA;

public class StringSplitter {

    private static final String END_OF_CUSTOM_DELIMITER_FORMAT = "n";
    private static final int NEXT_INDEX = 1;

    private final CustomDelimiterExtractor customDelimiterExtractor;

    public StringSplitter(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    /*
          "|" 기호는 정규 표현식에서 "또는"의 의미를 가지고 있습니다.
          즉, 아래 split 코드는 customDelimiter, COLON, 또는 COMMA 로 문자열을 나누겠다는 뜻입니다.
     */
    public String[] getNumberStringsToAdd(String stringToAdd) {
        String customDelimiter = customDelimiterExtractor.getCustomDelimiter(stringToAdd);
        if (customDelimiter.isEmpty()) {
            return stringToAdd.split(COLON + "|" + COMMA);
        }
        stringToAdd = changeStringWithoutFormat(stringToAdd);
        return stringToAdd.split(Pattern.quote(customDelimiter) + "|" + COLON + "|" + COMMA);
    }

    private String changeStringWithoutFormat(String stringWithDelimiter) {
        int indexOfLastString = stringWithDelimiter.indexOf(END_OF_CUSTOM_DELIMITER_FORMAT);
        return stringWithDelimiter.substring(indexOfLastString + NEXT_INDEX);
    }
}
