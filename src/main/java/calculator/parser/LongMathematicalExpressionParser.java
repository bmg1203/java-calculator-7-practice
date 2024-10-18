package calculator.parser;

import java.util.Arrays;
import java.util.regex.Pattern;

public class LongMathematicalExpressionParser implements MathematicalExpressionParser {
	public static final String VALID_MATHEMATICAL_EXPRESSION_PATTERN = "(\\d+\\D)*\\d+$";
	private static final Pattern VALID_PATTERN = Pattern.compile(VALID_MATHEMATICAL_EXPRESSION_PATTERN);

	private long stringNumberToNumber(String stringNumber) {
		try {
			long number = Long.parseLong(stringNumber);
			if (number <= 0) {
				throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
			}
			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ParserError.INVALID_FORMAT_NUMBER.getMessage());
		}

	}

	private void isValid(String expression) {
		if (!VALID_PATTERN.matcher(expression).matches()) {
			throw new IllegalArgumentException(ParserError.INVALID_MATHEMATICAL_EXPRESSION.getMessage());
		}
	}

	@Override
	public long[] parse(String expression, String separatorRegex) {
		isValid(expression);
		String[] stringNumbers = expression.split(separatorRegex);

		return Arrays.stream(stringNumbers)
			.mapToLong(this::stringNumberToNumber)
			.toArray();
	}
}
