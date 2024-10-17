package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("덧셈할 문자열을 입력해주세요." + "\n");
        String Input = Console.readLine();

        Input = Input.replace("\\n", "\n");


        int sum = 0;
        String Separator = "[,:]";

        if (Input.startsWith("//")) {
            int SeparatorEnd = Input.indexOf("\n");

            String CustomSeparator = Input.substring(2, SeparatorEnd);
            Separator += "|" + CustomSeparator;

            Input = Input.substring(SeparatorEnd + 1);
        }

        String[] tokens = Input.split(Separator);

        for (String token : tokens) {
            if (token.isEmpty()) {
                token = "0";
            }
            int number = Integer.parseInt(token);

            if (number < 0) {
                throw new IllegalArgumentException();
            }

            sum += number;
        }
        System.out.println("결과 : " + sum);

    }
}
