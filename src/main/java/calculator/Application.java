package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private String processNull(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }

    private String extractCustomSymbols(String input) {
        if (input.indexOf("/") == 0) {
            int startIndex = input.indexOf("/") + 2;
            int endIndex = input.indexOf("\\");
            return input.substring(startIndex, endIndex);
        }
        return "";
    }

    private void validateInput(String input, String custom) {
        if (!custom.isEmpty()) {
            if (custom.matches("^[0-9]*$")) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자나 문자를 포함할 수 없습니다.");
            }
            String subInput = input.substring(5);
            String allowedCharsPattern = "^[0-9, : " + custom + "]*$";
            if (!subInput.matches(allowedCharsPattern)) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        } else {
            String allowedCharsPattern = "^[0-9, :]*$";
            if (!input.matches(allowedCharsPattern)) {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }
    }

    private String[] splitString(String input, String custom) {
        if (custom.isEmpty()) {
            return input.split("[,:]");
        } else {
            return input.substring(5).split("[,:" + custom + "]");
        }
    }

    private int sumArray(String[] arr) {
        int sum = 0;
        for (String value : arr) {
            if (!value.isEmpty()) {
                sum += Integer.parseInt(value);
            }
        }
        return sum;
    }

    public void run() {
        String input = Console.readLine();
        String result = processNull(input);
        String custom = extractCustomSymbols(result);
        validateInput(result, custom);
        String[] temp = splitString(result, custom);
        int sum = sumArray(temp);
        System.out.println("결과 : " + sum);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}