package calculator;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Preprocessor preprocessor = new Preprocessor();
        Calculator calculator = new Calculator();
        outputView.printResult(calculator.sum(preprocessor.preprocess(inputView.read())));
    }
}
