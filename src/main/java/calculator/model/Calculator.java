package calculator.model;

//계산 기능 만을 담당하는 클래스
public class Calculator {

    public long addCalculate(final Numbers numbers) {

        long sum = 0;

        for (final Integer number : numbers.getNumbers()) {
            sum += number;
        }

        return sum;

    }
}
