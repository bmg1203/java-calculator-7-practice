package calculator.domain;

import java.util.LinkedList;

public class Numbers {
    private final LinkedList<Integer> numbers;

    public Numbers() {
        numbers = new LinkedList<>();
    }

    public LinkedList<Integer> getNumbersList() {
        return numbers;
    }

}
