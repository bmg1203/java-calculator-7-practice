package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        try {
            int result = processInput(inputString);
            System.out.print("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 프로그램 종료
            return;
        }
    }

    public static int processInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiters = ",|:"; // 기본 구분자 설정
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                // 문자로 처리
                String[] customDelimiterParts = input.split("\\\\n");

                // 커스텀 구분자 처리
                int index = 0;
                while (index < customDelimiterParts.length && customDelimiterParts[index].startsWith("//")) {
                    // 구분자 스트링에 커스텀 구분자 추가 (정규식 특수 문자 이스케이프 처리)
                    String customDelimiter = customDelimiterParts[index].substring(2);
                    // 특수 문자 이스케이프
                    customDelimiter = escapeCharacter(customDelimiter);
                    delimiters += "|" + customDelimiter;
                    index++;
                }

                // 구분자 이후 숫자 부분 처리
                if (index < customDelimiterParts.length) {
                    numbers = customDelimiterParts[index];
                } else {
                    numbers = "";
                }

                // 숫자 부분이 없을 경우 0 반환
                if (numbers.trim().isEmpty()) {
                    return 0;
                }
            }
        }

        // 숫자 이외의 잘못된 문자가 있는지 확인 (구분자 외의 문자가 나오면 예외 처리)
        if (!numbers.matches("[0-9" + delimiters + "]*")) {
            throw new IllegalArgumentException();
        }

        // 구분자를 기준으로 숫자를 추출
        String[] numberTokens = numbers.split(delimiters);

        // 구분자만 입력된 경우 0 반환
        if (numberTokens.length == 0 || numbers.isEmpty()) {
            return 0;
        }

        // 덧셈 처리 전 임시 값
        return -1;
    }

    // 정규식에서 특수 문자를 이스케이프 처리하는 메서드
    private static String escapeCharacter(String delimiter) {
        return delimiter.replaceAll("([\\W])", "\\\\$1");
    }


}
