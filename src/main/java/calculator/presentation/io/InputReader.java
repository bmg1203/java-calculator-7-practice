package calculator.presentation.io;

import calculator.presentation.dto.InputData;
import camp.nextstep.edu.missionutils.Console;

public final class InputReader {

    private InputReader() {
    }

    public static InputData read() {
        return new InputData(Console.readLine());
    }
}
