package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printStartService();
        int date = readDate();
    }

    private int readDate() {
        return attemptedRead(() -> {
            outputView.printDate();
            return inputView.readDate();
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
