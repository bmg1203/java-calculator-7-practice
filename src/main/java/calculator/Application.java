package calculator;

import calculator.domain.adder.Addable;
import calculator.domain.adder.IntegerAdder;
import calculator.domain.delimiter.DelimiterExtractor;
import calculator.domain.delimiter.Delimiters;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.util.converter.IntegerConvertible;
import calculator.util.converter.NumberConvertible;
import calculator.util.splitter.Splitter;

public class Application {

    public static void main(String[] args) {
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Splitter splitter = new Splitter();
        NumberConvertible numberConvertible = new IntegerConvertible();
        Addable adder = new IntegerAdder();

        StringCalculator stringCalculator = new StringCalculator(consoleInputHandler, consoleOutputHandler,
                delimiterExtractor, splitter, numberConvertible, adder);

        Delimiters defaultDelimiters = stringCalculator.initialize();
        stringCalculator.run(defaultDelimiters);
    }

}
