package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 숫자 입력 기능
        String inputNumber = inputNumber();
        // 빈 문자열
        if (inputNumber.isEmpty()) {
            System.out.print("결과 : 0");
            return;
        }
        // 구분자 분리 기능
        String[] splitInputNumber = splitInputNumber(inputNumber);
        // 구분된 문자열이 양수인 문자열인지 체크1
        validateSplitNumber(splitInputNumber);
        // 결과 출력
        printResult(splitInputNumber);

    }

    private static String inputNumber() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static String[] splitInputNumber(String inputNumber) {
        String defaultDelimiter = ",|:";
        String[] splitInputNumber;
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(inputNumber);

        if (matcher.find()) {
            // 커스텀 구분자가 있을 때
            String inputDelimiter = matcher.group(1);
            inputNumber = matcher.replaceFirst("");

            String delimiter = buildDelimiter(defaultDelimiter, inputDelimiter);
            splitInputNumber = inputNumber.split(delimiter);
        } else {
            // 커스텀 구분자가 없을 때
            splitInputNumber = inputNumber.split(defaultDelimiter);
        }
        return splitInputNumber;
    }

    private static String buildDelimiter(String defaultDelimiter, String inputDelimiter) {
        // 특수 문자를 이스케이프 처리
        String escapedDelimiter = escapeSpecialCharacters(inputDelimiter);
        return defaultDelimiter + "|" + "[" + escapedDelimiter + "]";
    }

    private static String escapeSpecialCharacters(String delimiter) {
        return delimiter.replaceAll("([\\\\+*?\\[\\](){}|.^$])", "\\\\$1");
    }

    private static void validateSplitNumber(String[] splitInputNumber) {
        for (String number : splitInputNumber) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void printResult(String[] splitInputNumber) {
        int result = 0;
        for (String number : splitInputNumber) {
            result += Integer.parseInt(number);
        }

        System.out.print("결과 : " + result);
    }
}
