package calculator.domain;

import java.util.List;

public class AddCalculator {

    public static int add(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

}
