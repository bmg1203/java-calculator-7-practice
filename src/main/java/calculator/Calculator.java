package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String expr = input();
            String[] numstr = parse(expr);
            int result = add(numstr);
            System.out.println("결과 : " + result);
        } catch(IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다.");
            throw new IllegalArgumentException();
        }
    }

    public String input() throws IllegalArgumentException {
        return Console.readLine();
    }

    public String[] parse(String expr) throws IllegalArgumentException {
        String del = "[,:]";

        if(expr.startsWith("//")) {
            try {
                del = del + "|" + expr.charAt(2);
                expr = expr.substring(5);
            } catch(Exception e) {
                throw new IllegalArgumentException();
            }
        }

        return expr.split(del);
    }

    public int add(String[] numstr) throws IllegalArgumentException {
        int sum = 0;

        for(String xstr : numstr) {
            try {
                int x = Integer.parseInt(xstr);
                if(x < 0) {
                    throw new IllegalArgumentException();
                }
                sum += x;
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
