package calculator.domain;

import java.util.Arrays;

public class Calculator {
    private static final String NUMBER_REGEX="[0-9]{0,}";

    private static final String OVERFLOW_RESULT="덧셈의 결과가 int 범위를 넘어갔습니다";
    private static final String OVERFLOW_NUMBER="특정 수가 int 범위를 넘어갔습니다";
    private static final String INVALID_SEPERATOR="커스텀 구분자가 아닌 기호를 입력했습니다";

    private static final String BLANK="";

    public static int calculate(String input,String seperatorRegex) {
        int result= Arrays.stream(input.split(seperatorRegex))
                .filter(num->!isBlank(num))
                .filter(num->validateCustomSeperator(num))
                .filter(num->validateInteger(num))
                .mapToInt(Integer::parseInt)
                .reduce(0,(a,b)->addTwoNum(a,b));

        return result;
    }

    //존재하지 않는 커스텀 구분자 예외발생
    private static boolean validateCustomSeperator(String num){
        if (!(num.matches(NUMBER_REGEX))){
            throw new IllegalArgumentException(INVALID_SEPERATOR);
        }
        return true;
    }

    private static boolean validateInteger(String num){
        try{
            Integer.parseInt(num);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(OVERFLOW_NUMBER);
        }
        return true;
    }

    private static int addTwoNum(int a,int b) {
        if (a>Integer.MAX_VALUE-b){
            throw new IllegalArgumentException(OVERFLOW_RESULT);
        }
        return a+b;
    }

    private static boolean isBlank(String num) {
        return num.equals(BLANK);
    }
}
