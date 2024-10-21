package calculator.domain.preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Preprocessor {

    private final DelimeterSegmentProcessor delimeterSegmentProcessor;
    private final CalculationSegmentProcessor calculationSegmentProcessor;

    public Preprocessor(DelimeterSegmentProcessor delimeterSegmentProcessor, CalculationSegmentProcessor calculationSegmentProcessor) {
        this.delimeterSegmentProcessor = delimeterSegmentProcessor;
        this.calculationSegmentProcessor = calculationSegmentProcessor;
    }

    public List<String> preprocessDelimeterSegment(String input) {
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));

        if (delimeterSegmentProcessor.checkCustomDelimeterRequest(input)) {
            return delimeterSegmentProcessor.extractDelimeterList(input);
        }

        return delimeterList;
    }

    public String preprocessCalculationSegment(String input) {
        if (delimeterSegmentProcessor.checkCustomDelimeterRequest(input)) {
            return delimeterSegmentProcessor.extractCalculationSegment(input);
        } else {
            return input;
        }
    }

    public void validateCalculationSegment(List<String> delimeter, String input) {
        calculationSegmentProcessor.findNoneDelimeterString(delimeter, input);
    }

    public List<String> extractSumNumbers(List<String> delimeterList, String input) {
        return calculationSegmentProcessor.extractNumbers(delimeterList, input);
    }
}
