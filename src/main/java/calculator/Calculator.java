package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calculator {
    private final String userInput;
    private final List<String> delimiters;
    private ArrayList<Integer> integers;

    //Generator: 기본 구별자, 유저 입력 값 설정
    public Calculator(String userInput) {
        DelimiterProcess delimiterProcess = new DelimiterProcess(userInput);
        delimiters = delimiterProcess.getDelimiters();
        this.userInput = delimiterProcess.getUserInput();
    }


    //getIntegers(): 구분자를 사용하여 문자열에서 숫자만 분리하기
    private List<Integer> getIntegers(){
        if (userInput == null) {
            return new ArrayList<Integer>(List.of(0));
        }

        //연산자 모두 합치기
        String completeDelimiter = "";
        for (String delimiter : delimiters) {
            completeDelimiter += delimiter + "|";
        }

        StringTokenizer stringTokenizer = new StringTokenizer(userInput, completeDelimiter);
        List<Integer> resultIntegers = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            int outInteger = Integer.parseInt(stringTokenizer.nextToken());
            resultIntegers.add(outInteger);
        }

        return resultIntegers;
    }

    //print(): 결과인 합을 계산
    public int printResult() {
        int sum = 0;

        for (Integer integer : getIntegers()) {
            sum += integer;
        }

        return sum;
    }

}
