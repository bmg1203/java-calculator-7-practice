package calculator.model;

import calculator.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.*)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";

    public static ArrayList<Integer> tokenize(String str){
        if (str == null || str.isEmpty()) {
            return new ArrayList<>(); // 빈 문자열은 합이 0이므로 빈 리스트 반환
        }

        String delimiter;
        String expression;

        if (str.startsWith("//")) {
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
            if(matcher.find()){
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자를 사용
                expression = matcher.group(2); // 표현식은 두 번째 그룹
            }
            else{
                throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAL.getErrorMessage());
            }
        } else {
            delimiter = DEFAULT_DELIMITER;
            expression = str;
        }

        // 유효한 기본 구분자만 있는지 확인
        if (!expression.matches("[0-9" + delimiter + "]+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getErrorMessage());
        }

        String[] tokens = expression.split(delimiter);
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!isNumeric(token)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE.getErrorMessage());
            }
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getErrorMessage());
            }
            numbers.add(number);
        }

        return numbers;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
