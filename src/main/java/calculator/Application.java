package calculator;

public class Application {
    public static void main(String[] args) {

        StringAdder stringAdder = new StringAdder();

        String input = ConsoleIO.getInput();
        double result = stringAdder.add(input);
        ConsoleIO.printResult(result);
    }
}
