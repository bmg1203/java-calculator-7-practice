package calculator.model;


import java.util.List;

public class ValidationUtils {


    public void validateInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }


    public void numbersCheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("양수만 입력 가능합니다.");
            }
        }
    }

}
