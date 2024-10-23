package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
	private final String checkDelimiterPattern = "^//(.)\\\\n";

	private String userInput;
	private final List<String> delimiters;

	public StringCalculator() {
		userInput = null;
		delimiters = new ArrayList<>(Arrays.asList(",", ":"));
	}

	public void run() {
		userInput = getUserInput();
		String customDelimiter = getCustomDelimiter(userInput);
		if (customDelimiter != null) {
			addCustomDelimiter(customDelimiter);
		}

		long result = calculateSum(userInput, delimiters);
		System.out.printf("결과 : %d", result);
	}

	private String getUserInput() {
		return Console.readLine();
	}

	public String getCustomDelimiter(String userInput) {
		String checkNumberPattern = "[0-9]";

		Pattern pattern = Pattern.compile(checkDelimiterPattern);
		Matcher matcher = pattern.matcher(userInput);

		if (!matcher.find()) {
			return null;
		}

		String result = matcher.group(1);
		if (Pattern.matches(checkNumberPattern, result)) {
			throw new IllegalArgumentException("Cannot specify a number with a custom delimiter.");
		}

		return result;
	}

	private void addCustomDelimiter(String delimiter) {
		delimiters.add(delimiter);
	}

	public long calculateSum(String userInput, List<String> delimiters) {
		String removed = removeHeaderFromInput(userInput);
		List<String> numbers = splitStringByDelimiters(removed, delimiters);

		long returnValue = 0;
		for (String number : numbers) {
			long result = parseLong(number);
			returnValue += result;
		}
		return returnValue;
	}

	private long parseLong(String number) {
		try {
			long result = Long.parseLong(number);

			if (result < 0) {
				throw new IllegalArgumentException("Negative input is not possible.");
			}

			return result;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("The value entered is not a number.");
		}
	}

	public List<String> splitStringByDelimiters(String target, List<String> delimiters) {
		if (target.isEmpty()) {
			return new ArrayList<>();
		}

		String pattern = "[%s]".formatted(Pattern.quote(String.join("", delimiters)));
		String[] result = target.split(pattern);
		return List.of(result);
	}

	public String removeHeaderFromInput(String userInput) {
		Pattern pattern = Pattern.compile(checkDelimiterPattern);
		Matcher matcher = pattern.matcher(userInput);

		if (!matcher.find()) {
			return userInput;
		}

		return matcher.replaceFirst("");
	}
}
