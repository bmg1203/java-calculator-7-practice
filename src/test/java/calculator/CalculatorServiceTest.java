package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    private int answer;
    private CalculatorService cal = new CalculatorService();

    @Test
    void 빈_문자열_처리(){
        String input = "";
        answer = cal.returnAnswer(input);
        assertEquals(0, answer);
    }

    @Test
    void 기본_구분자_처리(){
        String input = "1,2,3";
        int [] expected = {1,2,3};
        int [] actual = cal.splitByDefaultDelimiter(input);
        assertArrayEquals(expected, actual);

        String input2 = "1:2,3";
        int [] expected2 = {1,2,3};
        int [] actual2 = cal.splitByDefaultDelimiter(input2);
        assertArrayEquals(expected2, actual2);
    }

    @Test
    void 커스텁_구분자_처리(){
        String input = "//a\n1a2a3a";
        int [] expected = {1,2,3};
        int [] actual = cal.splitByCustomDelimiter(input);
        assertArrayEquals(expected, actual);

        String input2 = "//ab\n1ab2ab3ab4";
        int [] expected2 = {1,2,3,4};
        int [] actual2 = cal.splitByCustomDelimiter(input2);
        assertArrayEquals(expected2, actual2);
    }

}
