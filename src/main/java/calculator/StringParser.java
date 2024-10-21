package calculator;

import calculator.numberExtractor.NumberExtractor;
import calculator.separatorProvider.SeparatorProvider;
import java.util.List;
import java.util.Set;

/**
 * 문자열을 통해 숫자 리스트를 분리하는 역할
 */
public class StringParser {

    private final SeparatorProvider separatorProvider;
    private final NumberExtractor numberExtractor;

    public StringParser(
            SeparatorProvider separatorProvider,
            NumberExtractor numberExtractor
    ) {
        this.separatorProvider = separatorProvider;
        this.numberExtractor = numberExtractor;
    }

    /**
     * 구분자 문자열과 숫자 문자열을 받아 문자열을 파싱하고, 그 결과인 숫자 리스트를 반환한다.
     *
     * @param customSeparatorString 구분자 문자열, //와\n가 제외된 형태로 입력된다. (예: ^&*)
     * @param numberString          숫자 문자열, 숫자와 문자의 조합으로 입력된다. (예: 1:2,53;1)
     * @return 분리된 숫자 리스트
     */
    public List<Integer> parse(String customSeparatorString, String numberString) {
        Set<Character> separator = separatorProvider.getSeparator(customSeparatorString);

        return numberExtractor.extract(numberString, separator);
    }
}
