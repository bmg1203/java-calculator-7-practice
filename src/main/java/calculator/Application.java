package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(checkInput(input)) {
            int result = getSum(parseInteger(seperator(input)));
            System.out.println("결과 : " + result);
        } else {
            throw new IllegalArgumentException();
        }

        Console.close();
    }

    public static boolean checkInput(String input){
        return input != null && !input.isEmpty();
    }

    public static String[] seperator(String input){
        String[] arr;

        if(input.contains("//") && input.contains("\\n")){
            int i = input.indexOf("//");
            String s = "" + input.charAt(i+2);
            input = input.replace("//"+s+"\\n", "");
            arr = input.split(s);
        } else {
            arr = input.split(",|:");
        }

        return arr;
    }

    public static int[] parseInteger(String[] arr){
        int[] numbers = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            numbers[i] = Integer.parseInt(arr[i].replaceAll(" ", ""));
        }

        return numbers;
    }

    public static int getSum(int[] numbers){
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }

        return sum;
    }
}
