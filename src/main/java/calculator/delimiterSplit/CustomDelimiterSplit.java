package calculator.delimiterSplit;

public class CustomDelimiterSplit{

    public static String[] customDelimiterSplit(String input, int inputLen, String basicDelimiter){
        int idx = input.indexOf("\\n", 2);
        String customDelimiter = basicDelimiter + "|";

        if (inputLen == idx+2){
            return null;
        }

        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        } else{
            // |가 커스텀구분자에 포함되었을 경우에 \\|로 치환하여 문자로 인식하도록
            customDelimiter += input.substring(2, idx).replace("|", "\\|");
        }

        String operandStr = input.substring(idx+2, inputLen);
        return operandStr.split(customDelimiter);
    }
}
