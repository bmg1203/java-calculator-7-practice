package calculator.view;

import calculator.util.CommonIo;

public class InputView {
    private final CommonIo io;

    public InputView() {
        this.io = new CommonIo();
    }

    public String inputData() {
        return io.receiveInput();
    }
}
