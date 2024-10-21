package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    private static int add(String input) {
        if (input.isBlank()) {
            return 0;
        }

        String delimiter = ",:"; // 기본 구분자는 쉼표(,) 또는 콜론(:)
        if (input.startsWith("//")) {
            int index = 0;

            // 커스텀 구분자라면 문자열에서 "\n"이 있어야 함.
            if (input.contains("\\n")) {
                index = input.indexOf("\\n");
                delimiter = input.substring(2, index);

                // 커스텀 구분자는 하나의 문자여야 됨.
                if (delimiter.length() > 1) {
                    throw new IllegalArgumentException("커스텀 구분자는 하나의 문자여야 됩니다.");
                }
            } else {
                throw new IllegalArgumentException("\"\\n\"을 찾을 수 없습니다.");
            }

            input = input.substring(index + 2);
        }

        String[] numbers = input.split("[" + delimiter + "]");
        return calculate(numbers);
    }

    private static int calculate(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            // 숫자가 아니거나 비어있는 경우 예외 발생
            if (!number.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }

            int num = Integer.parseInt(number);
            // 숫자가 양수가 아닌 경우 예외 발생
            if (num <= 0) {
                throw new IllegalArgumentException("양수를 입력해야 합니다.");
            }
            result += num;
        }

        return result;
    }
}
