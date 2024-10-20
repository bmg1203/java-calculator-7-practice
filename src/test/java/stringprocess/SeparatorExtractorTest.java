package calculator.stringprocess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.Constant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import stringprocess.SeparatorExtractor;

class SeparatorExtractorTest {
    private final SeparatorExtractor extractor = new SeparatorExtractor(Constant.EXTRACT_REGEX_TEST);

    @Test
    void 커스텀_구분자_추출() {
        //given
        List<String> customSeparator = new ArrayList<>();
        String input = "//;\n4,5:6;//--\n1;2--//^^^\n1;2--3";

        //when
        String stringAfterExtract = extractor.extractCustomSeparator(input, customSeparator);

        //then
        assertThat(customSeparator.size()).isEqualTo(3);
        assertThat(customSeparator).containsExactly(";", "--", "^^^");
        assertThat(stringAfterExtract).isEqualTo("4,5:6;1;2--1;2--3");
    }

    @Test
    void 커스텀_구분자_추출_실패_커스텀_구분자_선언전_사용() {
        //given
        List<String> customSeparator = new ArrayList<>();
        String input = "1,2:3;4;5//;\n:6";

        //then
        assertThrows(IllegalArgumentException.class, () -> extractor.extractCustomSeparator(input, customSeparator),
                "커스텀 구분자 선언이 사용보다 선행되어야합니다.");

    }

}