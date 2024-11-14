package calculator.validator;

import java.util.ArrayList;
import java.util.List;

public class NumberValidator {

    public static List<Integer> validateNumbers(List<String> numberStr) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String number : numberStr) {
                int num = Integer.parseInt(number);
                numbers.add(num);
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
