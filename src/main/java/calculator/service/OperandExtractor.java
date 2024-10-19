package calculator.service;

import static calculator.common.constant.Constants.REGEX_OR;

import calculator.model.Operand;
import calculator.model.Separator;
import calculator.model.Separators;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OperandExtractor {

    private final Separators separators;

    public OperandExtractor(Separators separators) {
        this.separators = separators;
    }

    public List<Operand> extractOperands(String message) {
        List<String> operandCandidates = List.of(message.split(makeSplitRegex()));
        return operandCandidates.stream()
                .map(Operand::from)
                .toList();
    }

    private String makeSplitRegex() {
        return separators.separators().stream()
                .map(Separator::separator)
                .map(Pattern::quote)
                .collect(Collectors.joining(REGEX_OR));
    }
}
