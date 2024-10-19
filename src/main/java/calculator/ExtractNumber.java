package calculator;

public class ExtractNumber {

    public String input;

    public ExtractNumber(String input) {
        this.input = input;
    }

    public String[] split(){
        if(input.startsWith("//")){
            return splitByCustomExtracter();
        }
        else{
            return splitByDefaultExtracter();
        }
    }

    private String[] splitByCustomExtracter(){
        String delimiter = input.substring(2,input.indexOf("\\n"));
        if (delimiter.isEmpty() || delimiter.matches("[0-9]") || 2 <= delimiter.length()) {
            throw new IllegalArgumentException("잘못된 구분자 입력");
        }

        String numberPart=input.substring(input.indexOf("\\n")+2);
        return numberPart.split("[;,"+delimiter+"]");
    }

    private String[] splitByDefaultExtracter(){
        return input.split(",|:");
    }
}
