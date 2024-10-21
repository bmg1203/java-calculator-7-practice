package calculator;

import java.util.Arrays;

public class CustomParser {
    private final String BASIC_SEPARATOR;

    public CustomParser() {
        this.BASIC_SEPARATOR = ",|:";
    }

    public int[] parse(String input) {
        String regx = "[0-9]*([" + this.BASIC_SEPARATOR + "][0-9]+)*";
        if (input.matches(regx)) { // 기본 구분자를 사용할 경우
            return parse(input, this.BASIC_SEPARATOR);
        }

        if (input.matches("//[^0-9]\\\\n.*[0-9]$")) { // 커스텀 구분자를 사용할 경우
            String separator = processSeparator(input.charAt(2) + "");
            String temp = input.substring(5);
            return parse(temp, this.BASIC_SEPARATOR + "|" + separator);
        }

        throw new IllegalArgumentException("입력 형식을 확인해주세요.");
    }

    private int[] parse(String input, String separator) {
        if (input.isEmpty()) { // 빈 문자열일 경우
            return new int[]{0};
        }

        int[] result;
        try {
            result = Arrays.stream(input.split(separator)).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 형식을 확인해주세요. (문자 x, 구분자는 숫자 사이에만 존재할 수 있습니다)");
        }

        for (int number : result) {
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
        }

        return result;
    }

    // 특수문자를 커스텀 구분자로 사용하는 경우, 이스케이프 처리를 해줘야 함
    // 검사 대상 특수문자들: . * + ? ^ $ { } [ ] ( ) | \ /
    private String processSeparator(String separator) {
        String symbol = ".*+?^${}[]()|\\/";
        if (symbol.contains(separator)) {
            return "\\" + separator;
        }
        return separator;
    }
}
