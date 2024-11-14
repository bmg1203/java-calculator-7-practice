package calculator.constants;

public enum OutputPrompts {

    OUTPUT_PROMPTS("결과 : %d");

    private final String prompt;

    OutputPrompts(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }
}
