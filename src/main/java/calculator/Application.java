package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.setInput();
        stringCalculator.addDelimiter();
        stringCalculator.sumDelimitedNumbers();
    }
}

