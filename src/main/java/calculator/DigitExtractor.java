package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static calculator.Calculator.handleInvalidInput;

public class DigitExtractor {

    private List<String> tokens = new ArrayList<>(); // 구분자 기준으로 분리한 문자열 토큰

    /**
     * 문자열에서 숫자 추출
     */
    public List<Integer> extractDigits(String input, String regex) {
        if (!isValidInput(input, regex)) { // 문자열 유효성 검증
            handleInvalidInput(input);
        }
        List<Integer> digits = new ArrayList<>(List.of(0)); // 입력이 빈 문자열("")인 경우 0 반환
        if (!tokens.getFirst().isEmpty()) {
            digits.clear();
            try {
                digits = tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
            } catch (NumberFormatException | NullPointerException e) {
                handleInvalidInput(input);
            }
        }
        return digits;
    }

    /**
     * 문자열의 유효성 검증
     */
    private boolean isValidInput(String input, String regex) {
        tokens = Stream.of(input.split(regex)).map(String::trim).collect(Collectors.toList()); // 토큰 분리
        return tokens.stream().noneMatch(token -> token.matches(".*[^0-9].*"));
    }

}
