package calculator.presentation;

public class PresentationValidator {

    public String valid(String input) {
        return inputTypeValidation(input);
    }

    private String inputTypeValidation(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return input;
    }
}
