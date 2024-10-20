package calculator;

import java.util.regex.PatternSyntaxException;

public class DelimiterCheck {

    // Application에서 사용자가 입력한 수식에 대해서 구분자만 제외하고 숫자만 추출
    // 잘못 입력된 예외처리 항목에 대해서 해소
    // 커스텀 구분자를 저장, 관리
    private String inputString = "";
    private String delimiter = "[,:]";
    private String[] splitFormulaArray;
    private int[] intNumArray;
    private double[] doubleNumArray;

    public DelimiterCheck(String inputString) {
        this.inputString = inputString;
        System.out.println(inputString);
        getCustomDelimiter();
    }

    //커스텀 구분자 커맨드 입력여부 검증 로직
    private void getCustomDelimiter() {
        // 위치 추출위한 배열
        int startCustom = inputString.indexOf("//");
        int endCustom = inputString.indexOf("\\n");

        // 예) 1,2,3//+\n1+2+3
        // 계산 중간에도 커스텀 입력 가능하게 수정, 커스텀 입력위치 추출
        if (startCustom != -1 && endCustom != -1) {
            String customDelimiter = inputString.substring(startCustom + 2, endCustom);

            // 커스텀 문자열로 사용할 수 없는 문자들 예외처리
            if (customDelimiter.contains(" ") || customDelimiter.contains(".") || customDelimiter.contains("-") ||
                    customDelimiter.contains("(") || customDelimiter.contains("[") || customDelimiter.contains(
                    "{")) {
                throw new IllegalArgumentException("잘못된 구분자를 입력하셨습니다.");
            }

            delimiter = delimiter + "|" + customDelimiter;

            inputString = inputString.substring(0, startCustom) + "," + inputString.substring(endCustom + 2);
        }
        getSplitFormula();
    }


    // String 계산식에서 구분자로 숫자들을 분리
    private void getSplitFormula() {
        // 분리된 문자열을 splitFormula[] 배열로 저장, 추가) trim()으로 공백문자 지워줌
        inputString = inputString.replaceAll(" ", "");
        if (inputString.contains("-")) {
            throw new IllegalArgumentException("잘못된 구분자를 입력하셨습니다.");
        }
        // 구분자 없이 하나만 입력되었을 때 하나의 배열로만 입력
        try {
            splitFormulaArray = inputString.trim().split("\\s*" + delimiter + "\\s*");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < splitFormulaArray.length; i++) {
            if (splitFormulaArray[i].isBlank()) {
                splitFormulaArray[i] = "0";
            }
        }
        checkFloatingPointNum();
    }


    // 입력된 수들 중에서 실수가 포함되어있는지 점검 후 각 메서드로 보냄
    private void checkFloatingPointNum() {
        if (inputString.contains(".")) {
            convertToDoubleArray();
        } else {
            convertToIntArray();
        }
    }

    // String으로 저장되어있는 배열을 int 배열로 변환
    private void convertToIntArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        intNumArray = new int[splitFormulaArray.length];
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            try {
                intNumArray[i] = Integer.parseInt(beforeConvert);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }
    }

    // String으로 저장되어있는 배열을 Double 배열로 변환
    private void convertToDoubleArray() {
        // 기존 null으로 저장된 배열의 길이를 지정하고, for문 반복으로 배열 저장
        doubleNumArray = new double[splitFormulaArray.length];
        for (int i = 0; i < splitFormulaArray.length; i++) {
            String beforeConvert = splitFormulaArray[i];
            doubleNumArray[i] = Double.parseDouble(beforeConvert);
        }
    }

    // 저장된 배열을 계산기에서 메서드로 호출
    public double[] getDoubleNumArray() {
        return doubleNumArray;
    }

    public int[] getIntNumArray() {
        return intNumArray;
    }
}


