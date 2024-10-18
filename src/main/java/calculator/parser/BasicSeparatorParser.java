package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicSeparatorParser implements SeparatorParser {

	public static final String BASIC_CUSTOM_SEPARATOR_PATTERN = "(/{2})(\\D)(\\\\n)";
	private static final Pattern PATTERN = Pattern.compile(BASIC_CUSTOM_SEPARATOR_PATTERN);
	private static final String BASIC_VALID_CUSTOM_SEPARATOR_PATTERN = "^(/{2}\\D\\\\n)*";
	private static final Pattern VALID_PATTERN = Pattern.compile(BASIC_VALID_CUSTOM_SEPARATOR_PATTERN);
	private static final List<Character> BASIC_SEPARATORS = Arrays.asList(new Character[] {',', ':'});


	private void isValid(String expression){
		if(!VALID_PATTERN.matcher(expression).matches()){
			throw new IllegalArgumentException(ParserError.INVALID_SEPARATOR_EXPRESSION.getMessage());
		}
	}

	@Override
	public void parse(String expression, Set<Character> separators) {
		isValid(expression);
		Matcher matcher = PATTERN.matcher(expression);
		separators.addAll(BASIC_SEPARATORS);

		while (matcher.find()) {
			char customSeparator = matcher.group(2).charAt(0);

			if (!separators.add(customSeparator)) {
				throw new IllegalArgumentException(ParserError.DUPLICATION_SEPARATOR.getMessage());
			}
		}
	}

	@Override
	public String generateRegex(Set<Character> separators) {
		if (separators.isEmpty()) {
			return "";
		}
		StringBuilder separatorPattern = new StringBuilder();

		for (char separator : separators) {
			separatorPattern.append("|\\").append(separator);
		}

		separatorPattern.delete(0, 2);
		return separatorPattern.toString();
	}

}
