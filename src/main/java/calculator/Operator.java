package calculator;

import calculator.operands.Operands;

public class Operator {

    public static <E extends Number> E summation(Operands<E> operands) {
        Number result = null;
        Class<E> type = operands.getType();

        if (type == Long.class) {
            result = 0L;
            for (E number : operands.getData()) {
                if (result.longValue() > Long.MAX_VALUE - number.longValue()) {
                    throw new NumberFormatException();
                }
                result = result.longValue() + number.longValue();
            }
        }

        return type.cast(result);
    }
}
