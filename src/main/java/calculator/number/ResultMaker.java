package calculator.number;

import java.util.List;

public class ResultMaker {

    public static int getResult(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }
}
