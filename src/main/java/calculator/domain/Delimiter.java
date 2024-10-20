package calculator.domain;

public class Delimiter {
    public static final char COMMA_DELIMITER = ',';
    public static final char COLON_DELIMITER = ':';
    public final Character CUSTOM_DELIMITER;

    public Delimiter(){
        CUSTOM_DELIMITER = null;
    }
    public Delimiter(String userInputMessage){
        this.CUSTOM_DELIMITER = findCustomDelimiter(userInputMessage);
    }

    private Character findCustomDelimiter(String userInputMessage){
        if(userInputMessage.substring(0, 2).equals("//") && userInputMessage.substring(3, 5).equals("\\n")){
            return userInputMessage.charAt(2);
        }
        else throw new IllegalArgumentException();
    }

    public boolean hasCustomDelimiter(){
        if(CUSTOM_DELIMITER != null) return true;
        else return false;
    }
}
