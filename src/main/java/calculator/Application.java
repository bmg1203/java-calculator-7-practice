package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Prompt.input();
        InputSequence seq = new InputSequence(input);
        Prompt.output(seq.sum());
    }
}
