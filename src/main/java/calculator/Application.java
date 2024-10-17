package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = sumNumbers(extractNumbers(input));
            System.out.println("결과 : " + result);
        }
        catch (IllegalArgumentException e){
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            throw e;
        }
    }

    public static String[] extractNumbers(String input){
        if(input.isBlank()){
            return new String[]{"0"};
        }

        String delimiter = ",|:";

        if(input.startsWith("//")){
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) throw new IllegalArgumentException("잘못된 구분자 형식");

            delimiter = input.substring(2, delimiterEndIndex);
            delimiter = Pattern.quote(delimiter);
            input = input.substring(delimiterEndIndex + 2);
        }
        return splitNumbers(input, delimiter);
    }

    public static String[] splitNumbers(String input, String delimiter){
        return input.split(delimiter);
    }

    public static int sumNumbers(String[] numbers){
        int sum = 0;

        for (String number : numbers){
            if(!number.isEmpty()){
                int num = Integer.parseInt(number);
                if(num < 0){
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
                sum += num;
            }
        }
        return sum;
    }
}
