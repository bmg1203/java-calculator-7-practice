package calculator;

import java.util.ArrayList;
import java.util.Objects;

public class Parser {
    private static final Parser parser = new Parser();
    private ArrayList<String> separators ;
    private ArrayList<Integer> nums;

    private Parser(){
        separators = new ArrayList<String>();
        nums = new ArrayList<Integer>();
    }

    public static Parser getInstance() {
        return parser;
    }

    private void parseSeparator(String input) {

        initialSeprator();

        if(checkSeparator(input)){
               separators.add(input.substring(2,3));
        }

    }

        public void parseNums(String input){

        if(Objects.isNull(input)) {
            checkInteger("");
            return;
        }

        parseSeparator(input);

        initialNums();

        if(checkSeparator(input))
            input = input.substring(5);

        String num = "";
        for(int i=0; i<input.length(); i++){

            String currentString = input.substring(i,i+1);

            if(checkInteger(currentString)){ // 숫자가 맞는 경우
                num += currentString;
            }else{ // 구분자인 경우
                addNum(num);
                num = "";
            }
        }
        addNum(num);
    }

    private void addNum(String num) {
        if (num.equals("")) nums.add(0);
        else nums.add(Integer.parseInt(num));
    }

    private void initialSeprator(){
        separators.clear();
        separators.add(",");
        separators.add(":");
    }

    private void initialNums(){
        nums.clear();
    }

    private boolean checkSeparator(String input){
        if(input.substring(0,2).equals("//") && input.substring(3,5).equals("\\n")) return true;
        return false;
    }

    private boolean checkInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){ // 문자가 숫자가 아닌 경우 처리
            // 문자가 구분자에 속한다면,
            for(String s : separators){
                if(str.equals(s)) return false;
            }
            throw new IllegalArgumentException("Invalid input: "+ str);
        }
    }

    public ArrayList<Integer> getNums(){
        return nums;
    }
    public ArrayList<String> getSeparators() {
        return separators;
    }
}