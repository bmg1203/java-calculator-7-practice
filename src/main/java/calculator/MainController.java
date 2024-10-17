package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        List<String> splittedValues ;
        int sumResult = 0;

        if (checkCustomDelimter(inputString)){
            splittedValues = SplitbyCustomDelimiter(inputString);

            for (String part : splittedValues) {
                checkNagativeInt(Integer.parseInt(part));
                sumResult += Integer.parseInt(part);
            }
            System.out.printf("결과 : %d", sumResult);
            return;
        };

        splittedValues = SplitbyDefaultDelimiter(inputString);
        for (String part : splittedValues) {
            checkNagativeInt(Integer.parseInt(part));
            sumResult += Integer.parseInt(part);
        }
        System.out.printf("결과 : %d", sumResult);
    }

    private static void checkNagativeInt(int part) {
        if (part < 0) {
            throw new IllegalArgumentException("음수값은 덧셈 할 수 없습니다.");
        }
    }

    private static Boolean checkCustomDelimter(String inputString) {
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        return prefix.equals("//") && suffix.equals("\\n");
    }

    private static List<String> SplitbyDefaultDelimiter(String inputString) {
        //inputString에 기본구분자가 없는경우 예외처리
        containsDefaultDelimiter(inputString);

        List<String> defaultSplitValues = Arrays.asList(inputString.split(",|:"));

        return defaultSplitValues;
    }

    private static void containsDefaultDelimiter(String inputString) {
        if (!inputString.contains(",") && !inputString.contains(":")) {
            throw new IllegalArgumentException("기본 구분자가 포함되어 있지 않습니다.");
        }
    }

    private static List<String> SplitbyCustomDelimiter(String inputString) {
        String prefix = inputString.substring(0, 2);
        String suffix = inputString.substring(3, 5);
        String customDelimiter = "";

        if (prefix.equals("//") && suffix.equals("\\n")) {
            customDelimiter = String.valueOf(inputString.charAt(2));
        }
        String remainingInput = inputString.substring(5);
        List<String> customSplitValues = Arrays.asList(remainingInput.split(customDelimiter));
        return customSplitValues;
    }

}
