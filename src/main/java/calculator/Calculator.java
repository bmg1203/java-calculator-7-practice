package calculator;

import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.handler.factory.DelimiterHandlerFactory;

public class Calculator {
    private final DelimiterHandlerFactory factory;

    public Calculator(DelimiterHandlerFactory factory) {
        this.factory = factory;
    }

    public Integer sum(String str) {
        DelimiterHandler handler = factory.getHandler(str);

        return handler.split(str)
                .parallelStream().mapToInt(Integer::parseInt)
                .sum();
    }
}
