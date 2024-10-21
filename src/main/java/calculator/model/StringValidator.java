package calculator.model;

import java.util.List;
import java.util.stream.Stream;

public class StringValidator {

	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ":";
	private static final String ERROR_MESSAGE = "잘못된 문자열 형식입니다.";
	private static final int INPUT_START_INDEX = 0;
	private static final int DELIMITER_LENGTH = 1;

	private final String input;
	private final List<Delimiter> delimiters;

	public StringValidator(String input) {
		this.input = input;
		this.delimiters = Stream.of(COMMA_DELIMITER, COLON_DELIMITER)
			    .map(Delimiter::new)
			    .toList();
	}

	public StringValidator(String input, String customDelimiter) {
		this.input = input;
		this.delimiters = Stream.of(COMMA_DELIMITER, COLON_DELIMITER, customDelimiter)
		        .map(Delimiter::new)
			    .toList();
	}

	public List<Delimiter> getDelimiters() {
		return this.delimiters;
	}

	public String getInput() {
		return this.input;
	}

	public void validate() {
		checkInputSide();
		int index = INPUT_START_INDEX;
		Status status = Status.checkStatus(input);
		while (index < input.length()) {
			index = this.checkInputStatus(input, index, status);
			status = Status.changeStatus(status);
		}
	}

	private void checkInputSide() {
		if (!input.isEmpty() && (checkInputStartIsNotDelimiter() || checkInputEndIsNotDelimiter())) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	private boolean checkInputStartIsNotDelimiter() {
		return !Character.isDigit(input.charAt(INPUT_START_INDEX)) && !input.startsWith(CUSTOM_DELIMITER_PREFIX);
	}

	private boolean checkInputEndIsNotDelimiter() {
		return !input.isEmpty() && !Character.isDigit(input.charAt(input.length() - 1));
	}

	private int checkInputStatus(String input, int index, Status status) {
		return switch (status) {
			case DIGIT -> this.checkInputDigit(input, index);
			case DELIMITER -> this.checkInputDelimiter(input, index);
		};
	}

	private int checkInputDigit(String input, int index) {
		if (!Character.isDigit(input.charAt(index))) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		while (index < input.length() && Character.isDigit(input.charAt(index))) {
			index++;
		}
		return index;
	}

	private int checkInputDelimiter(String input, int index) {
		String inputDelimiter = input.substring(index, index + DELIMITER_LENGTH);
		if (checkDelimiterIsExist(inputDelimiter)) {
			return index + DELIMITER_LENGTH;
		}
		throw new IllegalArgumentException(ERROR_MESSAGE);
	}

	private boolean checkDelimiterIsExist(String input) {
		return delimiters.stream()
			    .anyMatch(delimiter -> delimiter.compare(input));
	}
}
