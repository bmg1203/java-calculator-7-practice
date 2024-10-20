package calculator;

import static exception.ErrorMsg.INVALID_INPUT_MESSAGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Calculator {

    private ArrayList<String> separator;

    public void addSeparator(String newSeparator) {
        this.separator.add(newSeparator);
    }

    public void setDefaultSeparator(String[] separator) {
        this.separator = new ArrayList<>();
        this.separator.addAll(Arrays.asList(separator));
    }


    public String getCustomSeparator(String inStr) {
        if (inStr.startsWith("//")) {
            if (inStr.contains("\\n")) {
                int separatorEndIdx = inStr.indexOf("\\n");
                String customSeparator = inStr.substring(2, separatorEndIdx);
                addSeparator(customSeparator);

                String restStr = inStr.substring(separatorEndIdx + 2);
                if (restStr.contains("\\n") || restStr.contains("//")) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
                return customSeparator;
            } else {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
        return "";
    }

    public void inspectInStr(String inStr, String customSeparator) {
        if (!"".equals(inStr)) {
            String str = inStr.replace(",", "")
                    .replace(":", "")
                    .replace("//", "")
                    .replace("\\n", "")
                    .replace(customSeparator, "");
            try {
                long changedValue = Long.parseLong(str);
                if (changedValue < 0) {
                    throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }

    public long calculateResult(String inStr, String customSeparator) {
        if (!"".equals(customSeparator)) {
            int subIdx = inStr.indexOf("\\n");
            inStr = inStr.substring(subIdx + 2);
        }

        long returnNum = 0;
        StringBuilder delim = new StringBuilder();
        for (String separator : this.separator) {
            delim.append(separator);
        }
        StringTokenizer st = new StringTokenizer(inStr, delim.toString());
        while (st.hasMoreTokens()) {
            returnNum += Long.parseLong(st.nextToken());
        }
        return returnNum;
    }

}
