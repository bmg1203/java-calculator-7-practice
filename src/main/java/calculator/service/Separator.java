package calculator.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Separator {
    private static final String BASIC_SEPARATOR_COMMA = ",";
    private static final String BASIC_SEPARATOR_COLON = ":";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.+)\\\\n");

    public int[] separate(String content) {
        if (isCustomSeparator(content)) {
            return customSeparate(content);
        }
        return basicSeparate(content);
    }

    private boolean isCustomSeparator(String content) {
        return content.startsWith("//") && content.contains("\\n");
    }

    private int[] basicSeparate(String content) {
        String[] splitedContent = content.replaceAll(BASIC_SEPARATOR_COLON, BASIC_SEPARATOR_COMMA)
                .split(BASIC_SEPARATOR_COMMA);
        return Arrays.stream(splitedContent).mapToInt(this::convertToNumber).toArray();
    }

    private int[] customSeparate(String content) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(content);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String[] splitedContent = splitByCustomSeparator(content.substring(matcher.end()), customSeparator);
            return Arrays.stream(splitedContent).mapToInt(this::convertToNumber).toArray();
        }
        throw new IllegalArgumentException("[ERROR] Separator: 타당하지 않은 형식의 커스텀 구분자");
    }

    private String[] splitByCustomSeparator(String content, String customSeparator) {
        try {
            return content.split(customSeparator);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] Separator: 타당하지 않은 형식의 커스텀 구분자!");
        }
    }

    private int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Separator: 숫자로 변환할 수 없는 값입니다.");
        }
    }

}
