package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {

        // 1. Console 를 사용하여 입력을 받고 null 및 공백 체크
        String input = Console.readLine();
        Console.close();

        if (input == null || input.isEmpty()) {
            System.out.println("sum: 0");
            return;
        }

        // 2. 쉼표(,) or 콜론(:) or 커스텀 구분자 기준으로 숫자를 분리하여 리스트 객체에 담는다.
        String defaultDelimiter = ",|:"; // 기본 구분자
        String customDelimiter = ""; // 커스텀 구분자
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            // \n의 위치를 찾아 그 전까지를 커스텀 구분자로 설정
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex != -1) {
                customDelimiter = input.substring(2, newlineIndex); // "//" 이후와 "\n" 이전까지 추출
                numbers = input.substring(newlineIndex + 2); // \n 이후의 숫자 문자열
            }
        }

        // 커스텀 구분자가 있다면 기본 구분자에 추가
        String finalDelimiter = defaultDelimiter;
        if (!customDelimiter.isEmpty()) {
            finalDelimiter += "|" + Pattern.quote(customDelimiter); // 커스텀 구분자 추가
        }

        // 구분자로 문자열을 분리하고 숫자를 추출
        String[] tokens = numbers.split(finalDelimiter);

    }
}
