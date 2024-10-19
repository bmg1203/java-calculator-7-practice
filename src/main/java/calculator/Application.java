package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public int addition(String[] strArr) throws IllegalArgumentException{
        int sum = 0;
        for(String number : strArr) {
            sum += Integer.parseInt(number);
        }
        return  sum;
    }

    public int solution(String str) throws IllegalArgumentException {
        int answer = 0;
        if(str.startsWith("//")) {
            String delimiter = str.substring(2,str.indexOf("\n"));
            String str2 = str.substring(str.indexOf("\n")+1);
            String[] strArr = str2.split(delimiter);
            answer = addition(strArr);
        } else {
            String[] strArr = str.split(",|:");
            answer = addition(strArr);
        }
        return  answer;
    }

    public int Custom(String str) {
        int answer = 0;
        String delimiter = str.substring(2,str.indexOf("\n"));
        String str2 = str.substring(str.indexOf("\n")+1);
        String[] strArr = str2.split(delimiter);
        answer = addition(strArr);
        return  answer;
    }

    public static void main(String[] args) {
        Application app = new Application();
        String str = Console.readLine();
        try {
            if(str.startsWith("//")) {
                System.out.println(app.Custom(str));
            } else if(str!=null && str.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(app.Separate(str));
            }
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}