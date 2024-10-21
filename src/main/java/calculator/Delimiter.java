package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {
    private ArrayList<String> delimiters = new ArrayList<>(List.of(",", ":"));

    public String setDelimiters(String str){
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex != -1) {
                String customDelimiter = str.substring(2, delimiterIndex);
                if (!customDelimiter.isEmpty()) {
                    delimiters.add(customDelimiter);
                }
                for (char c : customDelimiter.toCharArray()) {
                    if (Character.isDigit(c)) {
                        throw new IllegalArgumentException();
                    }
                }
                str = str.substring(delimiterIndex + 2);
                if (str.isEmpty()) {
                    System.out.print("결과 : 0");
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return str;
    }

    public String makeSplitDelimiters(){
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }

    public ArrayList<String> getDelimiters() {
        return delimiters;
    }
}
