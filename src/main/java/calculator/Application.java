package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String inputData = getInputData();
        boolean customStatus = isCustom(inputData);
    }

    private static String getInputData() {
        String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    private static boolean isCustom(String inputData) {
        return inputData.startsWith("//");
    }
}
