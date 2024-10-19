package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringTokenizer st = inputValidCheck(input);
        
//        int sum = 0;
//        st = new StringTokenizer(input, ",:" + str);
//        while (st.hasMoreTokens()) {
//            sum += Integer.parseInt(st.nextToken());
//        }
//
//        System.out.println("결과 : " + sum);

    }

    private static String customDelimiterBeingCheck(String input) {

        if (input.length() > 4) {
            String customDelimiter = input.substring(0, 5);
            boolean being = customDelimiter.matches("^//\\S\\\\n$");
            if (being) return String.valueOf(input.charAt(2));
        }
        return "";
    }

    private static StringTokenizer inputValidCheck(String input) {

        String delimiters = ",:" + customDelimiterBeingCheck(input);
        if (delimiters.length() == 3) input = input.substring(5);
        StringTokenizer st = new StringTokenizer(input, delimiters);

        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            try {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력입니다");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }
        return new StringTokenizer(input, delimiters);
    }
}
