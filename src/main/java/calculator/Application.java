package calculator;

import calculator.dto.Data;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            String inputData = InputDataReader.getInputData();
            Data data = DataParser.parseData(inputData);
            int sum = Calculator.sum(data);
            System.out.println("결과 : " + sum);
        } finally {
            Console.close();
        }
    }
}
