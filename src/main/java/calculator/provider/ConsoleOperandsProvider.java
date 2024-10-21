package calculator.provider;

import calculator.parser.PositiveLongParser;
import calculator.tokenizer.PrefixBasedSplitter;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOperandsProvider implements OperandsProvider {

    private final PrefixBasedSplitter splitter;
    private final PositiveLongParser longParser;

    public ConsoleOperandsProvider() {
        this.splitter = new PrefixBasedSplitter();
        this.longParser = new PositiveLongParser();
    }

    @Override
    public List<Long> getOperands() {
        String userInput = getUserInput();
        List<String> tokens = splitter.split(userInput);
        return parseToLong(tokens);
    }

    private String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine().trim();
    }

    private List<Long> parseToLong(List<String> strings) {
        List<Long> parsed = new ArrayList<>();
        for (String string : strings) {
            parsed.add(longParser.parse(string));
        }
        return parsed;
    }

}
