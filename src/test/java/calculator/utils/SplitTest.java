package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SplitTest {

    @Test
    void 커스텀_구분자_추출_테스트() {
        //given
        String input = "//;\\n1:2,3;4";

        //when
        List<String> result = Split.customSplit(input);

        //then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.contains(";")).isTrue();
    }

    @Test
    void 커스텀_구분자_여러개_테스트() {
        //given
        String input = "//;\\n1:2,3//t\\n;4";

        //when
        List<String> result = Split.customSplit(input);

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.contains(";")).isTrue();
        assertThat(result.contains("t")).isTrue();
    }

    @Test
    void 커스텀_문자열_제거_테스트() {
        //given
        String input = "//;\\n1:2,3;4";

        //when
        String result = Split.removeCustom(input);

        //then
        assertThat(result).isEqualTo("1:2,3;4");
    }

    @Test
    void 커스텀_문자열_여러개_제거_테스트() {
        //given
        String input = "//;\\n1:2,3//t\\n;4";

        //when
        String result = Split.removeCustom(input);

        //then
        assertThat(result).isEqualTo("1:2,3;4");
    }
}