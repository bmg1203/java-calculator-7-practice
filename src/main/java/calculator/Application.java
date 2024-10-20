package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("뎃셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try{
            int result = Calculator.add(input);
            System.out.println("결과 : " + result);
        }catch(IllegalArgumentException e){
            System.out.println("오류: " + e.getMessage());
            throw e;
        }
    }

}
