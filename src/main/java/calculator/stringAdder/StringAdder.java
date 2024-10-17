package calculator.stringAdder;


import calculator.stringAdder.inputvalidator.InputValidator;
import calculator.stringAdder.delimiterParser.DelimiterParser;
import calculator.stringAdder.numberParser.NumberParser;
import calculator.stringAdder.calculator.Calculator;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class StringAdder {
  public static void run() {
    try{
      InputValidator inputValidator = new InputValidator();
      DelimiterParser delimiterParser = new DelimiterParser();
      NumberParser numberParser = new NumberParser();
      Calculator calculator = new Calculator();
      while (true){
        String input = inputValidator.validateInput();
        String[] delimeters = delimiterParser.getDelimiters(input);
        String[] numbers = numberParser.getNumbers(input, delimeters);
        String result = calculator.sum(numbers);
        System.out.println("결과 : "+ result);
      }
    } catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
    } finally{
      System.out.println("애플리케이션을 종료합니다.");
    }
  }
}
