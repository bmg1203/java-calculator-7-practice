package calculator.domain.service;

import dto.InputDTO;

public class NormalCalculatorImpl implements NormalCalculator {

    @Override
    public int calculate(InputDTO inputDTO) {
        String input = inputDTO.getInput();
        String[] tokens = input.split(",|:");
        int sum = 0;
        for (String token : tokens) {
            //입력값에 공백이 포함된 경우에 대한 예외처리
            if (token.contains(" ")) {
                throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다.");
            }
            //token으로 잘린 값에 문자열같이 Int형으로 변환될 수 없는 것에 대한 예외처리
            try {
                int num = Integer.parseInt(tokens);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수를 입력해야 합니다.");
            }
            //조건에서 양수만 들어온다고 하였기에 음수가 들어온 경우에 대한 예외처리
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += num;
        }
        return sum;
    }
}
