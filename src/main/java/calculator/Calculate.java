package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculate {

    private static String customSeparator = "";

    public int splitString(String input) {
        customSeparator = "";
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            customSeparator = matcher.group(1);
        }
        input = input.replaceAll("\\\\n|/", "");
        List<String> numbers = List.of(input.split(",|:|\\" + customSeparator)).stream().filter(n -> !"".equals(n))
                .collect(Collectors.toList());
        return addition(numbers);
    }

    private int addition(List<String> numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += isPositiveNumber(number);
        }
        return sum;
    }

    private int isPositiveNumber(String number) {
        int num = 0;
        try {
            num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
