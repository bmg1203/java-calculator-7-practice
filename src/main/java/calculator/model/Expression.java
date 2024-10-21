package calculator.model;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean hasCustomSeparator() {
        return expression.startsWith("//");
    }

    public String separatorSection() {
        int startIdx = expression.indexOf("//") + 2;
        int endIdx = expression.indexOf("\\n");
        return expression.substring(startIdx, endIdx);
    }

    public String nonSeparatorSection() {
        int startIdx = expression.indexOf("\\n") + 2;
        return expression.substring(startIdx);
    }

    public String getExpression() {
        return expression;
    }
}
