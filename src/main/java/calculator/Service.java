package calculator;

import java.util.regex.Pattern;

public class Service {
    /**
     * 구분자로 문자열에서 숫자를 추출하는 함수
     */
    public static String[] separate(String input) {
        input = input.replace("\\n", "\n"); // 이스케이프 문자 처리

        // 비어있으면 종료
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        String separator = ",|:"; // 구분자

        // "//"로 시작하는 경우, 새로운 문자를 구분자로 추가
        if (input.startsWith("//")) {
            int separatorIndex = input.indexOf('\n');
            if (separatorIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 등록이 올바르지 않습니다.");
            }

            // 구분자 추가
            separator += "|" + Pattern.quote(input.substring(2, separatorIndex)); // 특수 문자 처리를 위해 Pattern.quote 사용
            input = input.substring(separatorIndex + 1); // 커스텀 구분자 등록 부부은 제거
        }

        // 최종 구분자를 기준으로 숫자를 구분
        String[] nums = input.split(separator);

        return nums;
    }

    /**
     * 숫자 배열을 받아서 합을 구하는 함수
     */
    public static int add(String[] nums) {
        int sum = 0;
        for (String num : nums) {
            // 숫자가 없다면
            if (num.isEmpty()) {
                throw new IllegalArgumentException("입력된 숫자가 존재하지 않습니다.");
            }

            int number;
            try {
                number = Integer.parseInt(num);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + num);
            }
            sum += number;
        }
        return sum;
    }
}
