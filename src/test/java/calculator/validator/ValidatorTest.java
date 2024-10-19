package calculator.validator;

import calculator.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    Validator validator = new Validator("[,:]", "//", "\\n");

    @Test
    void 커스텀_구분자_형식에_벗어날때_예외처리(){
        String value = "//\n1,2,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자가_숫자일때_예외처리(){
        String value = "//1\n1,2,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자가_공백일때_예외처리(){
        String value = "// \n1,2,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_중복될때_예외처리(){
        String value = "//,\n1,2,3";
        assertThatThrownBy(() -> validator.validateDelimiter(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
