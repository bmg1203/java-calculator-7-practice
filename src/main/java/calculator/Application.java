package calculator;

import calculator.separator.CustomSeparator;
import calculator.separator.DefaultSeparator;
import calculator.separator.Separator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String line = Console.readLine();
        // 제한된 숫자 입력 정리 (오버플로우 될 수도 있음)
        Calculator calculator = new Calculator(createSeparator(line));
        int answer = calculator.calculate();
        System.out.println("결과 : " + answer);
    }

    private static Separator createSeparator(String line) {
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return new CustomSeparator(line);
        }
        return new DefaultSeparator(line);
    }
}
