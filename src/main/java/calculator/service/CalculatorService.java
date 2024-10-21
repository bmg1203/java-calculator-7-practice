package calculator.service;

import java.util.Arrays;

public class CalculatorService {
    public String[] splitInputString(String input) throws IllegalArgumentException{

        String[] number;
        int endIndex = -1;
        String numberInput = input;

        String separator = ",|:";
        if(input.startsWith("//")){
            endIndex = input.indexOf("\\n");

            for(int i=2; i<endIndex; i++){
                if(i==2){
                    separator += '|';
                }
                // 추후 정규식 적용을 위한 OR 연산자 추가
                char c = input.charAt(i);
                if(c == '[' || c == ']'){
                    separator += "\\\\";
                }
                separator += input.charAt(i); // 구분자 값 추출
            }
            numberInput = input.substring(endIndex+2);
        } else{
            separator = ",|:";
        }
        number = numberInput.split(separator);

        return number;
    }

    public int calculateSum(String[] numbers) {
        int sum = 0;
        if(numbers.length == 1 && numbers[0].equals("")){
            return sum;
        }
        for(int i=0; i< numbers.length; i++){
            try {
                sum += Integer.parseInt(numbers[i]);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }
}
