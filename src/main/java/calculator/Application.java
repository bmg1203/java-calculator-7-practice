package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.logging.Logger;

/*
 * 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
 */
public class Application {

    public static final char BASIC_SEP_ONE = ':';
    public static final char BASIC_SEP_TWO = ',';
    private static final char NO_CUSTOM_SEP = '1';
    public static char customSep  = NO_CUSTOM_SEP;
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    // BASIC_SEP, CustomSep, 숫자인지 유효성 검사
    public static boolean isValidChar(char c){
        return (c == BASIC_SEP_ONE || c == BASIC_SEP_TWO || Character.isDigit(c) || c == customSep);
    }

    // 입력값 검증
    public static void isValid(String input){
        if(input.isEmpty()){
            return;
        }
        if(input.contains("-") && !input.startsWith("//")) {
            throw new IllegalArgumentException("NEGATIVE_NUMBERS_ARE_NOT_ALLOWED");
        }
        if((input.charAt(0) == '/' && input.length() < 5)) {
            throw new IllegalArgumentException("Input is not valid.");
        }
        if(input.startsWith("//") && input.charAt(3) == '\\' && input.charAt(4) == 'n'){
                customSep = input.charAt(2);
        }
        for (int i = 0; i < input.length(); i++){
            if(customSep != NO_CUSTOM_SEP && i < 5) continue;
            if(!isValidChar(input.charAt(i))){
                throw new IllegalArgumentException(input.charAt(i) + " is inserted." );
            }
        }
    }

    // 문자열에서 숫자 덧셈 계산
    public static int calculate(String input){
        int sum = 0;
        int i = (customSep == NO_CUSTOM_SEP ? 0 : 5);

        while(i < input.length()){
            if(!Character.isDigit(input.charAt(i)) || input.charAt(i) == customSep){
                i++;
                continue;
            }
            int num = 0;
            while(i < input.length() && Character.isDigit(input.charAt(i)) && input.charAt(i) != customSep){
                num = num * 10 + input.charAt(i) - '0';
                i++;
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        // 입력받기 및 입력값 검증
        System.out.println("PLEASE_ENTER_THE_STRING_TO_BE_ADDED");
        String input = Console.readLine();
        isValid(input);
        logger.info("결과 : " + calculate(input));
    }
}