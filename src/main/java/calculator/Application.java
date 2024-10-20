package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String customSeperator = "";

        if (isCustomSeperator(input)) customSeperator = extractCustomSeperator(input);

        try {
            int[] number = Arrays.stream(splitBySeperator(input, customSeperator)).mapToInt(Integer::parseInt).toArray();
            int result = sumCalculate(number);

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {}
    }

    public static boolean isCustomSeperator(String input) {
        return input.contains("//") && input.contains("\\n");
    }

    public static String extractCustomSeperator(String input) {
        int start = input.indexOf("//") + 2; // 커스텀 문자 인덱스 시작
        int end = input.indexOf("\\n"); // 커스텀 문자 인덱스 끝

        return input.substring(start, end);
    }

    public static String[] splitBySeperator(String input, String customSeperator) {
        String seperator = ",|:";
        if (input.equals("")) return new String[]{"0"};

        if (!customSeperator.equals("")) {
            input = input.replace("//" + customSeperator + "\\n", "");
            seperator = ",|:|" + customSeperator;
        }
        String[] number = input.split(seperator);

        return number;
    }

    public static int sumCalculate(int[] number) {
        int result = 0;

        for (int i : number) result += i;

        return result;
    }
}
