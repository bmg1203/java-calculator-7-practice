package calculator.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {

    public Boolean customDiscrimination(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            return true;
        } else if (!input.startsWith("//") && !input.contains("\\n")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String customExtraction(String customInput) {
        Pattern compiledPattern = Pattern.compile("//" + "(.*?)" + "\\\\n");
        Matcher matcher = compiledPattern.matcher(customInput);
        if (matcher.find()) {
            String extraction = matcher.group(1).trim();
            if (extraction.length() > 1 || extraction.matches("\\d+")) {
                throw new IllegalArgumentException();
            }
            return extraction;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String[] operationSetting(String operationInput, ArrayList<String> separate) {
        String separatorPattern = String.join("|", separate);
        return operationInput.split(separatorPattern);
    }

    public int sumCalculator(String operationInput, ArrayList<String> separateList) {
        int result = 0;
        for (String number : operationSetting(operationInput, separateList)) {
            if (number.matches("[1-9]\\d*")) {
                result += Integer.parseInt(number);
            } else if (number.isEmpty()) {
                result += 0;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}
