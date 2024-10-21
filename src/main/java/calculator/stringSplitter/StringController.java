package calculator.stringSplitter;

public class StringController {
    private final StringParser stringParser;
    public StringController(){
        SeparatorManager separatorManager = new SeparatorManager();
        InputValidator inputValidator = new InputValidator();
        this.stringParser = new StringParser(separatorManager,inputValidator);
    }

    public String[] splitsString(String input){
        return stringParser.parse(input);
    }
}
