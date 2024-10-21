package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        ArrayList<String> sep = new ArrayList<>(Arrays.asList(",", ":"));
        ArrayList<Integer> numbers = new ArrayList<>();
        int result = 0;

        if (input.startsWith("//")) {
            int customSepIndexEnd = input.indexOf("\\n");
            String newSep = input.substring(2, customSepIndexEnd).trim();
            sep.add(newSep);
            input = input.substring(customSepIndexEnd+2);
        }

        String[] strNumbers = input.split(String.join("|", sep));

        for (String number : strNumbers) {
            if (number.isEmpty()) { // 빈 문자열 체크
                numbers.add(0);
            } else {
                numbers.add(Integer.parseInt(number.trim()));
            }
        }

        for (int number : numbers) {
            result += number;
        }

        System.out.println("결과 : " + result);
    }
}
