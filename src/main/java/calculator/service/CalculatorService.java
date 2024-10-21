package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private final String PATTERN = "//;\\n";
    private final int DELIMITER_INDEX = 2;
    private final int PATTERN_START_INDEX = 0;
    private String line;
    private String delimiter = ":,";

    public CalculatorService(String line) {
        this.line = validate(line);
    }

    private String validate(String line) {
        if (line == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        if (!line.isBlank() && line.charAt(PATTERN_START_INDEX) == PATTERN.charAt(PATTERN_START_INDEX)) {
            line = findDelimiter(line);
        }
        return line;
    }

    private String findDelimiter(String line) {
        for (int i = 0; i < PATTERN.length(); i++) {
            if (i == DELIMITER_INDEX) {
                continue;
            }
            if (PATTERN.charAt(i) != line.charAt(i)) {
                throw new IllegalArgumentException("구분자 패턴이 아닙니다.");
            }
        }
        delimiter += line.charAt(DELIMITER_INDEX);
        return line.substring(PATTERN.length());
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (String number : line.split("[" + delimiter + "]")) {
            if (number.isBlank()) {
                continue;
            }
            int item = 0;
            try {
                item = Integer.parseInt(number);
            } catch (Exception e) {
                throw new IllegalArgumentException("구분된 문자열이 숫자가 아니거나 int범위를 넘었습니다.");
            }
            numbers.add(item);
        }
        return numbers;
    }
}
