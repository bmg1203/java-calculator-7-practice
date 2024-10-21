package calculator.validator;

import calculator.exception.ValidatorException;

import java.util.Arrays;
import java.util.List;

import static calculator.constant.ErrorMessage.PREFIX;
import static calculator.constant.Limit.CUSTOM_SEPARATOR_LIMIT;
import static calculator.constant.Message.EMPTY;
import static calculator.constant.Message.WHITE_SPACE;

public class CustomSeparatorsValidator {
    public static final String ONE_MORE_NUMBER_REGEX = "^[0-9]+$";
    public static final String WHITE_SPACE_CANNOT_USE_AS_CUSTOM = "공백은 커스텀 구분자로 사용 불가합니다.";
    public static final String NUMBER_CANNOT_USE_AS_CUSTOM = "숫자는 커스텀 구분자로 사용 불가합니다.";
    public static final String CUSTOM_CANNOT_MORE_THAN_LIMIT = "커스텀 구분자는 2개까지만 사용 가능합니다.";
    public static final String CUSTOM_ONLY_CAN_USE_SPECIFIED = "커스텀 구분자는 지정한 것만 사용 가능합니다.";

    public void validate(List<String> customSeparator) {
        if (customSeparator.contains(EMPTY) || customSeparator.contains(WHITE_SPACE)) {
            throw new ValidatorException(PREFIX + WHITE_SPACE_CANNOT_USE_AS_CUSTOM);
        } // end if

        if (customSeparator.stream()
                .anyMatch(separator -> separator.matches(ONE_MORE_NUMBER_REGEX))) {
            throw new ValidatorException(PREFIX + NUMBER_CANNOT_USE_AS_CUSTOM);
        } // end if

        if (customSeparator.size() > CUSTOM_SEPARATOR_LIMIT) {
            throw new ValidatorException(PREFIX + CUSTOM_CANNOT_MORE_THAN_LIMIT);
        } // end if
    } // validate

    public void validateCalculatePart(List<String> customSeparator, String calculatePart) {
        Arrays.stream(calculatePart.split(EMPTY))
                .filter(string -> !string.matches(ONE_MORE_NUMBER_REGEX))
                .forEach(string -> {
                    if (!customSeparator.contains(string)) {
                        throw new ValidatorException(PREFIX + CUSTOM_ONLY_CAN_USE_SPECIFIED);
                    } // end if
                });
    } // validateCalculatePart
} // class