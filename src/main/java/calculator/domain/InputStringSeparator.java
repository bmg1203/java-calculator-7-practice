package calculator.domain;

public class InputStringSeparator {
    private String inputString;
    private String finalSeparator;
    private String customSeparator = "";
    private String[] inputNumber; // int vs integear ??
    private int startIndex;
    private int lastIndex;
    private boolean isCustomSeparatorContained = false;

    public InputStringSeparator(String inputString) {
        validateInputString(inputString);
        setInputString(inputString);
        setCustomSeparator();
        setFinalSeparator();
        setInputNumber();
    }

    private void validateInputString(String inputString) {
        boolean isFirstCustomSeparator = inputString.contains("//");
        boolean isLastCustomSeparator = inputString.contains("\\n");
        if (isFirstCustomSeparator != isLastCustomSeparator) {
            throw new IllegalArgumentException("형식을 지켜 커스텀 구분자를 지정해야 합니다.");
        }
        if (isFirstCustomSeparator) {
            if (inputString.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자를 먼저 지정한 후 숫자를 입력하세요.");
            }
        }
        if (isFirstCustomSeparator && isLastCustomSeparator) {
            this.isCustomSeparatorContained = true;
        }
    }

    private void setInputString(String inputString) {
        this.inputString = inputString.replaceAll("\n", "\\n");
    }

    private void setCustomSeparator() {
        if (isCustomSeparatorContained) {
            startIndex = inputString.indexOf("//") + 2;
            lastIndex = inputString.indexOf("\\n");
            this.customSeparator = inputString.substring(startIndex, lastIndex); //커스텀 구분자는 그럼 한 개만인가?
        }
    }

    private void setFinalSeparator() {
        if (this.customSeparator.isEmpty()) {
            this.finalSeparator = ",|:";
            return;
        }
        this.finalSeparator = ",|:|" + this.customSeparator;
    }

    private void setInputNumber() {
        if (isCustomSeparatorContained) {
            this.inputString = inputString.substring(lastIndex + 2);
        }
        if (inputString.length() > 0) {
            this.inputNumber = inputString.split(finalSeparator);
        }
    }

    public String[] getInputNumber() {
        return this.inputNumber;
    }
}
