package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Calculator {
    private String input;
    private final List<String> separators;
    private final List<Integer> numbers;
    private int result;

    final static int CUSTOM_SEPARATOR_INDEX = 2;
    final static int CUSTOM_SEPARATOR_END_INDEX = 5;

    public Calculator(String input) {
        this.input = input;
        this.result = 0;
        separators = new ArrayList<>();
        numbers = new ArrayList<>();
        separators.add(",");
        separators.add(":");
    }


    /***
     * 입력 받은 문자열에 커스텀 구분자가 있다면 추출한다.
     */
    private void checkCustomSeparator() {
        // 커스텀 문자 있는지 확인
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            separators.add(input.charAt(CUSTOM_SEPARATOR_INDEX) + "");
            this.input = input.substring(CUSTOM_SEPARATOR_END_INDEX);
        }
    }

    /***
     * 입력 받은 문자열이 알맞은 형식인지 확인한다.
     */
    private void checkInput() {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        // 계산 가능한 패턴인지 확인
        String validRegex = "[0-9]+([" + separators.stream()
                .map(Pattern::quote)
                .reduce((s1, s2) -> s1 + s2)
                .orElse("")
                + "][0-9])*";
        if (!input.matches(validRegex)) {
            throw new IllegalArgumentException("올바른 입력 형식이 아닙니다.");
        }
    }


    /***
     * 구분자를 기준으로 숫자를 추출한다.
     */
    private void extractNumbers() {
        String splitRegex = "[" + separators.stream()
                .map(Pattern::quote)
                .reduce((s1, s2) -> s1 + "|" + s2)
                .orElse("") + "]";
        String[] split = input.split(splitRegex);
        for (String s : split) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    /***
     * 사용자로부터 문자열을 입력 받아 결과를 반환한다.
     * @return 정수 결과값
     */
    public int calculate() {
        checkCustomSeparator();
        checkInput();
        extractNumbers();
        for (Integer number : numbers) {
            result += number;
        }
        return this.result;
    }
}
