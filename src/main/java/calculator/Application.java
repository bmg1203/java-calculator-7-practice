package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String determine = ",|:";

        if (input.startsWith("//")) { // 커스텀 구분자 선언이 있을 경우
            int endIndex = input.indexOf("\\n");

            if (endIndex != -1) { // \n 이 있다면 커스텀 구분자로 업데이트
                String customDetermine = input.substring(2, endIndex); // 커스텀 구분자 업데이트
                if(customDetermine.length() > 1){
                    throw new IllegalArgumentException();
                }
                determine += "|" + customDetermine;
                input = input.substring(endIndex + 2);

                if(!input.contains(customDetermine)){ // 커스텀 구분자로 구분되지 않을 경우
                    throw new IllegalArgumentException();
                }
            } else { // \n 이 없을 경우 커스텀 선언이 안됨
                throw new IllegalArgumentException();
            }
        }else if(!input.contains(determine)){ // 구분자가 아닐 경우
            throw new IllegalArgumentException();
        }

        Calc c = new Calc();
        int sum = c.calculate(input, determine);

        System.out.println("결과 : " + sum);
    }
}
