package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final String input;

    public InputData(String input) {
        this.input = input;
    }

    public void validate(String input){
        Pattern endPattern = Pattern.compile(".*[0-9]$");
        Matcher endMatcher = endPattern.matcher(input);

        Pattern startPattern = Pattern.compile("^[0-9](.*)");
        Matcher startMatcher = startPattern.matcher(input);

        if(!endMatcher.matches()){
            throw new IllegalArgumentException("[ERROR][F0001] 마지막 입력값은 숫자여야 합니다.");
        }

        if(!isDelimiter() && !startMatcher.matches()){
            throw new IllegalArgumentException("[ERROR][F0002] 커스텀 구분자가 없는 경우 시작 입력값은 숫자여야 합니다.");
        }
    }

    public boolean isDelimiter(){
        Pattern delimiterPattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher delimiterMatcher = delimiterPattern.matcher(input);

        return delimiterMatcher.matches();
    }

    public String convertDelimiterPart(){
        Pattern delimiterPattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher delimiterMatcher = delimiterPattern.matcher(input);
        String delimiter = "";

        if(delimiterMatcher.matches()){
            delimiter = delimiterMatcher.group(1);
        }
        return delimiter;
    }

    public String convertCalculatorPart() {
        Pattern delimiterPattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher delimiterMatcher = delimiterPattern.matcher(input);
        String calculator = "";

        if(delimiterMatcher.matches()){
            calculator = delimiterMatcher.group(2);
        }
        return calculator;
    }
}
