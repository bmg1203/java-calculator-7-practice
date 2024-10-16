package calculator.domain.vo.number;

import java.math.BigInteger;
import java.util.Objects;

public class Number {

    private BigInteger value;

    private Number(String value) {
        validate(value);
        this.value = new BigInteger(value);
    }

    protected void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            new BigInteger(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Number from(String value) {
        return new Number(value);
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        return this.value.equals(number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("Number = %s", value);
    }

}
