package calculator;

import java.util.regex.Pattern;

public class StringValidator {

    private final String PREFIX = "//";
    private final String SUFFIX = "\\n";

    public void validate(String input) {
        if (hasDelimiterDeclaration(input)) {
            if (isCustomDelimiterMissing(input)) {
                throw new IllegalArgumentException("커스텀 구분자 선언부에 구분 기호가 누락되었습니다.");
            }
            if (hasInteger(input)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 제외한 문자만 사용 가능합니다.");
            }
        }
        if (hasNonDelimiterCharacters(input)) {
            throw new IllegalArgumentException("구분자를 제외한 문자는 포함될 수 없습니다.");
        }
    }

    private boolean hasDelimiterDeclaration(String input) {
        return input.startsWith(PREFIX) && input.contains(SUFFIX);
    }

    private boolean isCustomDelimiterMissing(String input) {
        return input.indexOf(PREFIX) + 2 == input.indexOf(SUFFIX);
    }

    private boolean hasInteger(String input) {
        return input.substring(2, input.indexOf(SUFFIX)).matches(".*\\d.*");
    }

    private boolean hasNonDelimiterCharacters(String input) {
        if (hasNoDelimiterDeclaration(input)) {
            return !input.matches("^[0-9:,]+$");
        }
        String customDelimiter = input.substring(2, input.indexOf(SUFFIX));
        String calculationValue = input.substring(input.indexOf(SUFFIX) + 2);
        return !calculationValue.matches("^[\\d:," + Pattern.quote(customDelimiter) + "]+$");
    }

    private boolean hasNoDelimiterDeclaration(String input) {
        return !input.startsWith(PREFIX) || !input.contains(SUFFIX);
    }
}
