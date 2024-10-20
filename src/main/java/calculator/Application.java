package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용자에게 문자열 입력받기
        System.out.println("덧셈 할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자 확인
        String separator = getSeparator(input);

        // 문자열 분리
        String[] numbers = splitInput(input, separator);

    }

    // 구분자 확인 메소드
    public static String getSeparator(String input){

        if(input.startsWith("//")){
            int separatorIndex = input.indexOf("\\n");
            if(separatorIndex != -1){
                return input.substring(2, separatorIndex);
            }
        }

        return "[,:]";
    }

    // 문자열 분리 메소드
    public static String[] splitInput(String input, String separator){

        if(input.startsWith("//")){
            int startNumberIndex = input.indexOf("\\n");
            if(startNumberIndex != -1){
                input = input.substring(startNumberIndex + 2);
            }
        }

        return input.split(separator);
    }
}
