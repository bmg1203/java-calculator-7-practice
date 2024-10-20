package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    private static final String DEFAULT_DELIMITER = "[,:]";
    public static void main(String[] args) {
        // 사용자 입력 받는 부분
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = StringAddCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            throw e;
        }
    }

    public static class StringAddCalculator {
        public static int add(String input) {
            // 빈 문자열 혹은 null 체크 후 이에 해당될 경우 0 반환
            if (input == null || input.isBlank()) {
                return 0;
            }

            // 쉼표 또는 콜론을 문자열 분리 디폴트로 설정
            String delimiter = "[,:]";
            String numbers = input;

            // 커스텀 구분자 입력 확인 및 처리
            if (input.startsWith("//")) {
                // 우선 실제 줄바꿈 문자("\n")를 찾음
                int endIndexDelimiter = input.indexOf("\n");

                // 구분자 부분을 저장할 변수 선언
                String delimiterPart = DEFAULT_DELIMITER;

                // 만약 실제 줄바꿈 문자가 없다면, 이스케이프된 "\\n"을 처리
                if (endIndexDelimiter == -1) {
                    endIndexDelimiter = input.indexOf("\\n");
                }
                if (endIndexDelimiter == -1) {
                    throw new IllegalArgumentException("잘못된 입력 형식으로 커스텀 구분자 선언 후 줄바꿈을 포함해야 합니다.");
                }

                // 줄바꿈 문자 여부에 따른 구분자 처리 추출
                delimiterPart = input.substring(2, endIndexDelimiter);
                numbers = input.substring(endIndexDelimiter + (input.contains("\\n") ? 2 : 1));

                delimiter = delimiterPart.startsWith("[") && delimiterPart.endsWith("]")
                        ? extractMultipleDelimiters(delimiterPart)
                        : escapeSpecialCharacters(delimiterPart);
            }

            // 구분자 기준으로 문자열 분리
            Pattern pattern = compilePattern(delimiter);
            String[] tokens = pattern.split(numbers);

            // 숫자 합 저장 변수 선언
            int sum = 0;

            // 음수 값 저장 용도 리스트 선언
            List<Integer> negativeNumbers = new ArrayList<>();

            // 각 숫자 합산 도출
            for (String token : tokens) {
                int number = Integer.parseInt(token.trim()); // 문자열을 정수로 변환하여 합산
                // 음수일 경우 해당 배열에 추가
                if (number < 0) {
                    negativeNumbers.add(number);
                }// 1000 초과하는 숫자는 연산 대상에서 제외
                else if (number <= 1000) {
                    sum += number;
                }
            }

            if (!negativeNumbers.isEmpty()) {
                // 음수 값들을 포함하는 배열을 읽고 예외 발생
                throw new IllegalArgumentException("Negative numbers are not allowed: " + negativeNumbers);
            }

            return sum;
        }

        private static Pattern compilePattern(String delimiter) {
            return Pattern.compile(delimiter);
        }

        private static String extractMultipleDelimiters(String delimiterPart) {
            String[] delimiters = delimiterPart.substring(1, (delimiterPart.length() - 1)).split("]\\[");
            StringBuilder delimiterRegex = new StringBuilder();

            for (int i = 0; i < delimiters.length; i++) {
                delimiterRegex.append(escapeSpecialCharacters(delimiters[i]));
                if (i < (delimiters.length - 1)) {
                    delimiterRegex.append("|");
                }
            }

            return delimiterRegex.toString();
        }

        // 정규식 특수문자 처리용 메소드
        private static String escapeSpecialCharacters(String delimiter) {
            return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\|.])", "\\\\$1");
        }
    }
}
