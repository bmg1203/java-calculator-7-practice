package calculator.model;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import calculator.constant.ErrorMessage;

public class Delimiter {
	private static final int STRICT_LENGTH = 1;
	private static final String EMPTY = "";
	private static final String SELECT_ONE_FORMAT = "[%s]";
	private static final Pattern SINGLE_NUMERIC_PATTERN = Pattern.compile("^[0-9]$");

	private final String delimiter;

	private Delimiter(String delimiter) {
		validateLength(delimiter);
		validateNotNumber(delimiter);

		this.delimiter = delimiter;
	}

	public static Delimiter from(String delimiter) {
		return new Delimiter(delimiter.trim());
	}

	private void validateLength(String delimiter) {
		if (delimiter.isBlank() || delimiter.length() > STRICT_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_LENGTH.getMessage());
		}
	}

	private void validateNotNumber(String delimiter) {
		if (SINGLE_NUMERIC_PATTERN.matcher(delimiter).matches()) {
			throw new IllegalArgumentException(ErrorMessage.DELIMITER_NOT_NUMBER.getMessage());
		}
	}

	public static String toRegex(List<Delimiter> delimiters) {
		return String.format(
			SELECT_ONE_FORMAT,
			String.join(EMPTY, delimiters.stream().map(delimiter -> delimiter.delimiter).toList())
		);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Delimiter that = (Delimiter)o;
		return Objects.equals(this.delimiter, that.delimiter);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(delimiter);
	}
}