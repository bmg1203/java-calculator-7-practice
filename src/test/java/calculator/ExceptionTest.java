package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    public void 정해지지_않은_구분자입력() throws Exception {
        //given
        String inputString = "//;\\n100;2,3$4";
        //when
        Parser parser = new Parser();
        //then
        Assertions.assertThatThrownBy(() -> parser.parse(inputString)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void 커스텀구분자예외처리테스트1() throws Exception {
        //given
        String inputString = "/;\\n1;2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'/'다음에는 '/'가 입력되야 한다");
    }


    @Test
    public void 커스텀구분자예외처리테스트2() throws Exception {
        //given
        String inputString = "//n\\n1;2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 알파벳 n, 문자 '/', 문자 '\\' 는 구분자가 될 수 없다");

    }

    @Test
    public void 커스텀구분자예외처리테스트3() throws Exception {
        //given
        String inputString = "//$\n1;2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자 입력 후에는 '\\' 가 입력되어야 한다");
    }

    @Test
    public void 커스텀구분자예외처리테스트4() throws Exception {
        //given
        String inputString = "//$\\1;2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("'\\'가 입력된 후에는 'n'이 입력되어야 한다");
    }

    @Test
    public void 커스텀구분자예외처리테스트5() throws Exception {
        //given
        String inputString = "///\\n1/2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 알파벳 n, 문자 '/', 문자 '\\' 는 구분자가 될 수 없다");

    }

    @Test
    public void 커스텀구분자예외처리테스트6() throws Exception {
        //given
        String inputString = "//\\\n1/2,3";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 알파벳 n, 문자 '/', 문자 '\\' 는 구분자가 될 수 없다");

    }

    @Test
    public void 커스텀구분자예외처리테스트7() throws Exception {
        //given
        String inputString = "//;\\n1;;2,3;4";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("분리자는 숫자 사이에 사용해야 한다(연속적인 분리자 사용)");
    }

    @Test
    public void 커스텀구분자예외처리테스트8() throws Exception {
        //given
        String inputString = "//;\\n1;2,3;";
        Parser parser = new Parser();
        //when
        Throwable thrown = catchThrowable(() -> parser.parse(inputString));
        //then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("분리자는 숫자 사이에 사용해야 한다(문자열 끝에 사용)");
    }

}
