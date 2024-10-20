package calculator.delimiter.handler.factory;

import calculator.delimiter.handler.CommaColonDelimiterHandler;
import calculator.delimiter.handler.CustomDelimiterHandler;
import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.handler.NoDelimiterHandler;
import java.util.ArrayList;
import java.util.List;

public class DelimiterHandlerFactory {
    private List<DelimiterHandler> handlers;

    public DelimiterHandlerFactory() {
        handlers = new ArrayList<>();
        handlers.add(new NoDelimiterHandler());
        handlers.add(new CommaColonDelimiterHandler());
        handlers.add(new CustomDelimiterHandler());
    }

    public DelimiterHandler getHandler(String str) {
        for (DelimiterHandler handler : handlers) {
            if (handler.isSupport(str)) {
                return handler;
            }
        }
        throw new IllegalArgumentException("핸들러를 찾을 수 없습니다.");
    }
}
