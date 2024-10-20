package calculator.common.io;

import static calculator.common.message.IOMessage.ENTER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputManager implements IOManager {

    private static InputManager inputManager;

    // Constructor
    private InputManager() {
    }

    public static InputManager getInstance() {
        if (Objects.isNull(inputManager)) {
            inputManager = new InputManager();
        }
        return inputManager;
    }

    // Method
    public String enterInput() {
        printMessage(ENTER_INPUT);
        return Console.readLine();
    }
}
