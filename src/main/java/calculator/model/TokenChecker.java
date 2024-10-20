package calculator.model;

public class TokenChecker {

    private final String delimiters;

    public TokenChecker(String delimiters) {
        this.delimiters = delimiters;
    }

    /*
        t is token counter
        if t is even, token must be a number.
        else          token must be a delimiter.
    */

    // the string cannot end with a delimiter.
    public boolean isDelimiterEnding(int t) {
        return !isEven(t);
    }

    public boolean isNumericToken(String token, int t) {
        if (isEven(t)) {
            return verifyNumericToken(token);
        } else {
            return !verifyDelimiterToken(token);
        }
    }

    private boolean verifyNumericToken(String token) {
        try {
            if (Integer.parseInt(token) >= 0) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean verifyDelimiterToken(String token) {
        if (delimiters.contains(token)) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEven(int t) {
        return t % 2 == 0;
    }

}
