package calculator.util;

import static calculator.message.Delimiter.CUSTOM_DELIMITER;
import static calculator.message.Delimiter.DELIMITERS;
import static calculator.message.ErrorMessage.EMPTY_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.INVALID_ELEMENT_MESSAGE;
import static calculator.message.ErrorMessage.TOO_LARGE_NUMBER_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {
    public static List<Integer> processString(String str) {
        List<String> stringList = splitByDelimiter(str);
        List<Integer> intList = convertToIntList(stringList);

        // 정수 리스트에 음수가 있다면 예외 처리
        Validator.isNegativeNumber(intList);

        return intList;
    }

    // 구분자를 기준으로 문자열을 나눠서 리스트에 저장
    public static List<String> splitByDelimiter(String str) {
        checkAndApplyCustomDelimiter();

        return Arrays.asList(str.split(DELIMITERS));
    }

    private static void checkAndApplyCustomDelimiter() {
        if (CUSTOM_DELIMITER != null && !CUSTOM_DELIMITER.isEmpty()) {
            DELIMITERS += "|" + Pattern.quote(CUSTOM_DELIMITER);
        }
    }

    // 문자열 리스트를 정수 리스트로 변환
    private static List<Integer> convertToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();

        for (String element : stringList) {
            if (isEmpty(element)) {
                throw new IllegalArgumentException(EMPTY_ELEMENT_MESSAGE);
            }

            try {
                int number = Integer.parseInt(element);
                intList.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(TOO_LARGE_NUMBER_MESSAGE);
            } catch (Exception e) {
                throw new IllegalArgumentException(INVALID_ELEMENT_MESSAGE);
            }
        }

        return intList;
    }

    private static boolean isEmpty(String element) {
        return element.isEmpty();
    }
}