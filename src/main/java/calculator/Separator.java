package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Separator {

    private final Validator validator;

    public Separator(Validator validator) {
        this.validator = validator;
    }

    public BigDecimal separate(String userInput) {
        if (hasExistCustomSeparator(userInput)) {
            return existCustomSeparator(userInput);
        }
        return notExistCustomSeparator(userInput);
    }

    public boolean hasExistCustomSeparator(String userInput) {
        if (userInput == null) {
            return false;
        }
        if (userInput.startsWith("//")) {
            int index = userInput.indexOf("\\n");
            if (index > 2) {
                return true;
            }
            throw new IllegalArgumentException("커스텀 구분자가 올바르지 않은 형식입니다.");
        }
        return false;
    }

    public BigDecimal notExistCustomSeparator(String userInput) {
        BigDecimal zero = emptyCheck(userInput);
        if (zero != null) {
            return zero;
        }

        String delimiter = ",|:";
        BigDecimal sum = sumExpression(userInput, delimiter);

        return sum;
    }

    public BigDecimal existCustomSeparator(String userInput) {
        BigDecimal zero = emptyCheck(userInput);
        if (zero != null) {
            return zero;
        }

        String delimiter = ",|:";
        int index = userInput.indexOf("\\n");
        String customDelimiter = userInput.substring(2, 3);
        String expression = userInput.substring(index + 2);

        StringBuilder sb = new StringBuilder();
        sb.append(delimiter);
        sb.append("|");
        sb.append(customDelimiter);
        String newDelimiter = sb.toString();

        BigDecimal sum = sumExpression(expression, newDelimiter);

        return sum;
    }

    private BigDecimal emptyCheck(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return null;
    }

    private BigDecimal sumExpression(String userInput, String delimiter) {
        List<String> numbers = Arrays.asList(userInput.split(delimiter));
        validator.validate(userInput, numbers, delimiter);
        BigDecimal sum = BigDecimal.ZERO;

        for (String number : numbers) {
            sum = sum.add(new BigDecimal(number));
        }
        return sum;
    }
}
