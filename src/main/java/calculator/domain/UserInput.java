package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private static final Pattern CUSTOM_SEPERATOR_PATTERN=Pattern.compile("^//(.)\\\\n(.*)");
    private static final Pattern MINUS_SEPERATOR=Pattern.compile("^//-\\\\n");
    private static final Pattern NUMBER_SEPERATOR=Pattern.compile("^//[0-9]\\\\n");
    private static final Pattern NEGATIVE=Pattern.compile("-[0-9]");

    private static final String ORIGIN_REGEX=",|;";

    private static final String NEGATIVE_INPUT="음수를 입력했습니다";
    private static final String MINUS_SEPERATOR_INPUT="마이너스 구분자를 입력했습니다";
    private static final String NUMBER_SEPERATOR_INPUT="숫자를 구분자로 입력했습니다";

    String input;
    String seperatorRegex;

    public String getInput() {
        return input;
    }

    public String getSeperatorRegex() {
        return seperatorRegex;
    }

    public UserInput(String input){
        validateNumberSeperator(input);
        validateMinusSeperator(input);
        validateNegative(input);

        this.input=input;
        this.seperatorRegex=ORIGIN_REGEX;
    }

    public UserInput checkExtractor(){
        Matcher matcher=CUSTOM_SEPERATOR_PATTERN.matcher(this.input);

        if (matcher.find()){
            String customSeperator=matcher.group(1);

            this.input= matcher.group(2);
            this.seperatorRegex=SeperatorFactory.addRegex(customSeperator);
        }
        return this;
    }

    public int startCalculate(){
        return Calculator.inputCalculate(input,seperatorRegex);
    }

    private void validateNegative(String input) {
        Matcher matcher=NEGATIVE.matcher(input);

        if (matcher.find()) {
            throw new IllegalArgumentException(NEGATIVE_INPUT);
        }
    }

    private void validateMinusSeperator(String input) {
        Matcher matcher=MINUS_SEPERATOR.matcher(input);

        if (matcher.find()){
            throw new IllegalArgumentException(MINUS_SEPERATOR_INPUT);
        }
    }

    private void validateNumberSeperator(String input) {
        Matcher matcher=NUMBER_SEPERATOR.matcher(input);

        if (matcher.find()){
            throw new IllegalArgumentException(NUMBER_SEPERATOR_INPUT);
        }
    }
}
