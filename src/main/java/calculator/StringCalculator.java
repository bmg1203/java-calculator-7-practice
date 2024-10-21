package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input){
        String delimiters = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Pattern pattern = Pattern.compile("//(.)\\\\n");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String customDelimiter = matcher.group(1);
                input = input.replaceFirst(pattern.pattern(),"");
                delimiters += "|" + Pattern.quote(customDelimiter);
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }

        // 구분자를 기준으로 문자열 분리
        String[] numbers = input.split(delimiters);
        int sum = 0;

        try {
            for (String number : numbers) {
                if (!number.isEmpty()) {
                    int num = Integer.parseInt(number);
                    if (num < 0) {// 음수 값 입력시
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                    sum += num;
                }
            }
        } catch (NumberFormatException e) { //숫자가 아닌 값 입력시,
            throw new IllegalArgumentException("잘못된 입력 값입니다. 숫자만 포함되어야 합니다.");
        }

        return sum;
    }
}