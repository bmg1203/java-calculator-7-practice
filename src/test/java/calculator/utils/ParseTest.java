package calculator.utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParseTest {

    @Test
    void 일반_구분자_구분_테스트() {
        //given
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");

        String input = "1,2:3";

        //when
        List<String> result = Parse.parseSeparators(separators, input);

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.contains("1") && result.contains("2") && result.contains("3"))
                .isTrue();
    }

    @Test
    void 커스텀_구분자_구분_테스트() {
        //given
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
        separators.add(";");

        String input = "1,2;4";

        //when
        List<String> result = Parse.parseSeparators(separators, input);

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.contains("1") && result.contains("2") && result.contains("4"))
                .isTrue();
    }

    @Test
    void 커스텀_구분자_특수문자인_경우_구분_테스트() {
        //given
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
        separators.add("[");

        String input = "1,2[5";

        //when
        List<String> result = Parse.parseSeparators(separators, input);

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.contains("1") && result.contains("2") && result.contains("5"))
                .isTrue();
    }

    @Test
    void 커스텀_구분자_특수문자인_경우_구분_테스트2() {
        //given
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
        separators.add("[");
        separators.add("*");

        String input = "1,2[5*7";

        //when
        List<String> result = Parse.parseSeparators(separators, input);

        //then
        assertThat(result.size()).isEqualTo(4);
        assertThat(result.contains("1") && result.contains("2") && result.contains("5") && result.contains("7"))
                .isTrue();
    }
}