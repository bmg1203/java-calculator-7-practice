package calculator;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputClass inputClass = new InputClass();
        String inputText = inputClass.input();
        CalculatorStrategy calculatorStrategy;

        if (inputClass.existCustomSeparator(inputText)) {
            calculatorStrategy = new CustomSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }


        if (inputClass.existOriginalSeparator(inputText)) {
            calculatorStrategy = new OriginalSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }


        if (inputClass.isInputBlank(inputText)) {
            System.out.println("결과 : 0");
        }


        if (inputClass.checkOnlyNumber(inputText)) {
            System.out.println("결과 : " + inputText);
        }
    }
}