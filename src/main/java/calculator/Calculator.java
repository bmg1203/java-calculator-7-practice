package calculator;

public class Calculator {
    public int sum(String str) {
        String[] nums = str.split(",|:");
        int sum = 0;

        for(String s : nums) {
            int number = Integer.parseInt(s);
            sum += number;
        }

        return sum;
    }
}
