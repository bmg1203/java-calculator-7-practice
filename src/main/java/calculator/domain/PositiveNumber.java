package calculator.domain;

import java.math.BigInteger;
import java.util.Objects;

public class PositiveNumber {

    private static final int MAX_LENGTH_THRESHOLD = 15;
    private static final String DEFAULT_NUMBER = "0";
    private static final String MINUS_SIGN = "-";

    private final BigInteger value;

    private PositiveNumber() {
        this.value = BigInteger.ZERO;
    }

    private PositiveNumber(final String number) {
        this.value = new BigInteger(number);
    }

    public static PositiveNumber from(final String number) {
        validate(number);
        if (isDefault(number)) {
            return new PositiveNumber();
        }
        return new PositiveNumber(number);
    }

    private static void validate(final String number) {
        validatePositive(number);
        validateOnlyDigits(number);
        validateLength(number);
    }

    private static boolean isDefault(final String number) {
        return DEFAULT_NUMBER.equals(number) || number.isEmpty();
    }

    private static void validatePositive(final String number) {
        if (isNegative(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNegative(final String number) {
        return number.startsWith(MINUS_SIGN);
    }

    private static void validateOnlyDigits(final String number) {
        if (!hasOnlyDigits(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean hasOnlyDigits(final String number) {
        return number.chars()
                .allMatch(Character::isDigit);
    }

    private static void validateLength(final String number) {
        if (isOutOfRange(number.length())) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOutOfRange(final int numberDigit) {
        return MAX_LENGTH_THRESHOLD < numberDigit;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PositiveNumber that)) {
            return false;
        }
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
