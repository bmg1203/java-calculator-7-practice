package calculator.dto.response;

public class DelimiterExtractResponse {
    private String delimiter;
    private String remainInput;

    public DelimiterExtractResponse(String delimiter, String remainInput) {
        this.delimiter = delimiter;
        this.remainInput = remainInput;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getRemainInput() {
        return remainInput;
    }
}
