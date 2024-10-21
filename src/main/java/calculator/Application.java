package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static char[] basicSeparators = {',', ':'};
    private static char[] customSeparators = {'\0'};
    private static String userInput;

    // 문자열 덧셈 계산기 시작 함수
    public static void init() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    // 문자열 입력받는 함수
    public static void input() {
        userInput = Console.readLine();
    }

    // 커스텀 구분자 지정하는 함수
    public static void setCustomSeparator(String input) {
        // "//"와 "\n" 사이에 문자가 존재하면 커스텀 구분자로 지정
        if (input.startsWith("//")) {
            if (input.substring(3, 5).equals("\\n")) {
                userInput = input.substring(5);
                customSeparators = new char[]{input.charAt(2)};
            } else {
                throw new IllegalArgumentException("지정된 커스텀 구분자 형식으로 작성해야 합니다.");
            }
        }
    }

    // 빈 문자열인지 확인하는 함수
    public static boolean validateEmptyInput(String input) {
        return input == null || input.isEmpty();
    }


    // 숫자 사이에 하나의 구분자만 있는지 확인하는 함수
    public static void validateSeparatorBetweenNumber(String input) {
        String[] st = input.split("[" + basicSeparators[0] + basicSeparators[1] + customSeparators[0] + "]");
        for (String s : st) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("구분자가 연속이거나 숫자 사이에 존재하지 않습니다.");
            }
        }
    }

    // 처음에 숫자가 나왔는지 확인하는 함수
    public static void validateStartWithDigit(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("숫자부터 입력해야 합니다.");
        }
    }


    // 문자열 개수로 구분자 외에 다른 문자가 있는지 확인
    public static void validateNotSeparator(String input) {
        long basicSeparatorCount = input.chars().filter(c -> c == basicSeparators[0] || c == basicSeparators[1]).count();
        long customSeparatorCount = input.chars().filter(c -> c == customSeparators[0]).count();
        long inputCount = input.chars().filter(c -> !Character.isDigit(c)).count();

        if (inputCount != basicSeparatorCount + customSeparatorCount) {
            throw new IllegalArgumentException("구분자로 지정된 문자만 사용할 수 있습니다.");
        }
    }

    // 입력이 숫자로 끝나는지 확인하는 함수
    public static void validateEndWithNumber(String input) {
        if (!Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException("문자열의 마지막 문자가 숫자가 아닙니다.");
        }
    }

    // 입력에 공백이 있는지 확인하는 함수
    public static void validateBlankInput(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("문자열에 공백이 포함되어 있습니다.");
        }
    }

    // 입력 유효성 검사 함수
    public static void validInput(String input) {
        validateBlankInput(input);
        validateStartWithDigit(input);
        validateNotSeparator(input);
        if (validateEmptyInput(input)) {
            System.out.println("결과 : " + 0);
            return;
        }
        validateSeparatorBetweenNumber(input);
        validateEndWithNumber(input);
    }

    // 계산 함수
    public static long calculator(String input) {
        long total = 0;
        long sum = 0;

        for(int i=0; i<input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) {
                sum *= 10;
                sum += input.charAt(i) - '0';
            } else {
                total += sum;
                sum = 0;
            }
        }
        total += sum;

        return total;
    }

    // 계산 결과 출력 함수
    public static void print() {
        System.out.println("결과 : " + calculator(userInput));
    }

    public static void main(String[] args) {
        init();
        input();
        setCustomSeparator(userInput);
        validInput(userInput);
        calculator(userInput);
        print();
    }
}
