package calculator;

import static calculator.calculate.Calculator.getResult;
import static calculator.calculate.Calculator.printResult;
import static calculator.input.StringInput.getInput;
import static calculator.split.StringSplit.getBackString;
import static calculator.split.StringSplit.getFrontString;
import static calculator.split.StringSplit.splitStringBySeparator;
import static calculator.validate.StringValidate.validateFrontString;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        String frontString = getFrontString(input);
        String backString = getBackString(input);

        int[] numArr;
        int result;

        if (validateFrontString(frontString)) {
            numArr = splitStringBySeparator(backString, frontString);
            result = getResult(numArr);
            printResult(result);
        }

    }

}
