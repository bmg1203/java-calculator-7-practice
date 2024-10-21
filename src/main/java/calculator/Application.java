package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        try {
            String line = readLine();
            String regex = "[,:]";
            if (line.startsWith("//")) {
                final int index = line.indexOf("\\n");
                regex = line.substring(2, index);
                line = line.substring(index + 2);
            }
            final String[] words = line.split(regex);
            List<BigDecimal> bigDecimalList = Arrays.stream(words).parallel().map(BigDecimal::new)
                                            .collect(Collectors.toList());
            for (final BigDecimal x : bigDecimalList) {
                if (x.compareTo(BigDecimal.ZERO) < 0) {
                    throw new Exception();
                }
            }

            final BigDecimal answer = bigDecimalList.parallelStream().reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.print("결과 : ");
            System.out.print(answer);
        } catch (Throwable e) {
            throw new IllegalArgumentException();
        }
    }
}
