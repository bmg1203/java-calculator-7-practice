package calculator;

public class Application {

    public static void main(String[] args) {
        Calculator calc = new Calculator("1,2;3");
        System.out.println(calc.sum());
    }
}
