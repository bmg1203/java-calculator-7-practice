package calculator.domain;

import java.util.List;

public class Calculator {

    private List<String> separators;
    private List<Integer> numbers;

    public Calculator() {
        this.separators.add(",");
        this.separators.add(";");
    }

    public void addSeparator(String separator) {
        this.separators.add(separator);
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }

    public List<String> getSeparators() {
        return this.separators;
    }
}
