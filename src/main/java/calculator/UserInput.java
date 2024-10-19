package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    private String input;
    private ArrayList<Character> separators = new ArrayList<>(List.of(',', ':'));

    public void input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        valid();
    }

    public void valid() {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        int index = 0;

        if (input.startsWith("//")) {
            if (input.length() < 4 || !input.substring(3, 5).equals("\\n")) {
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }

            separators.add(input.charAt(2));

            index = 5;
        }

        for (int i = index; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!Character.isDigit(c) && !separators.contains(c)) {
                throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
            }
        }
    }

    public String getInput() {
        return input;
    }

    public ArrayList<Character> getSeparators() {
        return separators;
    }
}
