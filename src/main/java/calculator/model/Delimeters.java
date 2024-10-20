package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Delimeters {

    private List<String> delimeters = new ArrayList<>(Arrays.asList(",", ":"));

    //커스텀 Delimeter 넣기
    public void addDelimeter(final String delimeter) {

        checkDelimeter(delimeter);
        delimeters.add(delimeter);

    }

    //customDelimeter가 존재하는지 확인
    public boolean hasCustomDelimeter() {

        if (delimeters.size() >= 3) {
            return true;
        }

        return false;
    }

    //공식으로부터 Delimeter 를 활용하여 String 형식 숫자추출
    public List<String> getNumbersFromCalculationFormula(final String calculationFormula) {

        String regexString = "";
        for (String regex : delimeters) {
            regexString += regex;
        }

        StringTokenizer tokenizer = new StringTokenizer(calculationFormula, regexString);

        List<String> tokens = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;

    }

    //올바른 Delimeter 인지 판단.
    private void checkDelimeter(final String delimeter) {

        List<String> banList = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));

        for (int i = 0; i < banList.size(); i++) {
            if (delimeter.contains(banList.get(i))) {
                throw new IllegalArgumentException("숫자 형식은 구분자로 사용할 수 없습니다");
            }
        }
    }


}
