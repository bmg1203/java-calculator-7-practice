package calculator.parser;

import java.util.Set;

public interface SeparatorParser {

	public void parse(String text, Set<Character> separators);
}
