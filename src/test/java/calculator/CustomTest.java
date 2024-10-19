package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomTest extends NsTest {

    @Test
    void ZERO_입력(){
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Empty_Input(){
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Non_Numeric_Value_Exception(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void New_Line_Without_Custom_Separator_Exception(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1\\n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Two_Or_More_Separator(){
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void Same_Two_Separator(){
        assertSimpleTest(() -> {
            run("//,,\\n1:2,3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void Very_Big_Number(){
        assertSimpleTest(() -> {
            run("100000000000000000000000000000000000000000000000000000:1");
            assertThat(output()).contains("결과 : 100000000000000000000000000000000000000000000000000001");
        });
    }

    @Test
    void Negative_Number_Exception(){

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Begin_With_Slash_No_End_Exception(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1:2:3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void No_Slash_End_Line_Exception(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n1:2:3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }




    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
