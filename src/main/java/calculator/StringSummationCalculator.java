package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringSummationCalculator implements Calculator<BigInteger> {

    public BigInteger calculate(String givenInput){
        BigInteger result;

        ArrayList<String> values = parse(givenInput);

        result = sum(values);
        return result;
    }


    private BigInteger sum(ArrayList<String> args){
        BigInteger result = BigInteger.ZERO;

        try{
            for (String value : args){
                int num;

                if((num = Integer.parseInt(value))< 0){
                    throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
                }

                result = result.add(BigInteger.valueOf(num));
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("올바른 정수 값이 입력되지 않았거나, 선언되지 않은 구분자가 포함되어 있습니다.");
        }

        return result;
    }

    private ArrayList<String> parse(String givenInput){
        StringSplitters stringSplitters = new StringSplitters();
        StringToken stringToken = new StringToken("//","\\\\n");
        stringSplitters.addSplittersFromToken(stringToken,givenInput);

        String removedString = stringToken.removeToken(givenInput);
        StringTokenizer tokenizer = new StringTokenizer(removedString, stringSplitters.getDelim());
        ArrayList<String> parsedArgs = new ArrayList<>();

        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            parsedArgs.add(token);
        }

        return parsedArgs;
    }
}
