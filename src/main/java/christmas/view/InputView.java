package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.validator.InputValidator;

public class InputView {

    private final InputValidator validator = new InputValidator();

    public Day readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Day(Integer.parseInt(input));
    }
}