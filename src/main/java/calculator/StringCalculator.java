package calculator;

import static calculator.Validator.validateCustomSeparator;
import static calculator.Validator.validateString;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    String separators = ",:";
    boolean hasCustomSeparator;
    int sumValue;

    void run() {
        printInputMsg();
        String input = Console.readLine();
        if (hasCustomPart(input)) {
            if (validateCustomSeparator(input)) {
                addCustomSeparator(input.charAt(2));
            } else {
                throw new IllegalArgumentException("커스텀 구분자 에러");
            }
        }

        String str = initString(input);
        validateString(str, separators);

        String[] separatedNumbers = str.split('[' + separators + ']');
        calculateSumValue(separatedNumbers);
        System.out.println("결과 : " + sumValue);
    }

    void printInputMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    void calculateSumValue(String[] separatedNumbers) {
        sumValue = 0;
        for (String number : separatedNumbers) {
            if (!number.isEmpty()) {
                sumValue += Integer.parseInt(number);
            }
        }
    }

    boolean hasCustomPart(String input) {
        if (input.startsWith("//")) {
            return input.contains("\\n");
        }
        return false;
    }

    void addCustomSeparator(char customSeparator) {
        hasCustomSeparator = true;
        separators += customSeparator;
    }

    String initString(String input) {
        String str = input;
        if (hasCustomSeparator) {
            int strStartIdx = input.indexOf("\\n") + 2;
            str = input.substring(strStartIdx);
        }
        return str;
    }
}
