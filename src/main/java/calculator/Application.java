package calculator;

public class Application {
    public static void main(String[] args) {
        String input = Prompt.input();
        Delimiter delimiter = new Delimiter(input);
        InputPreprocessing preprocessingInput = new InputPreprocessing(delimiter);
        InputSequence seq = new InputSequence(preprocessingInput.of(input));
        Prompt.output(seq.sum());
    }
}
