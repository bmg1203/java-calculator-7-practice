package calculator.util;

import calculator.common.ErrorMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 문자열에서 커스텀 구분자 및 계산식 추출 테스트")
class ExtractionUtilTest {

    @Test
    public void 단일_커스텀_구분자_추출_성공() {
        // given
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;\\n1,2,3", new char[]{';'});
        inputsAndResults.put("//!\\n1,2,3", new char[]{'!'});
        inputsAndResults.put("//\"\\n1,2,3", new char[]{'\"'});
        inputsAndResults.put("//'\\n1,2,3", new char[]{'\''});
        inputsAndResults.put("//$\\n1,2,3", new char[]{'$'});

        // when, then
        inputsAndResults.forEach((input, expected) -> {
            // when
            char[] actual = ExtractionUtil.extractDelimiter(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 커스텀_구분자_설정_없을시_NULL_반환() {
        // given
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("1,2,3", new char[]{});
        inputsAndResults.put("/!\\n1,2,3", new char[]{});
        inputsAndResults.put("//\"1,2,3", new char[]{});
        inputsAndResults.put("1,2,3, ", new char[]{});
        inputsAndResults.put("//$", new char[]{});

        // when, then
        inputsAndResults.forEach((input, expected) -> {
            // when
            char[] actual = ExtractionUtil.extractDelimiter(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 여러_커스텀_구분자_추출_성공() {
        // given
        Map<String, char[]> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;!\\n1,2,3", new char[]{';', '!'});
        inputsAndResults.put("//!+.\\n1,2,3", new char[]{'!', '+', '.'});
        inputsAndResults.put("//\"'|\\n1,2,3", new char[]{'\"', '\'', '|'});
        inputsAndResults.put("//'@#$\\n1,2,3", new char[]{'\'', '@', '#', '$'});

        // when, then
        inputsAndResults.forEach((input, expected) -> {
            // when
            char[] actual = ExtractionUtil.extractDelimiter(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 커스텀_구분자_숫자_지정시_예외_발생() {
        // given
        List<String> inputs = new ArrayList<>();
        inputs.add("//1\\n1,2,3");
        inputs.add("//;1\\n1,2,3");
        inputs.add("//.1!\\n1,2,3");
        inputs.add("//1\\n.\\n1,2,3");
        inputs.add("//.\\n1\\n1,2,3");
        inputs.add("//1\\n2\\n1,2,3");

        // when, then
        inputs.forEach((input) -> {
            Assertions.assertThatThrownBy(() -> ExtractionUtil.extractDelimiter(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NUMERIC_DELIMITER_NOT_ALLOWED.getMessage());
        });
    }

    @Test
    public void 커스텀_구분자_정의시_추출된_문자열_반환_성공() {
        // given
        Map<String, String> inputsAndResults = new HashMap<>();
        inputsAndResults.put("//;\\n1", "1");
        inputsAndResults.put("//!+.\\n1,2,3", "1,2,3");
        inputsAndResults.put("//\"'|\\n  1,2,3", "  1,2,3");
        inputsAndResults.put("//()_**\\n1,2,3 ", "1,2,3 ");
        inputsAndResults.put("//\\n1", "1");
        inputsAndResults.put("//!\\n1!2", "1!2");
        inputsAndResults.put("//:!\\n1:1!1", "1:1!1");
        inputsAndResults.put("//!\\n@\\n1!2@3", "1!2@3");
        inputsAndResults.put("//!\\n@\\n1!2\\n3", "1!2\\n3");
        inputsAndResults.put("//\\n1,2", "1,2");
        inputsAndResults.put("//\\n1,2\\n", "");
        inputsAndResults.put("//\\n\\n\\n\\n1", "\\n\\n1");
        inputsAndResults.put("///\\n1/2", "1/2");
        inputsAndResults.put("//'@#$\\n1,\\n2,3", "2,3");
        inputsAndResults.put("//\\n2\\n121\\n1", "121\\n1");
        inputsAndResults.put("//;!\\n1,2,3\\n", "");
        inputsAndResults.put("//;!\\n1,2,3\\n1,2,3\\n", "1,2,3\\n");
        inputsAndResults.put("//;!\\n1,2,3\\n1,2,3\\n1,2,3", "1,2,3\\n1,2,3");

        // when, then
        inputsAndResults.forEach((input, expected) -> {
            // when
            String actual = ExtractionUtil.extractExpression(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 커스텀_구분자_미정의시_전체_문자열_반환_성공() {
        // given
        Map<String, String> inputsAndResults = new HashMap<>();
        inputsAndResults.put("1,2,3", "1,2,3");
        inputsAndResults.put("4:5:6", "4:5:6");
        inputsAndResults.put("1\\n2,3", "1\\n2,3");
        inputsAndResults.put("\\n1\\n2,3", "\\n1\\n2,3");
        inputsAndResults.put("/1\\n2,3", "/1\\n2,3");
        inputsAndResults.put("123\\n3", "123\\n3");

        // when, then
        inputsAndResults.forEach((input, expected) -> {
            // when
            String actual = ExtractionUtil.extractExpression(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }
}