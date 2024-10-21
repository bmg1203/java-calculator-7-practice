package calculator.constants;

public enum DesignSeparator implements SymbolDetails {

    START("//"),
    END("\\n");

    private final String symbol;

    DesignSeparator(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Integer getSymbolLength() {
        return symbol.length();
    }
}
