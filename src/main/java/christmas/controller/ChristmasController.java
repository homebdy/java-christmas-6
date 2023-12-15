package christmas.controller;

import christmas.domain.Day;
import christmas.domain.Order;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

public class ChristmasController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private EventService service;

    public void start() {
        outputView.printStartService();
        service = new EventService(readDate(), readOrder());
        printPreview();
    }

    private Day readDate() {
        return attemptedRead(() -> {
            outputView.printDate();
            return inputView.readDate();
        });
    }

    private Order readOrder() {
        return attemptedRead(() -> {
            outputView.printOrderMessage();
            return inputView.readMenu();
        });
    }

    private void printPreview() {
        outputView.printPreview();
        outputView.printNewLine();
        printResult();
    }

    private void printResult() {
        outputView.printOrderList(service.getOrder());
        printTotalBeforeDiscount();
        printGift();
        printDiscountHistory();
        printTotalDiscount();
        printPriceAfterDiscount();
        outputView.printBadge(service.getBadge());
    }

    private void printTotalBeforeDiscount() {
        outputView.printTotalBeforeDiscount(service.getOrder());
        outputView.printNewLine();
    }

    private void printGift() {
        outputView.printGift(service.getEvents());
        outputView.printNewLine();
    }

    private void printDiscountHistory() {
        outputView.printDiscount(service.getEvents());
    }

    private void printTotalDiscount() {
        outputView.printTotalDiscountPrice(service.getEvents());
        outputView.printNewLine();
    }

    private void printPriceAfterDiscount() {
        outputView.printPriceAfterDiscount(service.getEvents());
        outputView.printNewLine();
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
