package calculator.util;

import calculator.domain.Calculator;
import calculator.domain.Tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public Tokens parse(String input) {

        if(input.startsWith("//")){
            return parseTokens(parseCustomDelimiter(input));
        }
        return parseTokens(new Calculator(input));
    }

    private Calculator parseCustomDelimiter(String input) {
        String delimiter =  DEFAULT_DELIMITERS;
        String numbers = input;

        Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);
        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            delimiter =  DEFAULT_DELIMITERS + "|" + customDelimiter;
            numbers = matcher.group(2);

            return new Calculator(delimiter, numbers);
        }else{
            throw new IllegalArgumentException(input + " : 잘못된 커스텀 구분자 형식입니다.");
        }
    }

    private Tokens parseTokens(Calculator calculator) {
        String[] tokens = calculator.getNumbers().split(calculator.getDelimiter());
        return new Tokens(tokens);
    }
}
