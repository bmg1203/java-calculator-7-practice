package service;

import domain.Number;

public class addOperation {
    String input;

    public int add(String input) {
        if (input == null || input.isEmpty()) { // 빈문자열일 경우 (공백이 포함되어있을 경우)
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
        if (input.startsWith("//")) {
            int startIdx = input.indexOf("//");
            int endIdx = input.indexOf("\\n"); // 구분자가 없을 경우 처리하기 !

            if (endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 올바르지 않습니다.");
            }
            delimiter = input.substring(2, endIdx);
            input = input.substring(endIdx + 1); // 구분자를 제외한 값
        }
        System.out.println("delimiter:"+delimiter);
        String[] tokens = input.split(delimiter); // 구분자 기준으로 숫자 저장하기

        int sum = 0;
        for (String token : tokens) { // 음수처리
            Number number = new Number();
            int num = number.parseConvertInt(token);
            sum += num;
        }

        return sum;

    }

}
