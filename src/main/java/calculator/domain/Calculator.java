package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {

    private static Integer CUSTOM_SEPARATOR_START_INDEX = 2;
    private static Integer CUSTOM_SEPARATOR_END_INDEX = 3;


    public String[] extractNumber(String text) {
        String arr[] = text.split("[,|:]");
        return arr;
    }

    public String[] extractNumber(String customSeparator, String text) {
        String regex = Pattern.quote(customSeparator);
        String arr[] = text.split(regex);
        return arr;
    }

    public String findCustomSeparator(String inputText) {
        return inputText.substring(CUSTOM_SEPARATOR_START_INDEX, CUSTOM_SEPARATOR_END_INDEX);
    }

    public String removeCustomReserveWord(String inputText) {
        return inputText.substring(5);
    }


    public void sum(String[] extractNumberArr) {
        int sum = 0;
        for (String str : extractNumberArr) {
            try {
                sum += validateNumber(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                if (isInputBlank(extractNumberArr)) {
                    System.out.println("결과 : " + sum);
                }
                if (!isInputBlank(extractNumberArr)) {
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println("결과 : " + sum);
    }

    private Boolean isInputBlank(String[] arr) {
        if (arr.length != 1) {
            return false;
        }
        return true;
    }

    private int validateNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new IllegalArgumentException();
        }
        return positiveNumber;
    }
}
