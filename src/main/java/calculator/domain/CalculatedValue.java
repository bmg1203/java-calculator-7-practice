package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculatedValue {
    private String value;
    private final List<Integer> NumberValueToken = new ArrayList<>(); //숫자만

    public CalculatedValue(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNumberValueToken(List<Integer> numberValueToken) {
        this.NumberValueToken.addAll(numberValueToken);
    }

    public String getValue() {
        return value;
    }

    public List<Integer> getNumberValueToken() {
        return NumberValueToken;
    }

}
