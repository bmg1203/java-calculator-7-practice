package calculator;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("write number. (. or :)");
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            int result = Calculate.sum(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
