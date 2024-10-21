package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExtractorTest {
    private Extractor extractor;

    @BeforeEach
    void setUp() {
        extractor = new Extractor();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3_1,2:3_,|:", ",2:3_,2:3_,|:"}, delimiter = '_')
    void 기본_구분자_추출(String input, String expected1, String expected2) {
        assertThat(extractor.extractDelimiter(input)).isEqualTo(expected1);
        assertThat(extractor.getDelimiter()).isEqualTo(expected2);
    }

    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3_1;2;3_;", "//\\\\n\\2\\3_\\2\\3_\\", "///\\n/2/_/2/_/"}, delimiter = '_')
    void 커스텀_구분자_추출(String input, String expected1, String expected2) {
        assertThat(extractor.extractDelimiter(input)).isEqualTo(expected1);
        assertThat(extractor.getDelimiter()).isEqualTo(expected2);
    }
}