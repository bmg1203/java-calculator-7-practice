package calculator;


import java.util.ArrayList;

public class Parser {
    static int result=0;
    static ArrayList<Integer> numbers;
    private static String delimiters=",|:";

    public static String startsWithCustomDelimiter(String customDelimiter, String input) {
        delimiters+="|"+customDelimiter;
        parseInputBasedOnDelimiter(input);
        return new StringBuilder().append(result).toString();
    }

    public static String startsWithPositiveNumber(String input) {
        parseInputBasedOnDelimiter(input);
        return new StringBuilder().append(result).toString();
    }

    private static void parseInputBasedOnDelimiter(String input) {
        numbers = new ArrayList<>();
        for(String number : input.split(delimiters)){
            numbers.add(Integer.parseInt(number));
        }
        for(int number: numbers){
            result+=number;
        }
    }


}
