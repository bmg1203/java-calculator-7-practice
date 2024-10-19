package calculator.delimiter.handler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// ,와 :로 이루어진 문자열 처리 핸들러
public class ColonSemicolonDelimiterHandler implements DelimiterHandler {
    @Override
    public List<String> split(String str) throws IllegalArgumentException {
        if (!isSupport(str)) {
            throw new IllegalArgumentException("형식이 일치하지 않습니다.");
        }

        String[] splits = str.split("[,:]");

        return Arrays.stream(splits)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isSupport(String str) {
        return !str.isEmpty() && str.matches("[\\d,:]*");
    }
}