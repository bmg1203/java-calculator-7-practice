package calculator.dto;

import java.math.BigDecimal;

public class CalculatorResultDTO<T extends Number> {

    private final T currentSum;

    public CalculatorResultDTO(T currentSum) {
        this.currentSum = currentSum;
    }

    public T get() {
        return currentSum;
    }

    @Override
    public String toString() {
        BigDecimal totalValue = new BigDecimal(currentSum.toString());
        BigDecimal integer = totalValue.divideAndRemainder(BigDecimal.ONE)[0];     // 정수부
        BigDecimal decimals = totalValue.divideAndRemainder(BigDecimal.ONE)[1];    // 소수부

        // 계산 결과가 정수인지 확인
        if (decimals.equals(BigDecimal.ZERO)) {
            return integer.toPlainString();
        }
        return totalValue.toPlainString();
    }
}
