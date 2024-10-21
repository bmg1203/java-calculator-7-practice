package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputStringTest {

    @Test
    void 빈_문자열() {
        // given
        var inputString = new InputString("");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void NULL_문자열() {
        // given
        var inputString = new InputString(null);

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        // given
        var inputString = new InputString("1");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        // given
        var inputString = new InputString("1,2,3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론_구분자() {
        // given
        var inputString = new InputString("1:2:3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표_콜론_구분자() {
        // given
        var inputString = new InputString("1,2:3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_여러_숫자() {
        // given
        var inputString = new InputString("//;\n1;2;3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_단일_숫자() {
        //given
        var inputString = new InputString("//;\n1");

        //when
        var result = inputString.getSum();

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 커스텀_구분자_뒤에_위치() {
        //given
        String input = "1//;\n1";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new InputString(input));
    }

    @Test
    void 숫자가_음수() {
        //given
        String input = "-1,2,3";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new InputString(input));
    }

    @Test
    void 커스텀_구분자가_숫자() {
        //given
        String input = "//1\n1";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new InputString(input));
    }

    @Test
    void 커스텀_구분자가_한_글자_초과() {
        //given
        String input = "//;;\n1;2;3";

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new InputString(input));
    }

}
