package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        Console.close();
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    void 사용자_입력_읽기() {
        String mockInput = "1,2:3";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        var runner = new InputHandler();

        String result = runner.readInput();

        assertThat(result).isEqualTo("1,2:3");
    }

    @Test
    void 커스텀_구분자_추출() {
        String mockInput = "//a\\n1,2:3";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        var runner = new InputHandler();

        String userInput = runner.readInput();

        char result = runner.extractCustomDelimiter(userInput);
        assertThat(result).isEqualTo('a');
    }

    @Test
    void 커스텀_구분자_포함_여부() {
        String mockInput = "1,2:3";
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        var runner = new InputHandler();
        String userInput = runner.readInput();

        assertThat(runner.isCustomDelimiterPresent(userInput)).isFalse();
    }
}
