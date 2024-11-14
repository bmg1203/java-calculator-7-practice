package calculator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parse {

    private static final String SPECIAL_CHARACTER = "[\\[\\]{}()|.*+?^$\\\\]";

    public static List<String> parseSeparators(List<String> separators, String input) {
        List<String> newSeparators = addHatchForSpecialCharacter(separators);
        String separator = String.join("|", newSeparators);
        return List.of(input.split(separator));
    }

    //이것 처리 gpt 참고함
    private static List<String> addHatchForSpecialCharacter(List<String> separators) {
        Pattern pattern = Pattern.compile(SPECIAL_CHARACTER);
        List<String> newSeparators = new ArrayList<>();
        for (String string : separators) {
            if (pattern.matcher(string).find()) {
                string = Pattern.quote(string);
            }
            newSeparators.add(string);
        }

        return newSeparators;
    }
}
