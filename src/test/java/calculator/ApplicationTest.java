package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vaildation.InputValidation.CheckInput;

class ApplicationTest extends NsTest {

    @Test
    void UseCustomSeparator() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void exception_test() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> CheckInput("-1,2,3", ","))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
