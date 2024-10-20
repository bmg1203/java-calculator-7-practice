package calculator.caulculatorApplication.io.mock;

import calculator.calculatorApplication.InputReader;

public class FakeInputReader implements InputReader {
    private final String input;

    public FakeInputReader(String input) {
        this.input = input;
    }

    @Override
    public String readLine() {
        return input;
    }
}
