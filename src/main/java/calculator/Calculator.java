package calculator;

public class Calculator {
    private final Alu alu;

    public Calculator(Alu alu) {
        this.alu = alu;
    }

    public Long excute() {
        return alu.calculate();
    }
}
