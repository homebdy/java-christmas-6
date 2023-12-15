package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.domain.Order;
import christmas.validator.InputValidator;

import java.util.Arrays;

public class InputView {

    private static final String SPLIT_REGEX = ",";

    private final InputValidator validator = new InputValidator();

    public Day readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Day(Integer.parseInt(input));
    }

    public Order readMenu() {
        String input = Console.readLine();
        validator.validateDelimiter(input);
        return new Order(Arrays.stream(input.split(SPLIT_REGEX)).toList());
    }
}