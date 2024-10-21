package calculator.domain;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ExtractorTest {

    @Test
    void 커스텀_구분자_추출하기() {
        Extractor extractor = new Extractor("//;\n1;2;3");
        Separator customSeparator = new Separator(";");
        assertEquals(customSeparator.getSeparator(), extractor.getCustomSeparators().get(0).getSeparator());
    }

    @Test
    void 숫자_추출하기() {
        Extractor extractor = new Extractor("//'\n1:2,3//|\n//;\n4|5");
        List<Number> numbers = extractor.getNumbers();
        List<Number> answer = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(34),
                new Number(5)
        );
        for (int i = 0; i < 4; i++) {
            assertEquals(numbers.get(i).getNumber(), answer.get(i).getNumber());
        }
    }

    @Test
    void 구분자_한_개씩_존재_유효성_검사() {
        try {
            Extractor extractor = new Extractor("//;\n1;;2;3");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 구분자는 한 개씩 존재해야 합니다.", e.getMessage());
        }
    }

    @Test
    void 구분자_이외_문자_입력_에러_처리() {
        try {
            Extractor extractor = new Extractor("//;\n1;2*3");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 구분자 이외의 문자가 입력되면 안됩니다.", e.getMessage());
        }
    }
}
