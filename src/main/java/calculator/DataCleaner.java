package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataCleaner {
    private static final String INVALID_NUMBER_MESSAGE = "잘못된 입력 값";
    private static final String INVALID_CUSTOM_MESSAGE = "잘못된 입력 값, 구분자 다음에 줄바꿈이 필요합니다.";

    public static int[] cleanData(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException(INVALID_CUSTOM_MESSAGE);
            }
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }
        StringTokenizer st = new StringTokenizer(input, delimiter);
        List<Integer> numbers = new ArrayList<>();

        while (st.hasMoreElements()) {
            String token = st.nextToken();
            int num = parseNumber(token);
            numbers.add(num);
        }

        return numbers.stream()
                .mapToInt(i -> i).toArray();
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE + token);
        }
    }
}
