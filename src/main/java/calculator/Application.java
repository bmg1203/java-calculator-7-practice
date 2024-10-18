package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            System.out.println(0);
        } else {
            String[] splited = input.split("[,|:]");
            int sum = 0;
            for (String s : splited) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }


    }
}
