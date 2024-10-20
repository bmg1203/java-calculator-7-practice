package calculator.parser;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorNumberParser implements NumberParser {
    @Override
    public PositiveNumbers parseNumbers(List<String> numberStrings) {
        List<Integer> parsedNumbers = numberStrings.stream()
                .filter(StringProcessor::isNotEmpty)
                .map(StringProcessor::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new PositiveNumbers(parsedNumbers);
    }
}