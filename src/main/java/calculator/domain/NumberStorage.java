package calculator.domain;

import calculator.utility.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberStorage {
    private final List<Double> numberList = new ArrayList<Double>();

    public void addNumber(String num, Delimiter delimiter){
        Utils.checkAllowedDelimiters(num, delimiter);
        checkDecimalNumber(num);
        checkZeroNumber(num);
        numberList.add(Double.valueOf(num));
    }

    private void checkDecimalNumber(String num){
        if(num.charAt(0) == '.' || num.charAt(num.length()-1) == '.'){
            throw new IllegalArgumentException();
        }
    }
    private void checkZeroNumber(String num){
        if(Double.valueOf(num).equals(0.0)){
            throw new IllegalArgumentException();
        }
    }

    public BigDecimal getTotalSum(){
        BigDecimal totalSum = new BigDecimal("0.0");
        for(int i = 0; i < numberList.size(); i++){
            totalSum = new BigDecimal(String.valueOf(totalSum.add(new BigDecimal(Double.toString(numberList.get(i))))));
        }
        return totalSum;
    }
}
