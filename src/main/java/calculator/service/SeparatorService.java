package calculator.service;

import static calculator.exception.Exception.INVALID_CUSTOM_SEPARATOR_FORMAT;
import static calculator.exception.Exception.INVALID_NUMBER_SEPARATOR;
import static calculator.exception.Exception.INVALID_SEPARATOR_LENGTH;

import calculator.constants.SeparatorConstants;
import calculator.domain.Separator;

public class SeparatorService {
    private final Separator separator;

    public SeparatorService(Separator separator) {
        this.separator = separator;
    }

    public String extractAndAddSeparator(String input) {
        if (hasCustomSeparator(input)) {
            int separatorIndex = findSeparatorIndex(input);
            String customSeparator = extractCustomSeparator(input, separatorIndex);  // 커스텀 구분자 추출
            validateCustomSeparator(customSeparator);            // 커스텀 구분자가 숫자가아닌지 검증
            separator.addSeparator(customSeparator);                          // 커스텀 구분자 추가
            return trimInput(input, separatorIndex);                // 커스텀 구분자 제외 문자열 반환
        }
        return input;
    }

    private boolean hasCustomSeparator(String input) {
        return input.startsWith(SeparatorConstants.CUSTOM_SEPARATOR_PREFIX);
    }

    private int findSeparatorIndex(String input) {
        int separatorIndex = input.indexOf(SeparatorConstants.CUSTOM_SEPARATOR_SUFFIX);
        if (separatorIndex == -1) {
            throw new IllegalArgumentException(INVALID_CUSTOM_SEPARATOR_FORMAT.getMessage());
        }
        return separatorIndex;
    }

    private String extractCustomSeparator(String input, int separatorIndex) {
        return input.substring(SeparatorConstants.CUSTOM_SEPARATOR_PREFIX_LENGTH,
                separatorIndex);  // "//" 이후 "\n" 이전 구분자 추출

    }

    private String trimInput(String input, int separatorIndex) {
        return input.substring(separatorIndex
                + SeparatorConstants.CUSTOM_SEPARATOR_SUFFIX_LENGTH);  // 커스텀 구분자 뒤의 문자열 반환
    }

    public void validateCustomSeparator(String customSeparator) {
        if (customSeparator.matches("\\d")) {
            throw new IllegalArgumentException(INVALID_NUMBER_SEPARATOR.getMessage()
                    + customSeparator);
        }
        if (customSeparator.length() > SeparatorConstants.MAX_CUSTOM_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_LENGTH.getMessage()
                    + customSeparator);
        }
    }
}
