package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private final Divider divider;


    public NumberParser(Divider divider) {
        this.divider = divider;
    }

    public List<Integer> parse(CalculatedValue calculatedValue){
        List<Integer> result = new ArrayList<>();

        System.out.println(calculatedValue.getValue());

        String[] splitWord = calculatedValue.getValue().split("");
        StringBuilder keepNumber = new StringBuilder();

        for (String s : splitWord) {
            if(s.equals(divider.getComma()) || s.equals(divider.getClon()) || s.equals(divider.getCustomDivider())){
                int number = Integer.parseInt(keepNumber.toString());
                result.add(number);
                keepNumber = new StringBuilder();
                continue;
            }
            if (s.matches("^[0-9]+$")) {
                keepNumber.append(s);
                continue;
            }
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        int number = Integer.parseInt(keepNumber.toString());
        result.add(number);

        return result;
    }







}
