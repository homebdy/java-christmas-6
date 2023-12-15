package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public int readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return Integer.parseInt(input);
    }
}