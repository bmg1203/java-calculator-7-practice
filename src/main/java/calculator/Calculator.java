package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            // 입력받은 문자열로 덧셈 계산
            int result = StringCalculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private int StringCalculate(String input) {
        if(input == null || input.equals("")) {
            return 0;
        }

        int sum = 0;

        String delimiter = ",|:";

        if (input.startsWith("//")) {
            delimiter = parseDelimiter(input);  // 커스텀 구분자 추출
            input = input.substring(input.indexOf("\\n") + 2);
        }

        String[] temps = input.split(delimiter);

        for(String num : temps) {
            int parsedNum = parseNumber(num);
            sum += parsedNum;
        }

        return sum;
    }

    private String parseDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        if (endIndex == -1) {
            throw new IllegalArgumentException("구분자가 잘못되었습니다.");
        }

        return input.substring(startIndex, endIndex); // "//"와 "\n" 사이의 구분자 추출
    }

    private int parseNumber(String num) {
        try {
            int parsedNum = Integer.parseInt(num);
            if (parsedNum < 0) {
                throw new IllegalArgumentException("양수를 입력하세요");
            }
            return parsedNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
