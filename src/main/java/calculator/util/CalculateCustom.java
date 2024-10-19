package calculator.util;

import calculator.exception.CalculateException;
import java.util.List;

public class CalculateCustom extends CalculateSeparator {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\\n";
    private static final Integer TWO = 2;

    public static boolean checkNotContainCustom(String userInput) {
        return checkNotContainSeparator(userInput, CUSTOM_PRE) || checkNotContainSeparator(userInput, CUSTOM_POST);
    }

    public static Integer getCustomPreIndex(String userInput) {
        return CalculateSeparator.getIndexNumberOfSeparator(userInput, CUSTOM_PRE);
    }

    public static Integer getCorrectCustomPreIndex(String userInput) {
        return CalculateException.catchCustomPrePositionException(userInput);
    }

    public static Integer getCustomPostIndex(String userInput) {
        return getIndexNumberOfSeparator(userInput, CUSTOM_POST) + TWO;
    }

    public static String getCustomPreToPost(String userInput) {
        return substringUserInputWithSeparator(userInput, makeIndexList(getCorrectCustomPreIndex(userInput), getCustomPostIndex(userInput)));
    }

    public static String getCustomSeparator(String userInput) {
        String splitCustom = getCustomPreToPost(userInput);
        return substringUserInputWithSeparator(splitCustom, makeIndexList(TWO, getUserInputLength(splitCustom) - TWO));
    }

    public static String getUserInput(String userInput) {
        return substringUserInputWithSeparator(userInput, makeIndexList(getCustomPostIndex(userInput), getUserInputLength(userInput)));
    }

    public static List<String> splitWithCustomSeparator(String userInput) {
        return splitWithSeparator(getUserInput(userInput), getCustomSeparator(userInput));
    }
}
