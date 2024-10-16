package calculator.domain.preprocess;

public class DelimeterProcessor {

    public boolean checkCustomDelimeterRequest(String input) {
        if (input.startsWith("//") && input.contains("\n"))
            return true;
        else
            return false;
    }

    public void validateCutomDelimeterRequest(String input) {
        if (input.indexOf("\n") == 2)
            throw new IllegalArgumentException("구분자로 사용할 문자 미입력");
        if (input.indexOf("\n") > 3)
            throw new IllegalArgumentException("구분자로 사용할 문자가 두 글자 이상");
    }
}
