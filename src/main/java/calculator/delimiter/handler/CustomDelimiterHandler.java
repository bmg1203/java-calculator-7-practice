package calculator.delimiter.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimiterHandler implements DelimiterHandler {

    @Override
    public List<String> split(String str) {
        if (!supports(str)) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }
        String delimiter = extractDelimiter(str);

        str = str.substring(str.indexOf("\\n") + 2);

        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        if (!str.matches("\\d+(?:" + Pattern.quote(delimiter) + "\\d+)*")) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }

        return Arrays.stream(str.split(Pattern.quote(delimiter)))
                .collect(Collectors.toList());
    }

    @Override
    public boolean supports(String str) {
        return !str.isEmpty() && str.matches("^//.\\\\n.*");
    }

    public String extractDelimiter(String s) {
        Pattern pattern = Pattern.compile("//(.)\\\\n");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("구분자를 찾을 수 없습니다.");
    }
}
