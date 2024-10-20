package calculator.utils;

public class NumberUtils {

    private NumberUtils() {

    }

    public static boolean isNumeric(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(Double number) {
        return number == (long) (double) number;
    }
}
