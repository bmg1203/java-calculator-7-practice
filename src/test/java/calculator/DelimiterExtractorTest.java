package calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class DelimiterExtractorTest {

    @Test
    void 커스텀_구분자_문자열에_음수가_있는_경우_마이너스가_구분자로_인식되지_않게한다() {
        String input = "//;\n1;2;-3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        assertDoesNotThrow(delimiterExtractor::validate);
    }

    @Test
    void 기본_구분자_문자열에_음수가_있는_경우_마이너스가_구분자로_인식되지_않게한다() {
        String input = "1,2,-3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        assertDoesNotThrow(delimiterExtractor::validate);
    }

    @Test
    void 커스텀_구분자로_대시를_사용하면_IllegalArgumentException_예외가_발생한다() {
        String input = "//-\n1-2-3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        assertThrows(IllegalArgumentException.class, delimiterExtractor::validate);
    }

    @Test
    void 커스텀_구분자로_온점을_사용하면_IllegalArgumentException_예외가_발생한다() {
        String input = "//.\n1.2.3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        assertThrows(IllegalArgumentException.class, delimiterExtractor::validate);
    }

    @Test
    void 잘못된_커스텀_구분자가_있으면_IllegalArgumentException_예외가_발생한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("//;\n1;2$3");

        assertThrows(IllegalArgumentException.class, delimiterExtractor::validate);
    }

    @Test
    void 잘못된_기본_구분자가_있으면_IllegalArgumentException_예외가_발생한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3#-4");

        assertThrows(IllegalArgumentException.class, delimiterExtractor::validate);
    }

    @Test
    void 커스텀_구분자_문자열에서_사용자가_정의한_구분자를_추출한다() {
        String input = "//;\n1;2;3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        String input2 = "//-\n1-2-3";
        DelimiterExtractor delimiterExtractor2 = new DelimiterExtractor(input2);

        assertEquals(";", delimiterExtractor.extractCustomDelimiter());
        assertEquals("-", delimiterExtractor2.extractCustomDelimiter());
    }

    @Test
    void 커스텀_구분자_문자열에_사용된_구분자를_추출한다() {
        String input = "//;\n1;2;3";
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor(input);

        String delimiterLeft = delimiterExtractor.remove();

        String expected = " ; ; ";
        assertEquals(expected, delimiterLeft);
    }

    @Test
    void 기본_구분자_문자열에_사용된_구분자를_추출한다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3,-4");

        String delimiterLeft = delimiterExtractor.remove().trim();
        String expected = ", : ,";
        assertEquals(expected, delimiterLeft);
    }

    @Test
    void 커스텀_구분자를_사용한_경우_구분자_타입은_CUSTOM_이다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("//;\n1;2;3");

        DelimiterType type = delimiterExtractor.type();

        assertEquals(DelimiterType.CUSTOM, type);
    }

    @Test
    void 기본_구분자를_사용한_경우_구분자_타입은_BASIC_이다() {
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor("1,2:3");

        DelimiterType type = delimiterExtractor.type();

        assertEquals(DelimiterType.BASIC, type);
    }

    @Test
    void 문자열에_구분자가_없으면_문자열을_그대로_반환한다() {
        String inputEmpty = "";
        DelimiterExtractor extractor1 = new DelimiterExtractor(inputEmpty);
        extractor1.validate();
        String emptyText = extractor1.getText();

        String inputOnlyNumber = "1";
        DelimiterExtractor extractor2 = new DelimiterExtractor(inputOnlyNumber);
        extractor2.validate();
        String onlyNumberText = extractor2.getText();

        assertEquals("", emptyText);
        assertEquals("1", onlyNumberText);
    }

    @Test
    void 문자열에_구분자가_있는지_확인한다() {
        String empty = "";
        DelimiterExtractor delimiterExtractorA = new DelimiterExtractor(empty);

        String positiveNumber = "12.345";
        DelimiterExtractor delimiterExtractorB = new DelimiterExtractor(positiveNumber);

        assertFalse(delimiterExtractorA.hasDelimiter());
        assertFalse(delimiterExtractorB.hasDelimiter());
    }
}
