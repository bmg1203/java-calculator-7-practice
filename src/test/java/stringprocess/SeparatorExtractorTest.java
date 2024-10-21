package stringprocess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.Constant;
import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeparatorExtractorTest {
    private List<String> customSeparators;
    private SeparatorExtractor extractor;

    @BeforeEach
    void init() {
        customSeparators = new ArrayList<>();
        extractor = new SeparatorExtractor(Constant.CUSTOM_SEPARATOR_PREFIX, Constant.EXTRACT_REGEX_TEST,
                customSeparators);
    }

    @Test
    void 커스텀_구분자_추출() {
        //given
        String input = "//;\n4,5:6;//--\n1;2--//^^^\n1;2--3";

        //when
        String stringAfterExtract = extractor.extractCustomSeparator(input);

        //then
        assertThat(customSeparators.size()).isEqualTo(3);
        assertThat(customSeparators).containsExactly(";", "--", "^^^");
        assertThat(stringAfterExtract).isEqualTo("4,5:6;1;2--1;2--3");
    }

    @Test
    void 커스텀_구분자_추출_실패_커스텀_구분자_선언전_사용() {
        //given
        String input = "1,2:3;4;5//;\n:6";

        //then
        assertThrows(IllegalArgumentException.class, () -> extractor.extractCustomSeparator(input),
                ErrorMessage.CUSTOM_SEPARATOR__DECLARATION_ORDER_ERROR);

    }
    

    @Test
    void 커스텀_구분자에_숫자_포함() {
        //given
        String input = "1,2:3//-0-\n-0-4";

        //then
        assertThrows(IllegalArgumentException.class, () -> extractor.extractCustomSeparator(input),
                ErrorMessage.CUSTOM_SEPARATOR_CONTAINS_NUM);
    }

}