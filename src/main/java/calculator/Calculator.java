package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Calculator {
    private String division;
    private final List<Integer> numbers = new ArrayList<>();
    private final String COMMA = ",";
    private final String COLON = ":";

    public void getDivision(String inputString) {
        if (inputString != null && inputString.startsWith("//")) {
            division = inputString.replace("//", "");
        }
    }

    public void getNumbers(String inputString) {
        if (inputString.isBlank()) {
            return;
        }

        List<String> strings = new ArrayList<>();
        String regex = COMMA + "|" + COLON;

        if (division != null) {
            StringTokenizer tokenizer = new StringTokenizer(inputString, division);
            while (tokenizer.hasMoreTokens()) {
                strings.addAll(Arrays.asList(tokenizer.nextToken().split(regex)));
            }
        } else {
            strings.addAll(Arrays.asList(inputString.split(regex)));
        }

        for (String string : strings) {
            int number = Integer.parseInt(string);
            if (number < 1) {
                throw new IllegalArgumentException();
            }
            numbers.add(number);
        }
    }

    public int calculateNumber() {
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    public Map<String, String> split(String inputString) {
        Map<String, String> splitString = new HashMap<>();

        if (inputString.startsWith("//")) {
            int index = inputString.indexOf("\\n");

            if (index == -1) {
                throw new IllegalArgumentException();
            }

            splitString.put("division", inputString.substring(0, index));
            splitString.put("number", inputString.substring(index + 2));
        } else {
            splitString.put("division", null);
            splitString.put("number", inputString);
        }

        return splitString;
    }

    public boolean isValid(String inputString) {
        if (division != null) {
            inputString = inputString.replace(division, "");
        }

        inputString = inputString.replace(COMMA, "").replace(COLON, "");

        char[] inputChars = inputString.toCharArray();
        for (char inputChar : inputChars) {
            if (!Character.isDigit(inputChar)) {
                return false;
            }
        }
        return true;
    }
}
