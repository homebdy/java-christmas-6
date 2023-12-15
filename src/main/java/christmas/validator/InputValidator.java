package christmas.validator;

import christmas.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMBER_REGEXP = "^\\d*$";
    private static final String DELIMITER_REGEXP = "^([a-zA-Zㄱ-힣]*-[\\d]*,)*([a-zA-Zㄱ-힣]*-[\\d]*)$";

    public void validateNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage message = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public void validateDelimiter(String input) {
        if (!Pattern.matches(DELIMITER_REGEXP, input)) {
            ExceptionMessage message = ExceptionMessage.INVALID_MENU;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}