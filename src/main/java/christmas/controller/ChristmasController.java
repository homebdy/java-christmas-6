package christmas.controller;

import christmas.domain.Day;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartService();
        Day date = readDate();
        List<String> order = readOrder();
    }

    private Day readDate() {
        return attemptedRead(() -> {
            outputView.printDate();
            return inputView.readDate();
        });
    }

    private List<String> readOrder() {
        return attemptedRead(() -> {
            outputView.printOrderMessage();
            return inputView.readMenu();
        });
    }

    private <T> T attemptedRead(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return supplier.get();
        }
    }
}
