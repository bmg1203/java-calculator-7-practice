package calculator;

import java.util.HashSet;
import java.util.Set;

public class FormatValidator {

    private static final Set<Character> separators = new HashSet<>(DefaultSeparator.getSeparators());

    /**
     * 주어진 수식(formula)을 유효성 검사하는 메서드입니다.
     * 수식이 숫자로 시작하는지, 또는 '//' 문자로 시작하는지를 확인하여
     * 각각 적절한 형식의 유효성을 검증합니다.
     * 1. 숫자로 시작하면 숫자 또는 구분자 외의 문자가 포함되었는지 검사합니다.
     * 2. '//' 문자로 시작하면 커스텀 구분자 형식이 맞는지 확인합니다.
     *
     * @param formula 유효성을 검사할 수식 (null 또는 빈 문자열일 수 있음)
     * @throws IllegalArgumentException 잘못된 형식일 경우 예외를 발생시킵니다.
     */
    public void validateFormula(String formula) {
        if (isNullOrEmpty(formula)) {
            return;
        }

        if (isNumberStart(formula)) {
            validateNumberStartFormat(formula);
        } else if (isCustomStart(formula)) {
            validateCustomStartFormat(formula);
        } else {
            throw new IllegalArgumentException("잘못된 수식입니다. 수식을 다시 한번 확인해 주세요.");
        }
    }

    // 숫자로 시작하는 수식에서 허용되지 않은 문자가 있는지 검증
    private void validateNumberStartFormat(String formula) {
        if (isNumberStartFormat(formula, null)) {
            return;
        }

        throw new IllegalArgumentException("수식에는 기본 구분자(쉼표, 콜론)외의 문자가 포함될 수 없습니다.");
    }

    private static boolean isNumberStartFormat(String formula, Character separator) {
        if (separator != null) {
            separators.add(separator);
        }

        for(char ch : formula.toCharArray()) {
            if (!Character.isDigit(ch) && !separators.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    // 커스텀 구분자 형식으로 시작하는 수식에서 허용되지 않은 문자가 있는지 검증
    private void validateCustomStartFormat(String formula) {
        if (isCustomStartFormat(formula)) {
            return;
        }

        throw new IllegalArgumentException("올바른 커스텀 구분자 형식은 //<숫자가 아닌 문자>\\n입니다. "
            + "혹은 구분자 외의 문자가 포함되었는지 확인해주세요.");
    }

    private boolean isCustomStartFormat(String formula) {
        int formulaStartIdx = 5;
        int customSeparatorIdx = 2;
        int lastFormatStartIdx = 3;

        if (formula.length() < formulaStartIdx) {
            return false;
        }

        char customSeparator = formula.charAt(customSeparatorIdx);

        return !Character.isDigit(customSeparator)
            && CustomFormulaFormat.hasLastFormat(formula, lastFormatStartIdx)
            && Character.isDigit(formula.charAt(formulaStartIdx))
            && isNumberStartFormat(formula.substring(5), customSeparator);
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isNumberStart(String formula) {
        int firstIdx = 0;
        return Character.isDigit(formula.charAt(firstIdx));
    }

    private boolean isCustomStart(String formula) {
        return CustomFormulaFormat.hasFirstFormat(formula);
    }
}
