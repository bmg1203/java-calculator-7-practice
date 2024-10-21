package calculator.domain.preprocess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreprocessorTest {

    private Preprocessor preprocessor;

    @BeforeEach
    void setUp() {
        preprocessor = new Preprocessor(
                new DelimeterSegmentProcessor(),
                new CalculationSegmentProcessor());
    }

    @Test
    @DisplayName("preprocessDelimeter 예외 발생 테스트")
    void preprocessDelimeter_Segment_test_o() {

        String given = "//3\n2,3,4";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            preprocessor.preprocessDelimeterSegment(given);
        });

        assertEquals(e.getMessage(), "구분자로 숫자를 입력했습니다");
    }

    @Test
    @DisplayName("preprocessDelimeter 기능 테스트")
    void preprocessDelimeter_Segment_test_x() {

        String given = "//;\n2,3,4";
        assertEquals(preprocessor.preprocessDelimeterSegment(given), Arrays.asList(",", ":", ";"));
    }

    @Test
    @DisplayName("preprocessString 커스텀 요청 있는 경우")
    void preprocessCalculationSegment_with_customDelimeter() {
        String given = "//>\n2,3,4";
        assertEquals(preprocessor.preprocessCalculationSegment(given), "2,3,4");
    }

    @Test
    @DisplayName("preprocessString 커스텀 요청 없는 경우")
    void preprocessCalculationSegment_without_customDelimeter() {
        String given = "//2,3,4";
        assertEquals(preprocessor.preprocessCalculationSegment(given), "//2,3,4");
    }


    @Test
    @DisplayName("validateInputString 예외 발생 테스트")
    void validateCalculationSegment_exception_o() {
        String input = "//2,3,4";
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            preprocessor.validateCalculationSegment(delimeterList, input);
        });
        assertEquals(e.getMessage(), "구분자 이외의 문자가 있습니다.");
    }

    @Test
    @DisplayName("validateInputString 예외 발생 x 테스트")
    void validateCalculationSegment_exception_x() {
        String input = "2,3:4";
        List<String> delimeterList = new ArrayList<>(Arrays.asList(",", ":"));
        assertDoesNotThrow(() -> preprocessor.validateCalculationSegment(delimeterList, input));
    }
}