package calculator.model;

import java.math.BigInteger;
import java.util.List;

public class Calculator {

    public BigInteger sum(List<Number> numbers) {
        BigInteger sum = BigInteger.ZERO;
        for (Number number : numbers) {
            sum = sum.add(number.number());
        }
        return sum;
    }
}
