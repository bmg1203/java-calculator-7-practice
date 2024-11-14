package calculator.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {

    private static final String CUSTOM_EXTRACT = "//(.*?)\\\\n";

    public static List<String> customSplit(String input) {
        input = input.replaceAll(" ", "");

        Pattern pattern = Pattern.compile(CUSTOM_EXTRACT);
        Matcher matcher = pattern.matcher(input);
        List<String> customSpearator = new ArrayList<>();

        while (matcher.find()) {
            splitNoGap(matcher.group(1).trim(), customSpearator);
        }
        return customSpearator;
    }

    private static void splitNoGap(String input, List<String> customSpearator) {
        List<String> strings = List.of(input.split(""));
        customSpearator.addAll(strings);
    }

    public static String removeCustom(String input) {
        return input.replaceAll(CUSTOM_EXTRACT, "");
    }
}
