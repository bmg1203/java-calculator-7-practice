package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FormulaSeparator {

    private static final int CUSTOM_SEPARATOR_IDX = 2;
    private static final int CUSTOM_FORMULA_START_IDX = 5;
    private final FormatValidator formatValidator = new FormatValidator();
    private final Set<Character> separators = new HashSet<>(DefaultSeparator.getSeparators());

    public List<Integer> getNumbers(String formula) {
        formatValidator.validateFormula(formula);

        if (formula.isEmpty()) {
            return List.of();
        }

        if (hasCustomSeparator(formula)) {
            separators.add(formula.charAt(CUSTOM_SEPARATOR_IDX));
            formula = formula.substring(CUSTOM_FORMULA_START_IDX);
        }

        return parseNumbers(formula);
    }

    private boolean hasCustomSeparator(String formula) {
        return CustomFormulaFormat.hasFirstFormat(formula);
    }

    private List<Integer> parseNumbers(String formula) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < formula.length(); i++) {
            char character = formula.charAt(i);

            if (Character.isDigit(character)) {
                currentNumber.append(character);
                continue;
            }

            if (separators.contains(character)) {
                if (currentNumber.length() > 0) {
                    numbers.add(Integer.parseInt(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
            }
        }

        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }

        return numbers;
    }
}
