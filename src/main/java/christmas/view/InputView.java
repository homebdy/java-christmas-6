package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public String readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return input;
    }
}