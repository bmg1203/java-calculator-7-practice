package calculator.config;

public enum CustomDelimiterPattern {
	START("//"),
	END("\\n");

	private final String pattern;

	CustomDelimiterPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	public int getPatternLength() {
		return pattern.length();
	}
}
