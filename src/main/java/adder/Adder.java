package adder;

import separator.Separator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Adder {

    public Integer addNumbers(ArrayList<Integer> numbers) {

        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private boolean isSeparator(String e) {

        for (char separator : Separator.separators) {
            if (e.equals(String.valueOf(separator))) {
                return true;
            }
        }

        return false;
    }

    public boolean isNumber(String number){

        try{
            Integer.parseInt(number);
            return true;

        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isAllPositiveInteger(ArrayList<Integer> numbers){
        for (int number: numbers){
            if(number < 0){
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> parseStringWithSeparators(String calculationFormula){

        ArrayList<String> parsedString = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for(int i = 0; i < calculationFormula.length(); i++) {

            char element = calculationFormula.charAt(i);
            String separator = String.valueOf(element);

            if (isSeparator(separator) && !number.isEmpty()) {
                parsedString.add(number.toString());
                number = new StringBuilder();

            } else if(isSeparator(separator)){
                parsedString.add(separator);
                continue;
            }

            number.append(element);
        }
        parsedString.add(number.toString());

        return parsedString;
    }

    public boolean isValidated(ArrayList<String> calculationFormula) {
        try {
            Stack<String> numberStack = new Stack<>();
            Stack<String> separatorStack = new Stack<>();
            Stack<String> garbageStack = new Stack<>();

            for(String element: calculationFormula){
                if(isNumber(element)){
                    numberStack.push(element);
                    if(!separatorStack.isEmpty()){
                        separatorStack.pop();
                    }
                } else if(isSeparator(element)){
                    separatorStack.push(element);
                    numberStack.pop();
                } else {
                    garbageStack.push(element);
                }
            }

            if(separatorStack.isEmpty() && garbageStack.isEmpty()){
                return true;
            }

            return false;
        } catch (EmptyStackException e){
            return false;
        }

    }

    public ArrayList<Integer> parseOnlyNumbers(ArrayList<String> calculationFormula){
        if(!isValidated(calculationFormula)) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String element: calculationFormula) {
            if(isNumber(element) && !isSeparator(element)){
                int number = Integer.parseInt(element);
                numbers.add(number);
            }
        }

        return numbers;
    }


}
