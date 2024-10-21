package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application{
    public static void main(String[] args){
/*
        ���ڿ� ���� ����
        0. ���ڿ� �Է��� readLine()�� Ȱ���Ѵ�.
        1. ���ڿ����� �����ڷ� �и��� ���ڸ� �����Ͽ� ���ϴ� ���⸦ ��������.
        2. �⺻ �����ڴ� ��ǥ(,) or �ݷ�(:)�̴�.
        3. Ŀ���� �����ڴ� //�� \n ���̿� �ۼ��Ǿ� �ִ�.
        4. ����ڰ� �߸��� ���� �Է��� ��� IllegalArgumentException�� �߻���Ų �� ����ȴ�.
*/
        try {
            System.out.println("������ ���ڿ��� �Է����ּ���.\n");

            // ���ڿ� �Է¹ޱ�
            String input = Console.readLine();

            // ���ڿ��� ����ϱ� ���� Ŭ����
            StringCalculator stringCalculator = new StringCalculator();

            // �Է� ���� ���� ���ٸ� ���� �߻���Ű��
            if(input == null) {
                throw new IllegalArgumentException();
            }

            Long output = 0L;
            // �Է� ���� ���� ���ڷ� ���۵Ǹ� : �Ǵ� ,�� ���еǾ� �ִ� ����̴�.
            if (!input.startsWith("//")) {
                output = stringCalculator.Calculator(input);
            } else if(input.charAt(0) == '/'){
                String separator = input.split("\\\\n")[0].replaceAll("/", "").strip();
                String str = input.split("\\\\n")[1];
                output = stringCalculator.Calculator(str, separator);
            }else{
                // �Է� ���� ���� :�� ,�� ���еǾ� ������ �ʰ�, //�� ���۵� ���� �ƴ� ���
                throw new IllegalArgumentException();
            }

            // ��� ����ϱ�
            System.out.println("��� : " + output);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

}
class StringCalculator {

    public Long Calculator(String str, String separator) {
        Long sum = 0L;
        Long number;
        for(String num : str.split(separator)) {
            number = Long.parseLong(num.strip());
            if(number < 0){
                throw new IllegalArgumentException();
            }else {
                sum += number;
            }
        }

        return sum;
    }

    public Long Calculator(String str) {
        Long sum = 0L;
        Long number;
        for(String num : str.split(",|:")){
            number = Long.parseLong(num.strip());
            if(number < 0){
                throw new IllegalArgumentException();
            }else {
                sum += number;
            }
        }

        return sum;
    }
}
