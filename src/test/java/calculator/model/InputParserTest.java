package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser = new InputParser();

    @Test
    @DisplayName("기본구분자 사용확인 테스트")
    public void checkDefaultDelimiterTest() {
        //given
        String input = "1,2:3";
        String input2 = "1";

        //when
        boolean hasDefaultDelimiter = inputParser.checkDefaultDelimiter(input);
        boolean hasDefaultDelimiter2 = inputParser.checkDefaultDelimiter(input2);

        //then
        assertThat(hasDefaultDelimiter).isTrue();
        assertThat(hasDefaultDelimiter2).isTrue();
    }

    @Test
    @DisplayName("기본구분자 사용확인 예외 테스트")
    public void checkDefaultDelimiterExceptionTest() {
        //given
        String input1 = "1;2,3";
        String input2 = "-1,2,3";

        //when
        boolean result1 = inputParser.checkDefaultDelimiter(input1);
        boolean result2 = inputParser.checkDefaultDelimiter(input2);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
    }

    @Test
    @DisplayName("기본구분자 List 변환 테스트")
    public void convertDefaultDelimiterTest() {
        //given
        String input = "1,2:3";
        String input2 = "1";

        //when
        List<Integer> result1 = inputParser.convertDefaultDelimiter(input);
        List<Integer> result2 = inputParser.convertDefaultDelimiter(input2);

        //then
        assertThat(result1).isEqualTo(List.of(1, 2, 3));
        assertThat(result2).isEqualTo(List.of(1));
    }

    @Test
    @DisplayName("커스텀 구분자 List 변환 테스트")
    public void convertCustomDelimiterTest() {
        //given
        String input1 = "//;\\n1;2;3";
        String input2 = "//;\\n1";
        String input3 = "//*\\n4*5*6";
        String input4 = "//*\\n"; // 숫자부분 빈 문자열

        //when
        List<Integer> result1 = inputParser.convertCustomDelimiter(input1);
        List<Integer> result2 = inputParser.convertCustomDelimiter(input2);
        List<Integer> result3 = inputParser.convertCustomDelimiter(input3);
        List<Integer> result4 = inputParser.convertCustomDelimiter(input4);

        //then
        assertThat(result1).isEqualTo(List.of(1, 2, 3));
        assertThat(result2).isEqualTo(List.of(1));
        assertThat(result3).isEqualTo(List.of(4, 5, 6));
        assertThat(result4).isEqualTo(List.of()); // 숫자부분 빈 문자열 처리
    }

    @Test
    @DisplayName("커스텀 구분자 List 변환 예외테스트")
    public void convertCustomDelimiterExceptionTest() {
        //given
        String input1 = "//]\\n1;2;3";
        String input2 = "/;\\n1;2;3";

        //then
        assertThrows(IllegalArgumentException.class,
            () -> inputParser.convertCustomDelimiter(input1));
        assertThrows(IllegalArgumentException.class,
            () -> inputParser.convertCustomDelimiter(input2));
    }

    @Test
    @DisplayName("양수 검사 테스트")
    public void checkPositiveNumberTest() {
        //given
        List<Integer> list = List.of(1, 2, 3);

        //then
        assertDoesNotThrow(() -> inputParser.checkPositiveNumber(list));
    }

    @Test
    @DisplayName("양수 검사 예외 테스트")
    public void checkPositiveNumberExceptionTest() {
        //given
        List<Integer> list1 = List.of(-1, 2, 3);
        List<Integer> list2 = List.of(0, 2, 3);

        //then
        assertThrows(IllegalArgumentException.class,
            () -> inputParser.checkPositiveNumber(list1));
        assertThrows(IllegalArgumentException.class,
            () -> inputParser.checkPositiveNumber(list2));

    }
}