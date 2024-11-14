package calculator.constants;

public enum InputPrompts {

    INPUT_PROMPTS("덧셈할 문자열을 입력해 주세요.");

    private final String prompt;

    InputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
