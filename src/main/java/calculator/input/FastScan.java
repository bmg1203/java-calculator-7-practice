package calculator.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FastScan {
    static BufferedReader br;

    public FastScan() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
