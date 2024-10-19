package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import calculator.domain.Extractor;
import org.junit.jupiter.api.Test;

class ExtractorTest {

    @Test
    public void 문자열에서_커스텀_구분자를_추출한다() {
        //given
        Extractor ex = new Extractor();
        String input = "//;\\n1;2;3";

        //when
        String result = ex.extractDelimiter(input);

        //then
        assertThat(result).isEqualTo(";");
    }

    @Test
    public void 문자열에서_커스텀_구분자를_추출한다2() {
        //given
        Extractor ex = new Extractor();
        String input = "1,2;3";

        //when
        String result = ex.extractDelimiter(input);

        //then
        assertThat(result).isEqualTo("");
    }

    @Test
    public void 커스텀_구분자로_숫자를_추출한다() {
        //given
        Extractor ex = new Extractor();
        String input = "//?\\n1?2?3";

        //when
        String delimiter = ex.extractDelimiter(input);
        int[] result = ex.makeNumberArray(input, delimiter);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 커스텀_구분자로_숫자를_추출한다2() {
        //given
        Extractor ex = new Extractor();
        String input = "//[\\n1[2[3";

        //when
        String delimiter = ex.extractDelimiter(input);
        int[] result = ex.makeNumberArray(input, delimiter);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 기본_구분자로_숫자를_추출한다() {
        //given
        Extractor extractor = new Extractor();
        String input = "1,2:3";
        String delimiter = extractor.extractDelimiter(input);

        //when
        int[] result = extractor.makeNumberArray(input, delimiter);

        //then
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    public void 입력은_올바른_형식을_가져야한다() {
        //given
        // 맨 처음은 숫자이거나 // 여야함
        // //로 시작한다면 \\n이 있어야함

        //when

        //then

    }
}