package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        String[] splits;

        if (input.charAt(0) == '/') {
            char delimiter = input.charAt(2);
            String regex = "[,:" + delimiter + "]";
            splits = input.substring(5).split(regex);
        } else {
            splits = input.split("[,:]");
        }

        if (isPositive(splits)) {
            System.out.println("결과 : " + sumNumber(splits));
        } else {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    private static int sumNumber(String[] splits) {
        int sum = 0;
        for (String split : splits) {
            sum += Integer.parseInt(split);
        }
        return sum;
    }

    private static boolean isPositive(String[] splits) {
        for (String split : splits) {
            if (Integer.valueOf(split) < 0) {
                return false;
            }
        }
        return true;
    }
}
