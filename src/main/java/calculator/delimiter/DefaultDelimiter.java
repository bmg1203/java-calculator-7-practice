package calculator.delimiter;

import calculator.calculator.Delimiter;
import calculator.utils.DelimiterUtils;
import java.util.List;

/**
 * 정책적으로 구체화되어 있지 않지만, 실패 케이스로 판단하지 않는 녀석들에 대해 처리한다. 1. 공백이면 0이다 : 해당 케이스는 다른 경우에서도 빈 리스트를 리턴하게 되므로, 0 으로 결과값이 잘 나온다. 2.
 * 숫자가 하나만 있으면 숫자 하나를 리턴한다.
 */
public class DefaultDelimiter implements Delimiter {

    private static final String INTEGER_REGEX = "\\d+";

    @Override
    public List<String> extractString(String input) {
        if (input.isEmpty()) {
            return List.of();
        }

        return List.of(input);
    }

    @Override
    public boolean applicable(String input) {
        String removedSpaces = DelimiterUtils.removeSpaces(input);
        return removedSpaces.isEmpty() || removedSpaces.matches(INTEGER_REGEX);
    }
}
