package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    static String str;

    // 구분자들을 기준으로 문자열 분리
    public static String[] seperateString(String seperators) {
        StringTokenizer st = new StringTokenizer(str, seperators);
        String[] nums = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            nums[i] = st.nextToken();
            i++;
        }
        return nums;
    }

    // 문자열을 분리하기 위해 구분자들을 모아놓은 문자열 생성
    public static String makeSeperators() {
        String seperators = ",:";
        // 커스텀 구분자가 있는 경우, 커스텀 구분자를 찾아 문자열을 분리할 구분자들(seperators)에 추가
        if (str.contains("//") && str.contains("\\n")) {
            int idx = str.indexOf("\\n");
            seperators += str.substring(2, idx);
            str = str.substring(idx + 2);
        }
        return seperators;
    }

    // 기본 구분자와 커스텀 구분자를 제외한 다른 구분자를 포함하고 있는지 검사
    public static boolean isInvalidSeperator(String[] nums) {
        for (String num : nums) {
            if (!num.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("기본 구분자 또는 커스텀 구분자를 입력해 주세요.");
            }
        }
        return true;
    }

    // 분리한 문자열이 모두 양수인지 검사
    public static boolean isPositiveNumber(String[] nums) {
        for (String num : nums) {
            if (Integer.parseInt(num) <= 0) {
                throw new IllegalArgumentException("양수를 입력해 주세요.");
            }
        }
        return true;
    }

    // 분리한 문자열을 숫자로 변환하여 더하기
    public static int calculate(String[] nums) {
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public static void main(String[] args) {
        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        str = Console.readLine();

        // 아무것도 입력하지 않은 경우
        if (str.isEmpty()) {
            System.out.println(0);
        }

        // 숫자가 포함되어 있지 않은 경우
        if (!str.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("숫자를 포함하여 입력해 주세요.");
        }

        String seperators = makeSeperators();
        String[] nums = seperateString(seperators);
    }
}
