package calculator.view;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class OutputView {

    public void printTotal(final BigInteger total) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        System.out.println(String.join(" : ", "결과", numberFormat.format(total)));
    }

}
