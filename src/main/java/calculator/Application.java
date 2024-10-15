package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(input);
        System.out.println("결과 : " + calculate(input));
    }

    public static int calculate(String input) {
        String delimiter = "[,|:]";
        int result = 0;

        if ("".equals(input)) {
            return result;
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력하신 문자열에는 공백이 포함될 수 없습니다.");
        }

        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        String[] numbers = input.split(delimiter);
        for (String number : numbers) {
            if ("".equals(number)) {
                throw new IllegalArgumentException("구분자 사이에는 숫자가 입력되어야 합니다.");
            }

            int operand = Integer.parseInt(number);
            if (operand < 0) {
                throw new IllegalArgumentException(
                        String.format("(%s)는 음수입니다. 입력하는 숫자들은 반드시 양수 혹은 0이어야 합니다.", operand)
                );
            }
            result += operand;
        }
        return result;
    }
}
