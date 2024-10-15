package calculator.service;

import calculator.view.Input;
import calculator.view.Output;

import java.util.Optional;

public class CalculatorService {

    private final char[] constantDelimiter = {',',':'};
    private Optional<char[]> customDelimiter;
    private Optional<String> input;
    private Optional<int[]> numbersToCalculate;

    public void input() {
        Output.inputMessage();
        input = Input.input();
    }

    public void findCustomDelimiter() {
        String userInput = input.orElseThrow(() -> new IllegalArgumentException("입력값이 없습니다"));
        if(userInput.startsWith("//") && userInput.contains("\\n")) {
            String[] seperateDelimiterAndString = userInput.split("\\n");

            if(seperateDelimiterAndString.length != 2) {
                throw new IllegalArgumentException("커스텀 구분자를 등록하는 도중 '\\n'이 2개 이상입니다");
            }

            if(seperateDelimiterAndString[0].length() == 2) {
                throw new IllegalArgumentException("등록할 커스텀 구분자가 없습니다");
            }

            customDelimiter = Optional.of(seperateDelimiterAndString[0].substring(2).toCharArray());
            return;
        } else if(userInput.contains("/") || userInput.contains("\\")) {
            throw new IllegalArgumentException("커스텀 구분자 등록 실패");
        }
        customDelimiter = Optional.empty();
    }

    public void deleteDelimiter() {
        String userInput = input.orElseThrow(() -> new IllegalArgumentException("입력값이 없습니다"));
        String removeDelimiters = userInput.chars().filter(i -> {
                    char currentChar = (char) i;
                    for (char c : constantDelimiter) {
                        if (currentChar != c) {
                            return false;
                        }
                    }
                    for (char c : customDelimiter.orElse(new char[]{})) {
                        if (currentChar != c) {
                            return false;
                        }
                    }
                    return true;
                }).mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        isNumeric(removeDelimiters);
    }

    private void isNumeric(String removeDelimiters) {
        numbersToCalculate = Optional.of(removeDelimiters.chars().filter(i -> {
            if (i >= 0 && i <= 9) {
                return true;
            }
            return false;
        }).toArray());
    }
}
