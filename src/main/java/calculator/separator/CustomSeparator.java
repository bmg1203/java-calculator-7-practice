package calculator.separator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    private String line;

    public CustomSeparator(String line) {
        this.line = line;
    }

    @Override
    public String[] splitLine() {
        String delimiter = extractDelimiter();
        String regex = Pattern.quote(delimiter)+"|:|,";
        if (line.isEmpty()) {
            return null;
        }
        return line.split(regex);
    }

    private String extractDelimiter() {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(line);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            isNumericDelimiter(delimiter);
            line = matcher.group(2);
            return delimiter;
        }
        throw new IllegalArgumentException("입력된 문자열이 올바르지 않습니다.\n"+
                "커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치해야 합니다.");
    }

    private void isNumericDelimiter(String delimiter) {
        try{
            Integer.parseInt(delimiter);
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        } catch (NumberFormatException ignored){
            // 정상 처리
        }
    }

    public String getLine() {
        return line;
    }

}

