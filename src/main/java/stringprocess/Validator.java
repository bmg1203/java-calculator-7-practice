package stringprocess;

import constant.ErrorMessage;

class Validator {

    private final String customSeparatorPrefix;
    private final String customSeparatorSuffix;

    //테스트 환경에서는 \n가 일반문자로 인식되지만 실제 런타임에 개행문자로 인식되는 문제가 있어 상황에 맞게 문자열을 받도록 함
    public Validator(String customSeparatorPrefix, String customSeparatorSuffix) {
        this.customSeparatorPrefix = customSeparatorPrefix;
        this.customSeparatorSuffix = customSeparatorSuffix;
    }

    public void validate(String value) {
        checkBeginOfValue(value);
        checkEndOfValue(value);
        checkCustomSeparatorFormat(value);
    }

    //문자열의 시작 확인
    private void checkBeginOfValue(String value) {
        if (value.startsWith(customSeparatorPrefix) || isPositiveNum(value.charAt(0))) {
            return;
        }

        throw new IllegalArgumentException(ErrorMessage.START_OF_INPUT_ERROR);
    }

    //문자열의 끝 확인
    private void checkEndOfValue(String value) {
        //문자열의 마지막 양수
        String lastNumber = findLastNumber(value);

        if (lastNumber != null && isPositiveNum(lastNumber.charAt(0))) {
            return;
        }

        if (value.endsWith(customSeparatorSuffix)) {
            return;
        }

        throw new IllegalArgumentException(ErrorMessage.END_OF_INPUT_ERROR);
    }


    //문자열에서 커스텀 구분자 형식 유효성 검사하기
    private void checkCustomSeparatorFormat(String value) {
        if (!value.contains(customSeparatorPrefix)) {
            return;
        }

        int start = value.indexOf(customSeparatorPrefix);
        int end = value.indexOf(customSeparatorSuffix);

        // 커스텀 구분자 선언이 //후에 \n인 형태인지,
        if (start > end) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_SEPARATOR_FORMAT_ERROR);
        }

        if (end + 2 < value.length()) {
            checkCustomSeparatorFormat(value.substring(end + 2));
        }

    }


    //char값이 1 ~ 9 사이의 양수인지 확인
    private boolean isPositiveNum(char c) {
        return c >= '1' && c <= '9';
    }

    private String findLastNumber(String value) {
        StringBuilder sb = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            if (isNum(value.charAt(i))) {
                sb.append(value.charAt(i));
            } else {
                break;
            }
        }

        return !sb.isEmpty() ? sb.reverse().toString() : null;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
