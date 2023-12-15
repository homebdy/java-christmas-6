package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Day;
import christmas.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = ",";

    private final InputValidator validator = new InputValidator();

    public Day readDate() {
        String input = Console.readLine();
        validator.validateNumber(input);
        return new Day(Integer.parseInt(input));
    }

    public List<String> readMenu() {
        String input = Console.readLine();
        return Arrays.stream(input.split(SPLIT_REGEX)).toList();
    }
}