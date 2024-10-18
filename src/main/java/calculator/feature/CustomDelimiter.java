package calculator.feature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {

    String str;

    public CustomDelimiter(String str) {
        this.str = str;
    }

    public char[] getDelimiter() {
        Pattern pattern = Pattern.compile("//(.*?)\\n"); // '//' �� '\n' ���� ����
        Matcher matcher = pattern.matcher(str);

        return matcher.group(1).toCharArray();
    }

}
