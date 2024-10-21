package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();

        try{
            int result = add(input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int add(String input) {
        if(input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "-,|:`@|\\*{}().\\[\\]<>\\?|\\^\\$\\|";

        if(input.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if(matcher.find()){
                delimiter = matcher.group(1);
                input = matcher.group(2);
            }
        }
        return sum(input, delimiter);

    }

    private static int sum(String numbers, String delimiter){
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for(String token : tokens){
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
