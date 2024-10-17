package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.ArrayList;

public class Application {

    static Separator separator = new Separator(',',':');

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input = userInput();

        validateInput(input);

        ArrayList<BigInteger> tokens = inputParse(input);

        printAnswer(calculate(tokens));

    }

    public static String userInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void validateInput(String str){
        if(str.length()>=4 && str.startsWith("//")){
            int idx = str.indexOf("\\n");
            if(idx == -1){
                throw new IllegalArgumentException();
            }
            String customSeparator = str.substring(2,idx);

            for(int i=0;i<customSeparator.length();i++){
                separator.addSeparator(customSeparator.charAt(i));
            }
            str = str.substring(idx+2);
        }

        if(str.isEmpty()){
            return;
        }

        for(int i=0;i<str.length();i++){
            if(isDigit(str.charAt(i)) || separator.isSeparator(str.charAt(i))) continue;
            throw new IllegalArgumentException();
        }

        //연속적인 구분자
        boolean flag = false;
        for(int i=0;i<str.length();i++){
            if(separator.isSeparator(str.charAt(i))){
                if(!flag) {
                    flag = true;
                    continue;
                }
                throw new IllegalArgumentException();
            }
            flag = false;
        }

        //처음, 마지막 문자가 구분자라면 잘못된 입력
        if(separator.isSeparator(str.charAt(0)) || separator.isSeparator(str.charAt(str.length()-1))){
            throw new IllegalArgumentException();
        }

    }

    public static boolean isDigit(Character c){
        return ('0'<=c && c<='9');
    }

    public static ArrayList<BigInteger> inputParse(String input){
        int idx = input.indexOf("\\n");
        if(idx!=-1){
            input = input.substring(idx+2);
        }

        ArrayList<BigInteger> tokens = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for(char c : input.toCharArray()){
            if(separator.isSeparator(c)){
                tokens.add(new BigInteger(tmp.toString()));
                tmp.setLength(0);
            } else{
                tmp.append(c);
            }
        }

        if(!tmp.isEmpty()){
            tokens.add(new BigInteger(tmp.toString()));
        }

        return tokens;
    }

    public static BigInteger calculate(ArrayList<BigInteger> tokens){
        return tokens.stream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    public static void printAnswer(BigInteger ans){
        System.out.println("결과 : " + ans);
    }

}
