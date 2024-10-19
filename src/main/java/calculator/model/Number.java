package calculator.model;

public class Number {
    private int value;

    Number(Integer value){
        if(!(value instanceof Integer)){
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
        if (value < 0) {
            throw new IllegalArgumentException("입력된 값이 양수가 아닙니다. ");
        }
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
