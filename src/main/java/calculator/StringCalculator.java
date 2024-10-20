package calculator;

public class StringCalculator {
    public int sumTokens(String[] tokens) {
        if (tokens.length == 1 && tokens[0].isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token); // 숫자로 변환 후 합산
        }
        return sum;
    }
}
